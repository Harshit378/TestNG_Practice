import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Annotations {

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class --> " + Test_Annotations.class.getName());
    }

    @Test(priority = 1, groups = {"print"})
    public void verifyTestMethod() {
        System.out.println("This is test method --> verifyTestMethod" + Test_Annotations.class.getName());
    }

    @Test(priority = 3, groups = {"sum", "print"})
    public void veritySumForNegative() {
        System.out.println("This is test method --> veritySumForNegative" + Test_Annotations.class.getName());
        Assert.assertEquals(-15, Calculator.getInstance().addTwoNumbers(-5,-10 ));
    }

    @Test(priority = 2, groups = {"sum", "print"})
    public void veritySumForDouble() {
        System.out.println("This is test method --> veritySumForDouble" + Test_Annotations.class.getName());
        Assert.assertEquals(10.2, Calculator.getInstance().addTwoNumbers(5.4,4.8 ));
    }


}
