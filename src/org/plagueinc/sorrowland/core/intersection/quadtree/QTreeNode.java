package org.plagueinc.sorrowland.core.intersection.quadtree;

import org.plagueinc.sorrowland.core.intersection.Bound2D;
import org.plagueinc.sorrowland.core.intersection.IntersectionInterface;
import org.plagueinc.sorrowland.core.intersection.Object2D;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.BiConsumer;

public class QTreeNode implements IntersectionInterface {

  private static final int MAX_OBJECTS_PER_NODE = 2;
  private static final int MAX_DEPTH = 6;
  private Map<QTreeNodeType, QTreeNode<T>> nodes;
  private int depth = 0;
  private boolean hasChildren = false;
  private Bound2D      bounds;
  private Set<T>       leafs;
  private QTreeNode<T> parentNode;

  public QTreeNode(QTreeNode<T> parentNode, Bound2D bounds, int depth) {
    this.parentNode = parentNode;
    this.bounds = bounds;
    this.leafs = new HashSet<>();
    this.nodes = new EnumMap<>(QTreeNodeType.class);
    this.depth = depth;
  }

  public QTreeNode(Bound2D bounds, int depth) {
    this(null, bounds, depth);
  }

  public QTreeNode(double minX, double minY, double maxX, double maxY, int depth) {
    this(null, minX, minY, maxX, maxY, depth);
  }

  public QTreeNode(QTreeNode<T> parentNode, double minX, double minY, double maxX, double maxY, int depth) {
    this(parentNode, new Bound2D(minX, minY, maxX, maxY), depth);
  }

  @Override
  public List retrieve(Object2D object) {
    return null;
  }

  @Override
  public void insert(Object2D object) {

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

  public Set<T> getFlatItems() {
    Set<T> items = new HashSet<>(this.leafs);

    if (this.hasChildren) {
      this.nodes().forEach((qtreeNodeType, node) -> items.addAll(node.getFlatItems()));
    }

    return items;
  }

  public Set<T> getLeafs() {
    return this.leafs;
  }

  @SuppressWarnings("unchecked")
  public void updateBelongs() {
    if (this.hasChildren) {
      if (this.getFlatItems().size() > 0) {
        this.nodes.forEach((qtreeNodeType, node) -> node.updateBelongs());
      }
    } else {
      Iterator<T> iterator = this.leafs.iterator();
      while (iterator.hasNext()) {
        T leaf = iterator.next();
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

  public boolean isBelong(T leaf) {
    return this.getBounds().contains(leaf.x(), leaf.y());
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

  public Set<T> search(Bound2D treeBound) {
    treeBound.intersects(this.bounds);
    // not implemented yet
    return null;
  }

  public Set<T> search(Rectangle rectangle) {
    return this.search(new Bound2D(rectangle.x, rectangle.y, rectangle.getMaxX(), rectangle.getMaxY()));
  }

  public void insertToParent(T object2D) throws RuntimeException {
    QTreeNode<T> node = this.getParentNode();

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

  public void insert(T object2D) {
    if (this.hasChildren) {
      this.nodes.get(this.detectNodeType(object2D)).insert(object2D);
    } else {
      if (MAX_OBJECTS_PER_NODE > this.leafs.size()) {
        this.leafs.add(object2D);
      } else if (MAX_DEPTH > this.getDepth() && this.leafs.size() >= MAX_OBJECTS_PER_NODE) {

        this.splitNode();
        this.nodes.get(this.detectNodeType(object2D)).insert(object2D);

        Iterator<T> iterator = this.leafs.iterator();
        while (iterator.hasNext()) {
          T leaf = iterator.next();
          this.nodes.get(this.detectNodeType(leaf)).insert(leaf);
          iterator.remove();
        }
      } else {
        this.leafs.add(object2D);
      }
    }
  }

  public void splitNode() {
    QTreeNode<T> nodeNorthWest = new QTreeNode<>(this.bounds.minX, this.bounds.minY, this.bounds.centreX,
        this.bounds.centreY, this.depth + 1);
    QTreeNode<T> nodeNorthEast = new QTreeNode<>(this.bounds.centreX, this.bounds.minY, this.bounds.maxX,
        this.bounds.centreY, this.depth + 1);
    QTreeNode<T> nodeSouthEast = new QTreeNode<>(this.bounds.centreX, this.bounds.centreY, this.bounds.maxX,
        this.bounds.maxY, this.depth + 1);
    QTreeNode<T> nodeSouthWest = new QTreeNode<>(this.bounds.minX, this.bounds.centreY, this.bounds.centreX,
        this.bounds.maxY, this.depth + 1);

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

  public QTreeNodeType detectNodeType(T object2D) {
    return this.detectNodeType(object2D.x(), object2D.y());
  }

  public QTreeNodeType detectNodeType(double x, double y) {
    QTreeNodeType qtreeNodeType;

    if (x > this.bounds.centreX) {
      qtreeNodeType = y > this.bounds.centreY ? QTreeNodeType.SE : QTreeNodeType.NE;
    } else {
      qtreeNodeType = y > this.bounds.centreY ? QTreeNodeType.SW : QTreeNodeType.NW;
    }

    return qtreeNodeType;
  }

  public boolean isRoot() {
    return null == this.parentNode;
  }

  public QTreeNode<T> getParentNode() {
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

  public Map<QTreeNodeType, QTreeNode<T>> nodes() {
    return this.nodes;
  }

  public String toString() {
    return String.format("QTreeNode{ bounds: %s, \ngetLeafs: %s,\n nodes: %s }", this.bounds, this.leafs.size(),
        this.nodes);
  }
}
