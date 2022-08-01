package textdemo;

public class FormatDemo {

    public static void main(String[] args) {
        String stringForDemo = "Text ";
        System.out.println(stringForDemo + "for Demo");
        String stringForDemo2 = "Text %s";
        System.out.println(String.format(stringForDemo2, "for Demo 2"));
    }
}
