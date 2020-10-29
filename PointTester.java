import java.util.Random;


public class PointTester {

  public static void main(String[] args) {
    System.out.println(testPointCreation());
  }

  public static Point createPoint() {
    Random rng = new Random();
    Point toReturn = new Point(rng.nextInt(), rng.nextInt());
    return toReturn;
  }

  public static boolean testPointCreation() {
    Point one = new Point(1, 2);
    Point two = new Point(0, 0);
    Point three = new Point(-98, -24);
    Point four = new Point(-10, 7);
    Point five = four;

    Point[] points = new Point[] {
      one, two, three, four, five
    };

    int[] xVals = new int[] {
      1, 0, -98, -10, -10
    };

    int[] yVals = new int[] {
      2, 0, -24, 7, 7
    };

    for (int i = 0; i < 5; i++) {
      if ((points[i].getX() != xVals[i]) ||
          (points[i].getY() != yVals[i])) return false;
    }

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int x = rng.nextInt();
      int y = rng.nextInt();
      Point newPoint = new Point(x, y);

      if ((newPoint.getX() != x) || (newPoint.getY() != y)) return false;
    }

    return true;
  }

  public boolean testDistance() {
    return true;
  }


}
