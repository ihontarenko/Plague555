package org.nullapp.gameCore.geometry.intersection.quadtree;

import org.nullapp.gameCore.geometry.intersection.Bound2D;
import org.nullapp.gameCore.geometry.intersection.Object2D;

import java.util.Set;

@SuppressWarnings("unused")
public class QTree {

  private QTreeNode     root;
  private Set<Object2D> items;

  public QTree(double minX, double minY, double maxX, double maxY) {
    root = new QTreeNode(new Bound2D(minX, minY, maxX, maxY), 0);
  }

  public void add(Object2D treeLeaf) {
    this.root.insert(treeLeaf);
  }

  public void clear() {
    this.root.clear();
  }

  public void execute(EachLeaf executor) {
    this.root.eachLeaf(executor);
  }

  public Set<Object2D> leafsAll() {
    if (this.items == null) {
      this.items = this.root.getFlatItems();
    }

    return this.items;
  }

  public QTreeNode rootNode() {
    return this.root;
  }

  public static QTreeNode root() {
    return null;
  }

  public void update() {
    this.root.updateBelongs();
    this.root.updateNodes();
  }

  public String toString() {
    return String.format("QTree{ rootNode: %s }", root);
  }

  @FunctionalInterface
  public interface EachLeaf {
    void execute(Object2D object2D);
  }

  @FunctionalInterface
  public interface EachNode {
    void execute(QTreeNode treeNode);
  }

}
