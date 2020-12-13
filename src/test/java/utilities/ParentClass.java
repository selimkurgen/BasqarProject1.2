
package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageModels.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;


import static utilities.ElementClass.open;
import static utilities.Buttons.Yes;
import static utilities.ElementClass.$;


public class ParentClass implements Locators {

    /**
     * navigate to homepage
     */
    public void getHomePage(){
        String url = "https://test.basqar.techno.study/";
        open(url);

    }

    /**
     * this method login to the site with unoque credientals
     */
    public void login(){
        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        login(username, password);
    }

    /**
     * this method login to the site with different credentials
     * @param username username
     * @param password  password
     */
    public void login(String username, String password){

        $(LoginPageUserName).clear().setValue(username);
        $(LoginPagePassword).clear().setValue(password);
        $(LoginPageSubmitButton).click();

        if ($(CookieDialogBox).isDisplayed()) {
            $(CookieDialogButton).shouldBe(Condition.enabled).click();
        }

    }


    /**
     * this method clicks to the links on left menu
     * @param page  takes varargs from PageModelNavBar enum
     */
    public static void clickOnMenuTo(NavMenu page){

        String[] linkTexts = page.getLinks();

        String strXpath = "//fuse-nav-vertical-group/div/fuse-nav-vertical-collapsable";
        for (int i=0; i<linkTexts.length; i++) {
            if (linkTexts[i].equalsIgnoreCase("dashboard"))
                strXpath = "(//span[contains(text(),'" + linkTexts[i] + "')])[1]";
            else
                strXpath += "/a/span[contains(text(),'" + linkTexts[i] + "')]";

            By by = By.xpath(strXpath);
            $(by).scrollIntoView().shouldBe(Condition.visible).click();
            strXpath += "//ancestor::fuse-nav-vertical-collapsable/";
        }
        $(By.xpath("//toolbar//*[contains(text(),'" + page.getHeader() + "')]")).shouldBe(Condition.exists);
    }


    /**
     * verify the notification as result in text
     * @param result required result text
     */
    public void verifyNotificationAs(NotificationResults result){
        boolean val =
                $(PopupMessageContainer)
                        .find(By.xpath("//*[contains(text(),'" + result.toString() + "')]"))
                        .shouldBe(Condition.appear)
                        .getText()
                        .contains(result.toString());
        Assert.assertTrue(val);
    }
    /**
     * search in text field in page
     * @param by field selector
     * @param textToSearch text to be searched
     */
    public void searchTextIn(By by, String textToSearch){
        $(by).click();
        $(by).clear().setValue(textToSearch);
        $(PageButtonSearchWithText).click();
    }


    /**
     * clicks the dialog button
     * @param button as button enum
     */
    public void clickToDialogButton(Buttons button){
        switch (button){
            case Save:
                $(DialogContainerButtonSave).shouldBe(Condition.appear).click();
                break;
            case Yes:
                $(DialogContainerButtonYes).shouldBe(Condition.appear).click();
                break;
            case No:
                $(DialogContainerButtonNo).shouldBe(Condition.appear).click();
                break;
            case Close:
                $(DialogContainerButtonClose).shouldBe(Condition.appear).click();
                break;
            case Apply:
                $(DialogButtonApplyWithText).shouldBe(Condition.appear).click();
        }
    }


    /**
     * gets the table row of desired text
     * @param textToBeSearched  test in table row
     * @return tr as Webelement
     */
    public WebElement getTableRowWithText(String textToBeSearched){
        By byTr = By.xpath("//*[contains(text(),'" + textToBeSearched + "')]//ancestor::tr");
        return $(byTr).getElement();
    }


    /**
     * clicks the edit or delete button in table row
     * @param by selector of delete or edit button
     * @param textToSearched text in row
     */
    protected void clickToButtonInTable(By by, String textToSearched){
        WebElement row = getTableRowWithText(textToSearched);
        row.findElement(by).click();
    }


    /**
     *  delete the table data
     * @param textToBeSearched text in table row
     */
    public void deleteTableData(String textToBeSearched){
        clickToButtonInTable(TableButtonDelete, textToBeSearched);
        $(DialogContainer).shouldBe(Condition.enabled);
        clickToDialogButton(Yes);
    }


