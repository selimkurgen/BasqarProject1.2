package pageModels;

import org.openqa.selenium.By;

public interface Locators {

    //Todo Homepage Locators
    By LoginButton = By.id("login");
    By LoginPageUserName = By.cssSelector("input[formcontrolname='username']");
    By LoginPagePassword = By.cssSelector("input[formcontrolname='password']");
    By LoginPageSubmitButton =  By.cssSelector("button.submit-button");
    By CookieDialogBox = By.cssSelector("div[role='dialog']");
    By CookieDialogButton = By.partialLinkText("Got it");

    // Todo invariant locators
    By DialogContainer = By.tagName("mat-dialog-container");
    By DialogContainerButtonClose = By.cssSelector("button[aria-label='Close dialog']");
    By DialogContainerButtonSave = By.cssSelector("mat-dialog-container ms-save-button");
    By DialogContainerButtonYes = By.xpath("//mat-dialog-container//*[contains(text(),'Yes')]");
    By DialogContainerButtonNo = By.xpath("//mat-dialog-container//*[contains(text(),'No')]");
    By DialogInputName = By.cssSelector("ms-text-field[formcontrolname='name']>input");
    By ExpenseAccoutCodePrefixesDelete=By.xpath("//*[@id=\"mat-chip-list-1\"]/div/mat-chip/mat-icon");
    By DialogInputShortName = By.cssSelector("ms-text-field[formcontrolname='shortName']>input");
    By DialogInputCode = By.cssSelector("ms-text-field[formcontrolname='code']>input");
    By PageButtonAdd = By.cssSelector("ms-add-button button");
    By PopupMessageContainer = By.xpath("//div[@id='toast-container']");
    By PageButtonSearchWithText = By.xpath("//button//*[contains(text(),'Search')]");
    By TableButtonEdit = By.cssSelector("ms-edit-button>button");
    By TableButtonDelete = By.cssSelector("ms-delete-button>button");
    By DashBoard = By.xpath("//toolbar//*[contains(text(),'Dashboard')]");


    // Todo  Page locators others

    By DialogButtonApplyWithText = By.xpath("//*[contains(text(),'Apply')]");
    By PageFormDescriptionInput = By.cssSelector("input[formcontrolname='description']");
    By PageFormVariableInput = By.cssSelector("input[formcontrolname='variable']");
    By PageFormModifierTypeSelect = By.cssSelector("mat-select[formcontrolname='modifierType']");
    By PageFormIntegrationCodeInput = By.cssSelector("mat-form-field input[data-placeholder='Integration Code']");
    By PageFormValueTypeSelect = By.cssSelector("mat-select[formcontrolname='valueType']");
    By PageFormPriorityIntInput = By.cssSelector("input[formcontrolname='priority']");
    By PageFormFormulaInput = By.cssSelector("input[formcontrolname='formula']");



    //Todo other project dialog locators
    By DialogFormCountrySelect = By.cssSelector("mat-select[formcontrolname='id']");
    By DialogFormSubjectCategorySelect = By.cssSelector("mat-select[formcontrolname='id']");
    By DialogFormStyleSelect = By.cssSelector("mat-select[formcontrolname='value']");
    By DialogFormUserTypeMultiSelect = By.cssSelector("mat-chip-list input");
    By DialogFormExpenseAccoutMultiSelect = By.cssSelector("mat-chip-list input");
    By DialogFormValidFormInput = By.cssSelector("input[name='datePickerControl'] + input");
    By DialogFormKeyInput = By.cssSelector("ms-text-field[formcontrolname='key']>input");
    By DialogFormValueIntInput = By.cssSelector("ms-integer-field[formcontrolname='value']>input"); // in Salary
    By DialogFormPeriodCountInput = By.cssSelector("ms-integer-field[formcontrolname='periodCount']>input");
    By DialogFormRowSizeCountInput = By.cssSelector("ms-integer-field[formcontrolname='rowSize']>input");
    By DialogFormColumnSizeCountInput = By.cssSelector("ms-integer-field[formcontrolname='columnSize']>input");
    By DialogFormTypeSelect = By.cssSelector("mat-select[formcontrolname='type']");
    By DialogFormOrderInput = By.cssSelector("ms-text-field[formcontrolname='orderNo']>input");
    By DialogFormFormulaVariableInput = By.cssSelector("input[data-placeholder='Formula Variable']");
    By DialogFormModifierVariableTypeSelect = By.cssSelector("mat-select[formcontrolname='type']");


    //Todo others locators
    By SalaryModifiersNewFormNameInput1= By.xpath("//input[@name='name']");
    By SalaryModifiersFormSaveButton= By.cssSelector("ms-save-button>button");
    By salaryConstantsFormNameInput=By.xpath("//input[@ name='name']");
    By NewPositionSalaryNameInput=By.cssSelector("ms-text-field[formcontrolname='title']>input");



    // Todo calender
    By Calender = By.tagName("mat-calendar");    // By.tagName("mat-datepicker-content");
    By OverlayContainer = By.cssSelector(".cdk-overlay-container");
    By CalanderPreviousYear = By.xpath("(//mat-datepicker-content//ms-custom-header//button)[1]");
    By CalanderPreviousMonth = By.xpath("(//mat-datepicker-content//ms-custom-header//button)[2]");
    By CalanderNextMonth = By.xpath("(//mat-datepicker-content//ms-custom-header//button)[3]");
    By CalanderNextYear = By.xpath("(//mat-datepicker-content//ms-custom-header//button)[4]");
    By CalanderMonthTable = By.cssSelector("mat-datepicker-content table");
    By CalanderMonthYearText = By.xpath("//mat-datepicker-content//*[@class='example-header-label']");

}
