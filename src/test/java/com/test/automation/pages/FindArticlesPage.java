package com.test.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FindArticlesPage extends PageObject {

    @FindBy(xpath = "//span[@class = 'a-size-base a-color-base' and text()='adidas']")
    WebElementFacade chkBrandAdidas;

    @FindBy(id = "p_n_condition-type/6461716011")
    WebElementFacade chkNew;

    @FindBy(id = "a-autoid-0-announce")
    WebElementFacade chbOrder;
    @FindBy(id = "s-result-sort-select_1")
    WebElementFacade lblUpward;

    String lblArticles = "//div[@class='s-expand-height s-include-content-margin s-border-bottom s-latency-cf-section']";
    String textArticle = "//span[@class='a-size-base-plus a-color-base a-text-normal']";

    public void clickChkBrandAdidas() {
        waitFor(chkBrandAdidas).isVisible();
        chkBrandAdidas.click();
    }

    public void clickChkNew() {
        waitFor(chkNew).isVisible();
        chkNew.click();
    }

    public void setChbOrder(String option) {
        waitFor(chbOrder).isVisible();
        chbOrder.click();
        switch (option) {
            case "ascendente":
                lblUpward.click();
                break;
            case "descendente":
                break;
        }
    }

    public List<WebElement> returnArticles() throws Exception {
        Thread.sleep(3000);
        List<WebElement> articles = getDriver().findElements(By.xpath(lblArticles));
        System.out.println(articles.size());
        return articles;
    }

    public List<String> textPrice(List<WebElement> articles) {
        List<String> textArticles = new ArrayList<>();
        WebElement elementArticle;
        for (WebElement article : articles) {
            System.out.println(article.getText());
            elementArticle = article.findElement(By.xpath(textArticle));
            System.out.println(elementArticle.getText());
            textArticles.add(elementArticle.getText());
        }
        return textArticles;
    }
}
