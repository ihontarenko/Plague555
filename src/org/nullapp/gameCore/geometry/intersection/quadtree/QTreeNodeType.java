package org.nullapp.gameCore.geometry.intersection.quadtree;

public enum QTreeNodeType {

  NW(1), NE(2), SE(3), SW(4);

  private int position;

  QTreeNodeType(int position) {
    this.position = position;
  }

  public int position() {
    return this.position;
  }

}
