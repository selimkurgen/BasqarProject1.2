package utilities;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static utilities.ElementClass.$;


public class ElementsClass {

    public static ElementsClass $$(By by){ return new ElementsClass(by); }

    private WebDriver driver;
    private List<WebElement> elements;
    private By by;

    private ElementsClass(){
        this.driver = Driver.getDriver();
    }

    private ElementsClass(By by){
        this();
        this.by = by;
        elements = driver.findElements(by);
    }

    public List<WebElement> getElements(){
        return elements;
    }

    public int size(){
        return elements.size();
    }

    public ElementsClass filterByText(String text){
        List<WebElement> e = new ArrayList<>();
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(text.toLowerCase()))
                e.add(element);
        }
        elements = e;
        return this;
    }

    public ElementClass filterWithText(String text){
        List<WebElement> e = new ArrayList<>();
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().equalsIgnoreCase(text))
                e.add(element);
        }
        return $(e.get(0));
    }


}
