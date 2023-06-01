import org.example.Men;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MenTest {

    private Men men;


    @BeforeMethod
    public void setUp() {
        men = new Men("Brad", "Pitt", 64);
    }

    @DataProvider(name = "partnershipProvider")
    public Object[][] partnershipProvider() {
        return new Object[][]{
                {new Woman("Angelina", "Jolie", 45)},
                {new Woman("Scarlett", "Johansson", 36)}
        };
    }

    @Test(groups = {"GettersTest"}, dataProvider = "partnershipProvider")
    public void registerPartnershipTest(Woman partner) {
        men.registerPartnership(partner);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(men.getPartner());
        softAssert.assertEquals(men.getPartner(), partner);
        softAssert.assertEquals(partner.getPartner(), men);
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
        men.setAge(age);
        Assert.assertEquals(men.isRetired(), expected);
    }
}
