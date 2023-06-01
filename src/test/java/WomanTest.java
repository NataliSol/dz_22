import org.example.Men;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTest {

    private Woman woman;


    @BeforeMethod
    public void setUp() {
        woman = new Woman("Angelina", "Jolie", 59);
    }

    @DataProvider(name = "partnershipProvider")
    public Object[][] partnershipProvider() {
        return new Object[][]{
                {new Men("Brad", "Pitt", 57)},
                {new Men("Hugh", "Jackman", 53)}
        };
    }

    @Test(groups = {"GettersTest"}, dataProvider = "partnershipProvider")
    public void registerPartnershipTest(Men partner) {
        woman.registerPartnership(partner);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(woman.getPartner());
        softAssert.assertEquals(woman.getPartner(), partner);
        softAssert.assertEquals(partner.getPartner(), woman);
        softAssert.assertAll();
    }

    @DataProvider(name = "ageProvider")
    public Object[][] ageProvider() {
        return new Object[][]{
                {45, false},
                {65, true}
        };
    }

    @Test(groups = {"GettersTest"}, dataProvider = "ageProvider")
    public void isRetiredTest(int age, boolean expected) {
        woman.setAge(age);
        Assert.assertEquals(woman.isRetired(), expected);
    }
}
