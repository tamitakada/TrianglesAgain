import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;


public class TriangleTester {

  public static void main(String[] args) {
    System.out.println(testTriangleCreation());
    System.out.println(testPerimeter());
    System.out.println(testArea());
  }

  public static Point[] createPoints() {
    Random rng = new Random();
    Point[] toReturn = new Point[3];

    for (int i = 0; i < 3; i++) {
      Point newPoint = new Point(rng.nextDouble(), rng.nextDouble());
      toReturn[i] = newPoint;
    }

    return toReturn;
  }

  public static boolean testTriangleCreation() {
    Triangle one = new Triangle(0, 0, 0, 10, 15, 0);
    Triangle two = new Triangle(-98, 3434, 99.212, -0.11, 122, -0.426);
    Triangle three = new Triangle(11.2, -2.2, -12, 100, -4.4, -900);

    if (!(one.toString().equals("v1(0.0, 0.0) v2(0.0, 10.0) v3(15.0, 0.0)"))) return false;
    if (!(two.toString().equals("v1(-98.0, 3434.0) v2(99.212, -0.11) v3(122.0, -0.426)"))) return false;
    if (!(three.toString().equals("v1(11.2, -2.2) v2(-12.0, 100.0) v3(-4.4, -900.0)"))) return false;

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      String result = "";
      result += "v1(" + points[0].getX() + ", " + points[0].getY() + ") ";
      result += "v2(" + points[1].getX() + ", " + points[1].getY() + ") ";
      result += "v3(" + points[2].getX() + ", " + points[2].getY() + ")";

      if (!(newTriangle.toString().equals(result))) return false;
    }

    return true;
  }

  public static boolean testPerimeter() {
    Triangle one = new Triangle(0, 0, 0, 1, 1, 0);
    Triangle two = one;

    if (one.getPerimeter() != (Math.sqrt(2) + 2)) return false;
    if (two.getPerimeter() != (Math.sqrt(2) + 2)) return false;

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      double legOne = points[0].distanceTo(points[1]);
      double legTwo = points[0].distanceTo(points[2]);
      double legThree = points[1].distanceTo(points[2]);

      double perimeter = legOne + legTwo + legThree;

      if (newTriangle.getPerimeter() != perimeter) return false;
    }

    return true;
  }

  public static boolean testArea() {
    Triangle one = new Triangle(0, 0, 0, 1, 1, 0);
    Triangle two = one;
    Triangle three = new Triangle(-5, 10, -5, -10, 2, -10);

    Triangle[] tests = new Triangle[] {
      one, two, three
    };

    double[] expected = new double[] {
      0.5, 0.5, 70
    };

    for (int i = 0; i < 3; i++) {
      double area = tests[i].getArea();

      DecimalFormat decForm = new DecimalFormat("#.#");
      decForm.setRoundingMode(RoundingMode.CEILING);
      double formattedArea = Double.parseDouble(decForm.format(area));

      if (formattedArea != expected[i]) return false;
    }

    for (int i = 0; i < 100; i++) {
      Point[] points = createPoints();
      Triangle newTriangle = new Triangle(points[0], points[1], points[2]);

      double legOne = points[0].distanceTo(points[1]);
      double legTwo = points[0].distanceTo(points[2]);
      double legThree = points[1].distanceTo(points[2]);

      double semiperimeter = newTriangle.getPerimeter() / 2;
      double area = Math.sqrt(
        semiperimeter *
        (semiperimeter - legOne) *
        (semiperimeter - legTwo) *
        (semiperimeter - legThree)
      );

      if (newTriangle.getArea() != area) return false;
    }

    return true;
  }

}
