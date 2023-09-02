package week2.IntroJava;

public class Edge extends Point{

    private Point A;
    private Point B;
    public Edge(double x, double y) {
        super(x, y);
    }


    public Edge(Point a, Point o) {
        super();
        this.A = a;
        this.B = o;
    }

    public double getDistance(Point A, Point B){
        return Math.sqrt(Math.pow(A.getX() - B.getX(),2) + Math.pow(A.getY()-B.getY(),2));
    }

}
