import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Dashboard {

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class --> " + Test_Dashboard.class.getName());
    }

    @Test(groups = {"print", "sum"})
    public void verifySumOfTwoNumbers() {
        System.out.println("This is test method --> verifySumOfTwoNumbers" + Test_Dashboard.class.getName());
        Assert.assertEquals(9, Calculator.getInstance().addTwoNumbers(5,4 ));
    }

    @Test(groups = {"sum"})
    public void verifySumOfTwoNumber() {
        System.out.println("This is test method --> verifySumOfTwoNumber" + Test_Dashboard.class.getName());
        Assert.assertEquals(10, Calculator.getInstance().addTwoNumbers(5,4 ));
    }


}
