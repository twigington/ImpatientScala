package chapter8.exercise7

import java.awt.{Point, Rectangle}

/**
7. Provide a class Square that extends java.awt.Rectangle and has three constructors:
    one that constructs a square with a given corner point and width,
    one that constructs a square with corner (0,0) and a given width, and
    one that constructs a square with a corner(0,0) and a width 0.
 */
class Square(width: Int = 0, corner: Point = new Point(0,0)) extends Rectangle(corner.x, corner.y, width, width)
