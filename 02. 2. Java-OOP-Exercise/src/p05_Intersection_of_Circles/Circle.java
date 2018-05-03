package p05_Intersection_of_Circles;

public class Circle {

   private Point center;
   private int radius;

    public Circle(Point center, int radius) {
        this.setCenter(center);
        this.setRadius(radius);
    }


    public Point getCenter() {
        return this.center;
    }

    private void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return this.radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }
}
