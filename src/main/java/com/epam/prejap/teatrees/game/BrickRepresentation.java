package com.epam.prejap.teatrees.game;

enum BrickRepresentation {
  EMPTY(' '),
  SHADOW('.'),
  BRICK('#');

  static BrickRepresentation fromDot(byte dot) {
    return dot == 0 ? EMPTY : (dot == SHADOW.repr ? SHADOW : BRICK);
  }

  private final char repr;

  BrickRepresentation(char repr) {
    this.repr = repr;
  }

  byte asByte() { return (byte)repr; }
}
