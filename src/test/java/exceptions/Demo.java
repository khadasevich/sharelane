package exceptions;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws TriangleImpossibleException {
        double a, b, c;
        Scanner in = new Scanner(System.in);

        System.out.print("a = ");
        a = in.nextDouble();
        System.out.print("b = ");
        b = in.nextDouble();
        System.out.print("c = ");
        c = in.nextDouble();

        Triangle tr = new Triangle(a,b,c);
        double area = tr.getArea();
        System.out.println("area = " + area);

        in.close();
    }
}

