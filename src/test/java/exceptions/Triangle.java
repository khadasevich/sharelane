package exceptions;

public class Triangle {

    private double a, b, c;

    public Triangle(double a, double b, double c) throws TriangleImpossibleException {
        this.a = a;
        this.b = b;
        this.c = c;
        if (((a + b) < c) || ((a + c) < b) || ((b + c) < a)) {
            throw new TriangleImpossibleException();
        }
    }

    public double getArea() {
        double p, s;
        p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
