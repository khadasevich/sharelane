package exceptions;

public class TriangleImpossibleException extends Exception {

    @Override
    public String toString() {
        return "Error: bad sides, triangle impossible, check your input";
    }
}
