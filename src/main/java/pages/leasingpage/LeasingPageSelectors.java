package pages.leasingpage;

public class LeasingPageSelectors {

    protected static String acceptCookiesButtonXpathSelector = "//a[contains(text(),'Sutinku')]";

    protected static String getLabelSelector(String labelId) {
        return String.format("(//label[contains(@for, '%s')])[1]", labelId);
    }

    protected static String getInputSelector(String labelId) {
        return getLabelSelector(labelId)+"/../following-sibling::div/input";
    }

    protected static String getSelectSelector(String labelId) {
        return getLabelSelector(labelId)+"/../following-sibling::div//select";
    }

    protected static String getResultValueSelector(String labelId) {
        return String.format("//span[contains(@data-name, '%s')]", labelId);
    }

    protected static String getResultLabelSelector(String labelId) {
        return getResultValueSelector(labelId)+"/../preceding-sibling::div/label";
    }

    protected static String getButtonSelector(String buttonText) {
        return String.format("//button[contains(text(),'%s')]", buttonText);
    }

    protected static String getInvalidInputSelector(String labelId) {
        return getLabelSelector(labelId)+"/../following-sibling::div/label[contains(@class, 'error')]";
    }

}
