package pages.leasingpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelpers;

import static pages.leasingpage.LeasingPageSelectors.*;

public class LeasingPage {

    private WebDriver driver;
    private ElementHelpers elementHelpers;

    public LeasingPage(WebDriver driver, ElementHelpers elementHelpers) {
        this.driver = driver;
        this.elementHelpers = elementHelpers;
        acceptCookiesAndSwitchToIframe();
    }

    private void acceptCookiesAndSwitchToIframe() {
        elementHelpers.clickElement(acceptCookiesButtonXpathSelector);
        driver.switchTo().frame("calculator-frame-06");
    }

    private void assertLabel(String expectedValue, String labelId) {
        elementHelpers.assertElementValue(expectedValue, getLabelSelector(labelId));
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

    private void assertResultLabel(String expectedValue, String labelId) {
        elementHelpers.assertElementValue(expectedValue, getResultLabelSelector(labelId));
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

    private void assertResultValue(String expectedValue, String labelId){
        elementHelpers.assertElementValue(expectedValue, getResultValueSelector(labelId));
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

    private void clickButton(String buttonText){
        elementHelpers.clickElement(getButtonSelector(buttonText));
    }

    private void clearInput(String labelId){
        elementHelpers.clearValue(getInputSelector(labelId));
    }

    private void checkIfElementExistsOnScreen(String labelId) {
        elementHelpers.getElement(getInvalidInputSelector(labelId));
    }

    private void inputValue(String input, String labelId){
        elementHelpers.enterValue(getInputSelector(labelId), input);
    }

    private void selectDropdown(String labelId, int optionFromTop) {
        Select dropdown = new Select(elementHelpers.getElement(getSelectSelector(labelId)));
        dropdown.selectByIndex(optionFromTop);
    }

    private void assertInputValidationText(String expectedMessage, String labelId) {
        elementHelpers.assertElementValue(expectedMessage, getInvalidInputSelector(labelId));
    }

    public void assertSumInputValidationMessage(String input, String validationMessage) {
        inputValue(input, "summa");
        clickButton("Skaičiuoti");
        assertInputValidationText(validationMessage, "summa");
    }

    private void assertInputValidation(String labelId) {
        clearInput(labelId);
        clickButton("Skaičiuoti");
        checkIfElementExistsOnScreen(labelId);
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
        clickButton("Skaičiuoti");
    }

}
