import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_ParallelTwo {

    @Test()
    @Parameters({"number1", "number2"})
    public void veritySumForNegative(int num1, int num2) {
        System.out.println("This is test method --> Test_ParallelTwo --> veritySumForNegative " + Test_Annotations.class.getName());
        Assert.assertEquals(-15, Calculator.getInstance().addTwoNumbers(num1, num2));
    }

    @Test()
    @Parameters({"number3", "number4"})
    public void veritySumForDouble(double num1, double num2) {
        System.out.println("This is test method --> Test_ParallelTwo --> veritySumForDouble" + Test_Annotations.class.getName());
        Assert.assertEquals(10.2, Calculator.getInstance().addTwoNumbers(num1,num2));
    }
}
