package org.nullapp.gameCore.geometry.intersection.quadtree;

import org.nullapp.gameCore.geometry.Bound2D;
import org.nullapp.gameCore.geometry.intersection.IntersectionInterface;
import org.nullapp.gameCore.geometry.Object2D;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.BiConsumer;

public class QTreeNode implements IntersectionInterface<Object2D> {

  private static final int MAX_OBJECTS_PER_NODE = 2;
  private static final int MAX_DEPTH = 6;
  private Map<QTreeNodeType, QTreeNode> nodes;
  private int depth = 0;
  private boolean hasChildren = false;
  private Bound2D       bounds;
  private Set<Object2D> leafs;
  private QTreeNode     parentNode;

  public QTreeNode(QTreeNode parentNode, Bound2D bounds, int depth) {
    this.parentNode = parentNode;
    this.bounds = bounds;
    this.leafs = new HashSet<>();
    this.nodes = new EnumMap<>(QTreeNodeType.class);
    this.depth = depth;
  }

  public QTreeNode(Bound2D bounds, int depth) {
    this(null, bounds, depth);
  }

  public QTreeNode(int minX, int minY, int maxX, int maxY, int depth) {
    this(null, minX, minY, maxX, maxY, depth);
  }

  public QTreeNode(QTreeNode parentNode, int minX, int minY, int maxX, int maxY, int depth) {
    this(parentNode, new Bound2D(minX, minY, maxX, maxY), depth);
  }

  public void eachLeaf(QTree.EachLeaf eachLeaf) {
    this.getFlatItems().forEach(eachLeaf::execute);
  }

  @SuppressWarnings("unchecked")
  public void eachNode(QTree.EachNode eachNode) {
    BiConsumer<BiConsumer, QTreeNode> nodeExecute = (consumer, node) -> {
      eachNode.execute(node);
      node.nodes().forEach((nodeType, innerNode) -> consumer.accept(consumer, innerNode));
    };
    nodeExecute.accept(nodeExecute, this);
  }

  public Set<Object2D> getFlatItems() {
    Set<Object2D> items = new HashSet<>(this.leafs);

    if (this.hasChildren) {
      this.nodes().forEach((qtreeNodeType, node) -> items.addAll(node.getFlatItems()));
    }

    return items;
  }

  public Set<Object2D> getLeafs() {
    return this.leafs;
  }

  @SuppressWarnings("unchecked")
  public void updateBelongs() {
    if (this.hasChildren) {
      if (this.getFlatItems().size() > 0) {
        this.nodes.forEach((qtreeNodeType, node) -> node.updateBelongs());
      }
    } else {
      Iterator<Object2D> iterator = this.leafs.iterator();
      while (iterator.hasNext()) {
        Object2D leaf = iterator.next();
        if (!this.isBelong(leaf)) {
          iterator.remove();
          this.insertToParent(leaf);
        }
      }
    }
  }

  public void updateNodes() {
    if (this.hasChildren) {
      if (this.getFlatItems().size() == 0) {
        this.nodes.forEach(this.nodes::remove);
        this.hasChildren = false;
      } else {
        this.nodes.forEach((qtreeNodeType, node) -> node.updateNodes());
      }
    }
  }

  public boolean isBelong(Object2D leaf) {
    return this.getBounds().contains(leaf.getX(), leaf.getY());
  }

  public void clear() {
    this.leafs.clear();

    if (this.hasChildren) {
      for (QTreeNodeType qtreeNodeType : QTreeNodeType.values()) {
        this.nodes.get(qtreeNodeType).clear();
      }
    }

    this.hasChildren = false;
    this.nodes.clear();
  }

  public Set<Object2D> search(Bound2D treeBound) {
    treeBound.intersects(this.bounds);
    // not implemented yet
    return null;
  }

  public void insertToParent(Object2D object2D) throws RuntimeException {
    QTreeNode node = this.getParentNode();

    if (this.isRoot()) {
      this.insert(object2D);
    } else {
      if (node.isBelong(object2D)) {
        node.insert(object2D);
      } else {
        node.insertToParent(object2D);
      }
    }
  }

  @Override
  public void insert(Object2D object2D) {
    if (this.hasChildren) {
      this.nodes.get(this.detectNodeType(object2D)).insert(object2D);
    } else {
      if (MAX_OBJECTS_PER_NODE > this.leafs.size()) {
        this.leafs.add(object2D);
      } else if (MAX_DEPTH > this.getDepth() && this.leafs.size() >= MAX_OBJECTS_PER_NODE) {

        this.splitNode();
        this.nodes.get(this.detectNodeType(object2D)).insert(object2D);

        Iterator<Object2D> iterator = this.leafs.iterator();
        while (iterator.hasNext()) {
          Object2D leaf = iterator.next();
          this.nodes.get(this.detectNodeType(leaf)).insert(leaf);
          iterator.remove();
        }
      } else {
        this.leafs.add(object2D);
      }
    }
  }

  @Override
  public List<Object2D> retrieve(Object2D object) {
    return null;
  }

  public void splitNode() {
    QTreeNode nodeNorthWest = new QTreeNode(this.bounds.getX(), this.bounds.getY(), this.bounds.getCentreX(),
        this.bounds.getCentreY(), this.depth + 1);
    QTreeNode nodeNorthEast = new QTreeNode(this.bounds.getCentreX(), this.bounds.getY(), this.bounds.getMaxX(),
        this.bounds.getCentreY(), this.depth + 1);
    QTreeNode nodeSouthEast = new QTreeNode(this.bounds.getCentreX(), this.bounds.getCentreY(), this.bounds.getMaxX(),
        this.bounds.getMaxY(), this.depth + 1);
    QTreeNode nodeSouthWest = new QTreeNode(this.bounds.getX(), this.bounds.getCentreY(), this.bounds.getCentreX(),
        this.bounds.getMaxY(), this.depth + 1);

    this.nodes.put(QTreeNodeType.NW, nodeNorthWest);
    this.nodes.put(QTreeNodeType.NE, nodeNorthEast);
    this.nodes.put(QTreeNodeType.SE, nodeSouthEast);
    this.nodes.put(QTreeNodeType.SW, nodeSouthWest);

    this.hasChildren = true;
  }

  public QTreeNodeType detectNodeType(Rectangle rectangle) {
    int x = (int) rectangle.getCenterX();
    int y = (int) rectangle.getCenterY();

    return this.detectNodeType(x, y);
  }

  public QTreeNodeType detectNodeType(Object2D object2D) {
    return this.detectNodeType(object2D.getX(), object2D.getY());
  }

  public QTreeNodeType detectNodeType(double x, double y) {
    QTreeNodeType qtreeNodeType;

    if (x > this.bounds.getCentreX()) {
      qtreeNodeType = y > this.bounds.getCentreY() ? QTreeNodeType.SE : QTreeNodeType.NE;
    } else {
      qtreeNodeType = y > this.bounds.getCentreY() ? QTreeNodeType.SW : QTreeNodeType.NW;
    }

    return qtreeNodeType;
  }

  public boolean isRoot() {
    return null == this.parentNode;
  }

  public QTreeNode getParentNode() {
    return this.parentNode;
  }

  public int getDepth() {
    return this.depth;
  }

  public Bound2D getBounds() {
    return this.bounds;
  }

  public boolean hasChildren() {
    return this.hasChildren;
  }

  public Map<QTreeNodeType, QTreeNode> nodes() {
    return this.nodes;
  }

  public String toString() {
    return String.format("QTreeNode{ bounds: %s, \ngetLeafs: %s,\n nodes: %s }", this.bounds, this.leafs.size(),
        this.nodes);
  }
}
