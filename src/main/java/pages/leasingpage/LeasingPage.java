package pages.leasingpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelpers;

import static pages.leasingpage.LeasingPageSelectors.*;

public class LeasingPage {

    private WebDriver driver;
    private ElementHelpers elementHelpers;

    public LeasingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.elementHelpers = new ElementHelpers(driver, wait);
    }

    public void acceptCookiesAndSwitchToIframe() {
        elementHelpers.clickElement(acceptCookiesButtonXpathSelector);
        driver.switchTo().frame("calculator-frame-06");
    }

    private void assertLabel(String expectedValue, String id) {
        elementHelpers.assertElementValue(expectedValue, getLabelSelector(id));
    }

    public void assertSumLabel(String expectedLabel) {
        assertLabel(expectedLabel, "summa");
    }

    public void assertInterestLabel(String expectedLabel) {
        assertLabel(expectedLabel, "likme");
    }

    public void assertTermLabel(String expectedLabel) {
        assertLabel(expectedLabel, "termins");
    }

    public void assertDownpaymentLabel(String expectedLabel) {
        assertLabel(expectedLabel, "maksa");
    }

    public void assertCarValueLabel(String expectedLabel) {
        assertLabel(expectedLabel, "rest");
    }

    private void assertResultLabel(String expectedValue, String id) {
        elementHelpers.assertElementValue(expectedValue, getResultLabelSelector(id));
    }

    public void assertMonthlyLabel(String expectedLabel){
        assertResultLabel(expectedLabel,"monthly_payment");
    }

    public void assertCommisionLabel(String expectedLabel){
        assertResultLabel(expectedLabel,"commision");
    }

    public void assertPaymentLabel(String expectedLabel){
        assertResultLabel(expectedLabel,"maksa");
    }

    private void assertResultValue(String expectedValue, String id){
        elementHelpers.assertElementValue(expectedValue, getResultValueSelector(id));
    }

    public void assertMonthlyPaymentValue(String expectedValue) {
        assertResultValue(expectedValue, "monthly_payment");
    }

    public void assertCommisionValue(String expectedValue) {
        assertResultValue(expectedValue, "commision");
    }

    public void assertPaymentValue(String expectedValue) {
        assertResultValue(expectedValue, "maksa");
    }

    public void assertCalculationResult(String monthlyPayment, String commision, String payment) {
        assertMonthlyPaymentValue(monthlyPayment);
        assertCommisionValue(commision);
        assertPaymentValue(payment);
    }

    private void clickButton(int buttonFromLeft){
        elementHelpers.clickElement(getButtonSelector(buttonFromLeft));
    }

    private void clearInput(String id){
        elementHelpers.clearValue(getInputSelector(id));
    }

    private void checkIfElementExistsOnScreen(String id) {
        elementHelpers.getElement(getInvalidInputSelector(id));
    }

    private void inputValue(String input, String id){
        elementHelpers.enterValue(getInputSelector(id), input);
    }

    private void selectDropdown(String id, int optionFromTop) {
        Select dropdown = new Select(elementHelpers.getElement(getSelectSelector(id)));
        dropdown.selectByIndex(optionFromTop);
    }

    private void assertInputValidationText(String expectedMessage, String id) {
        elementHelpers.assertElementValue(expectedMessage, getInvalidInputSelector(id));
    }

    public void assertSumInputValidationMessage(String input, String validationMessage) {
        inputValue(input, "summa");
        clickButton(1);
        assertInputValidationText(validationMessage, "summa");
    }

    private void assertInputValidation(String inputID) {
        clearInput(inputID);
        clickButton(1);
        checkIfElementExistsOnScreen(inputID);
    }

    public void assertSumValidation() {
        assertInputValidation("summa");
    }

    public void assertInterestValidation() {
        assertInputValidation("likme");
    }

    public void assertDownpaymentValidation() {
        assertInputValidation("maksa");
    }

    public void assertCarValueValidation() {
        assertInputValidation("rest");
    }

    public void fillFormAndSubmit(String sum, String interest, int termOption, int downPaymentOption, String downPayment, String carValue) {
        inputValue(sum, "summa");
        inputValue(interest, "likme");
        selectDropdown("termins", termOption);
        selectDropdown("maksa", downPaymentOption);
        inputValue(downPayment, "maksa");
        inputValue(carValue, "rest");
        clickButton(1);
    }

}
