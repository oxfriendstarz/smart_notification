package com.buster;

public class Profile {

  private String type;
  private int length;
  private int height;

  public Profile(String type, int length, int height) {
    this.type = type;
    this.length = length;
    this.height = height;
  }

  public String getType() {
    return type;
  }

  public int getLength() {
    return length;
  }

  public int height() {
    return height;
  }
}
