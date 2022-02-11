package pages.leasingpage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.leasingpage.LeasingPage;
import util.WebDriverFactory;

import static configproperties.DriverProperties.pathToSeleniumExe;
import static configproperties.DriverProperties.urlToOpen;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LeasingPageTest {

    private WebDriverFactory webDriverFactory;
    private LeasingPage leasingPage;

    @BeforeAll
    public void preConditionTestClassLevel() {
        webDriverFactory = new WebDriverFactory(pathToSeleniumExe, urlToOpen);
        leasingPage = new LeasingPage(webDriverFactory.getDriver(), webDriverFactory.getElementHelpers());
    }

    @AfterAll
    public void postConditionTestCase() {
        webDriverFactory.quitDriver();
    }

    @Test
    public void verifySumLabel() {
        leasingPage.assertSumLabel("Automobilio kaina");
    }

    @Test
    public void verifyInterestLabel() {
        leasingPage.assertInterestLabel("Palūkanos");
    }

    @Test
    public void verifyTermLabel() {
        leasingPage.assertTermLabel("Lizingo laikotarpis");
    }

    @Test
    public void verifyDownPaymentLabel() {
        leasingPage.assertDownpaymentLabel("Pradinė įmoka");
    }

    @Test
    public void verifyCarValueLabel() {
        leasingPage.assertCarValueLabel("Likutinė vertė");
    }

    @Test
    public void verifyMonthlyLabel() {
        leasingPage.assertMonthlyLabel("Lizingo įmoka");
    }

    @Test
    public void verifyCommisionLabel() {
        leasingPage.assertCommisionLabel("Administracinis mokestis");
    }

    @Test
    public void verifyPaymentLabel() {
        leasingPage.assertPaymentLabel("Pradinė įmoka");
    }

    @Test
    public void verifySumValidationMessageTest() {
        leasingPage.assertSumInputValidationMessage("1000", "Mažiausia turto kaina – nuo 8 000 EUR");
    }

    @Test
    public void verifyValidCalculationTest() {
        leasingPage.fillFormAndSubmit("10000", "20", 3, 1, "300", "50");
        leasingPage.assertCalculationResult("226.36", "200.00", "300.00");
    }

    @Test
    public void verifySumValidationTest() {
        leasingPage.assertSumValidation();
    }

    @Test
    public void verifyInterestValidationTest() {
        leasingPage.assertInterestValidation();
    }

    @Test
    public void verifyDownpaymentValidationTest() {
        leasingPage.assertDownpaymentValidation();
    }

    @Test
    public void verifyCarValueValidationTest() {
        leasingPage.assertCarValueValidation();
    }

}

