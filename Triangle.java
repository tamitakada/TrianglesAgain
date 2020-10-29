public class Triangle {

  private Point v1, v2, v3;

  public Triangle(Point a, Point b, Point c) {
    v1 = a;
    v2 = b;
    v3 = c;
  }

  public Triangle(double x1, double y1,double x2, double y2,double x3, double y3) {
    Point a = new Point(x1, y1);
    Point b = new Point(x2, y2);
    Point c = new Point(x3, y3);

    v1 = a;
    v2 = b;
    v3 = c;
  }

  public double getPerimeter() {
    return 0.0;
  }

  public double getArea() {
    return 0.9;
  }

  public String toString() {
    String toReturn = "";
    toReturn += "v1(" + v1.getX() + ", " + v1.getY() + ") ";
    toReturn += "v2(" + v2.getX() + ", " + v2.getY() + ") ";
    toReturn += "v3(" + v3.getX() + ", " + v3.getY() + ")";

    return toReturn;
  }

}