    /**
     * edit the table data
     * @param textToBeSearched text in table row
     */
    public void editTableData(String textToBeSearched){
        clickToButtonInTable(TableButtonEdit, textToBeSearched);
        $(DialogContainer).shouldBe(Condition.enabled);
    }


    /**
     * takeScreenshot
     * @param fileName fileName
     */
    public void takeScreenshot(String fileName){
        String directoryPath = "target/screenshots/";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss"));
        String filePath = directoryPath + fileName + "_" + Thread.currentThread().getName() + "_" + dt + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (Exception ignored){
            return false;
        }

    }

    public int getIntVal(String strNum){
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return Integer.MIN_VALUE;
        }
    }


    //  calender methods //////
    /**
     *
     * @param dayStr
     * @return
     */
    public static String formatDay(String dayStr){
        if (dayStr.length()==1)
            return "0" + dayStr;
        else
            return dayStr;
    }

    /**
     *
     * @param dateField
     * @param date
     */
    public void sendKeysToCalander(By dateField, LocalDate date){
        String dataToUSFormat = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        $(dateField).setValue(dataToUSFormat);
        if ($(Calender).isExist()){
            $(OverlayContainer).click();
        }
    }


    /**
     *
     * @param isoDate
     * @return
     */
    public LocalDate stringToDate(String isoDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(isoDate, formatter);
    }


    /**
     *
     * @param dateStr
     * @return
     */
    public String[] getYearMonthDayAsArray(String dateStr){
        String[] yearMonthDay = dateStr.split("-");
        LocalDate date = stringToDate(dateStr);
        yearMonthDay[1] = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
        return yearMonthDay;
    }
    /**
     *
     * @param month
     * @param monthCalender
     * @return
     */
    public int compareMonths(String month, String monthCalender){
        LinkedList<String> months =
                new LinkedList<>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));
        int indexOfMonth = months.indexOf(month);
        int indexOfMonthCalender = months.indexOf(monthCalender);
        if (indexOfMonth > indexOfMonthCalender) return 1;
        else if (indexOfMonth < indexOfMonthCalender) return -1;
        else return 0;
    }
    /**
     * calender method, compare required date and calender date,
     * month and date respectively according to calenders middle month year (JAN 2020)
     * @param monthYear required month and year
     * @param monthYearCalender calender month and year
     * @return [1,2,3,4] == [one year back, one month back, one month forward, one year forward]
     */
    public int compareMonthYear(String monthYear, String monthYearCalender){

        String month = monthYear.replaceAll("[^A-Z]+","");
        int year = Integer.parseInt(monthYear.replaceAll("[^0-9]+",""));
        String monthCalender = monthYearCalender.replaceAll("[^A-Z]+","");
        int yearCalender = Integer.parseInt(monthYearCalender.replaceAll("[^0-9]+",""));

        if (year < yearCalender) return 1;
        if (year > yearCalender) return 4;
        if (compareMonths(month, monthCalender)==-1) return 2;
        if (compareMonths(month, monthCalender)==1) return 3;
        return 0;
    }
    /**
     * calender method, to directly set date value to inoutbox
     * @param dateStr date in String type as ISO format 2020-01-01
     */
    public void setCalenderDate(String dateStr){
        String[] dateArray = getYearMonthDayAsArray(dateStr);
        String monthYear = dateArray[1] + " " + dateArray[0];
        String monthYearCalender;
        do{
            monthYearCalender = $(CalanderMonthYearText).getText().trim();
            switch (compareMonthYear(monthYear, monthYearCalender)){
                case 1: $(CalanderPreviousYear).click(); break;
                case 2: $(CalanderPreviousMonth).click(); break;
                case 3: $(CalanderNextMonth).click(); break;
                case 4: $(CalanderNextYear).click(); break;
            }
        }while (compareMonthYear(monthYear, monthYearCalender)!=0);

        String day = Integer.parseInt(dateArray[2]) + "";
        $(CalanderMonthTable).find(By.xpath("//*[text()=' " + day + " ']")).click();
    }
}


