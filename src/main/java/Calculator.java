public class Calculator {

    private static Calculator calci;

    public static Calculator getInstance() {
        if (calci == null) {
            return new Calculator();
        }
        return calci;
    }

    public int addTwoNumbers(int a, int b) {
        System.out.println("a --> " + a);
        System.out.println("b --> " + b);
        System.out.println("a + b --> " + (a + b));
        return a + b;
    }

    public double addTwoNumbers(double a, double b) {
        System.out.println("a --> " + a);
        System.out.println("b --> " + b);
        System.out.println("a + b --> " + (a + b));
        return a + b;
    }

}