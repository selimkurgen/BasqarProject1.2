package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static utilities.ElementsClass.$$;


public class ElementClass {
    /**
     * static method that returns basqar element
     * @param by locator
     * @return Basqar element
     */
    public static ElementClass $(By by){ return new ElementClass(by); }

    /**
     * static method that returns basqar element
     * @param e WebElement
     * @return Basqar element
     */
    public static ElementClass $(WebElement e){ return new ElementClass(e); }

    /**
     * static method that opens url
     * @param url url as string
     */
    public static void open(String url){ new ElementClass().openUrl(url); }

    /**
     * instance variables
     */
    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;
    private By by;
    private final String listOfOptions_css = "div[role='listbox'] mat-option>span";

    /**
     * constructor with no parameter
     */
    private ElementClass(){
        this.driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * constructor with a By parameter
     * @param by gets selector
     */
    private ElementClass(By by){
        this();
        this.by = by;
        element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).get(0);
        if (element == null) {
            elementNotFound();
        }
    }

    /**
     * constructor with a WebElement parameter
     * @param e gets element
     */
    private ElementClass(WebElement e){
        this();
        this.element = e;
        element = wait.until(ExpectedConditions.visibilityOfAllElements(element)).get(0);
    }

    /**
     * instance openUrl method
     * @param url gets url as string
     */
    private void openUrl(String url){
        driver.get(url);
    }

    /**
     * click to element void method
     */
    public ElementClass click(){
        element.click();
        return this;
    }

    /**
     * sendkeys method
     * @param text takes a string
     * @return BasqarElement
     */
    public ElementClass setValue(String text){
        element.sendKeys(text);
        return this;
    }

    /**
     * pressEnter void method
     */
    public void pressEnter(){
        element.sendKeys(Keys.ENTER);
    }

    /**
     * pressEscape void method
     */
    public void pressEscape(){
        element.sendKeys(Keys.ESCAPE);
    }

    /**
     * element clear method
     * @return BasqarElement
     */
    public ElementClass clear(){
        element.clear();
        return this;
    }

    /**
     * if element is exists
     * @return true if element is exists
     */
    public boolean isExist(){
        return driver.findElements(by).size()>0;
    }

    /**
     * if element is displayed
     * @return true if it is displayed
     */
    public boolean isVisible(){
        try {
            element.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * if element is enabled
     * @return true if element is enabled
     */
    public boolean isEnabled(){
        try {
            element.isEnabled();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * if element is displayed
     * @return true if element is enabled
     */
    public boolean isDisplayed(){
        try {
            element.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }
    }


    /**
     * if menu dialog is hidden
     * @return true if menu dialog is hidden
     */
    public boolean isMenuHidden(){
        String script = "return arguments[0].getAttribute(\"class\");";
        String ret = ((JavascriptExecutor) driver)
                .executeScript(script, element).toString();
        return !(ret.contains("unfolded") || ret.contains("open"));
    }

    /**
     * simple assertion conditions
     * @param cond Condition type enum
     * @return BasqarElement
     */
    public ElementClass shouldBe(Condition cond){
        switch (cond){
            case exists:
                try {
                    element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).get(0);
                }catch (Exception e){
                    elementNotFound();
                }
                break;
            case visible:
            case appear:
                try {
                    element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)).get(0);
                }catch (Exception e){
                    elementNotFound();
                }
                break;
            case clickable:
            case enabled:
                try {
                    element = wait.until(ExpectedConditions.elementToBeClickable(element));
                }catch (Exception e){
                    elementNotFound();
                }
                break;
            case disappear:
            case invisible:
                try {
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
                }catch (Exception e){
                    elementNotFound();
                }
                break;
        }
        return this;
    }

    /**
     * scrollIntoView
     * @return BasqarElement
     */
    public ElementClass scrollIntoView(){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    /**
     * returns the text of element
     * @return string
     */
    public String getText(){
        shouldBe(Condition.visible);
        return element.getText();
    }

    /**
     * return WebElement of BasqarElement
     * @return WebElement
     */
    public WebElement getElement(){
        return element;
    }

    /**
     * find an element in BasqarElement
     * @param by locator of inner element
     * @return BasqarElement
     */
    public ElementClass find(By by){
        WebElement e = element;
        this.by = by;
        element = e.findElement(by);
        return this;
    }

    /**
     * if the element contains required text
     * @param text String
     * @return boolean
     */
    public boolean containsText(String text){
        return element.getText().toLowerCase().contains(text.toLowerCase());
    }

    /**
     * method that throws RuntimeError
     */
    private void elementNotFound(){
        throw new RuntimeException("Failed to find the element located : ' " + by.toString() + " '");
    }

    /**
     * select the basqar option with text
     * @param visibleText visible text
     */
    public void selectOptionWithText(String visibleText){
        $(by).click();
        List<WebElement> list = $$(By.cssSelector(listOfOptions_css)).getElements();
        for (WebElement e : list){
            String text = e.getText();
            if (text.contains(visibleText)) {
                e.click();
                break;
            }
        }
    }

    /**
     * select the basqar option with option index
     * @param optionIndex index of option
     */
    public void selectOptionWithIndex(int optionIndex){
        $(by).click();
        List<WebElement> e = $$(By.cssSelector(listOfOptions_css)).getElements();

        if (optionIndex >= e.size())
            optionIndex = e.size()-1;
        else if (optionIndex < 0)
            optionIndex = 0;

        e.get(optionIndex).click();
    }
}
