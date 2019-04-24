import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Paratmeters {

    /**
     * Read values from xml file using parameter tag
     * Parameters are defined as string with key value pair
     * Parameters can be defined under test tag for particular classes OR
     * Can be defined under Suite tag for all the test
     */
    @BeforeClass
    @Parameters({"browser", "platform"})
    public void setUp(String browser, String platform) {
        System.out.println("Before Class --> " + Test_Paratmeters.class.getName());
        System.out.println("Parameter from xml file browser: " + browser);
        System.out.println("Parameter from xml file platform: " + platform);
    }

    @Test(groups = {"print"})
    @Parameters({"response"})
    public void verifyTestMethod(int responseCode) {
        System.out.println("Parameter from xml file platform: " + responseCode);
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
