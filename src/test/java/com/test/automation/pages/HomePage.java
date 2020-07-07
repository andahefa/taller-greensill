package com.test.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.amazon.com/")
public class HomePage extends PageObject {

    @FindBy(id = "twotabsearchtextbox")
    WebElementFacade inputFindArticle;

    @FindBy(xpath = "//*[@value = 'Ir']")
    WebElementFacade btnGo;

    public void setArticle(String type) {
        waitFor(inputFindArticle).isVisible();
        inputFindArticle.sendKeys(type);
    }

    public void clickBtnGo() {
        waitFor(btnGo).isVisible();
        btnGo.click();
    }
}
