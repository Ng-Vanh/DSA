package week2.IntroJava;

public class Main {
    public static void main(String[] args) {
        Point A = new Point(3,4);
        Point O = new Point(0,0);

        Edge OA = new Edge(A,O);
        System.out.println(OA.getDistance(A,O));
    }
}
