package pages.leasingpage;

public class LeasingPageSelectors {

    protected static String acceptCookiesButtonXpathSelector = "//div[@class='p-3 seb-cookie-consent seb-cookiemessage']/div[4]//a[1]";

    protected static String getLabelSelector(String id) {
        return String.format("(//label[contains(@for, '%s')])[1]", id);
    }

    protected static String getInputSelector(String id) {
        return getLabelSelector(id)+"/../following-sibling::div/input";
    }

    protected static String getSelectSelector(String id) {
        return getLabelSelector(id)+"/../following-sibling::div//select";
    }

    protected static String getResultValueSelector(String id) {
        return String.format("//span[contains(@data-name, '%s')]", id);
    }

    protected static String getResultLabelSelector(String id) {
        return getResultValueSelector(id)+"/../preceding-sibling::div/label";
    }

    protected static String getButtonSelector(int buttomFromLeft) {
        return String.format("(//button)[%s]", buttomFromLeft);
    }

    protected static String getInvalidInputSelector(String id) {
        return getLabelSelector(id)+"/../following-sibling::div/label[contains(@class, 'error')]";
    }

}
