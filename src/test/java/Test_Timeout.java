import org.testng.annotations.Test;

public class Test_Timeout {

    /**
     * This test will not be executed as enabled property is set to false
     */
    @Test(enabled = false)
    public void disableThis() {
        System.out.println("This will not be executed --> " + Test_Timeout.class.getName());
    }

    /**
     * This test will fail if its execution > timeOut time
     * Time is mentioned in milli seconds
     */
    @Test(timeOut = 200)
    public void enableThis() throws InterruptedException {
        System.out.println("This will be executed --> " + Test_Timeout.class.getName());
        Thread.sleep(100);
    }

}
