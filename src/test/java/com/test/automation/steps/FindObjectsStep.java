package com.test.automation.steps;

import com.test.automation.pages.FindArticlesPage;
import com.test.automation.pages.HomePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindObjectsStep {

    HomePage homePage;
    FindArticlesPage findArticlesPage;

    @Step("Se ingresa a la pagina de amazon")
    public void openPage() {
        homePage.open();
    }

    @Step("Se ingresa el articulo - {0}")
    public void setArticle(String type) {
        homePage.setArticle(type);
    }

    @Step("Se da click en el boton buscar")
    public void clickBtnGo() {
        homePage.clickBtnGo();
    }

    @Step("Se selecciona la marca Adidas")
    public void clickChkBrandAdidas() {
        findArticlesPage.clickChkBrandAdidas();
    }

    @Step("Se selecciona nuevo")
    public void clickChkNew() {
        findArticlesPage.clickChkNew();
    }

    @Step("Se ordena de forma - {0}")
    public void setChbOrderUpward(String option) {
        findArticlesPage.setChbOrder(option);
    }

    @Step("Se seleccionan los primeros 5 articulos")
    public List<WebElement> getArticles() throws Exception {
        List<WebElement> articles = findArticlesPage.returnArticles();
        List<WebElement> fiveArticles = new ArrayList<>();
        int i = 0;
        for (WebElement element : articles) {
            if (i < 5) {
                fiveArticles.add(element);
            } else {
                break;
            }
            i++;
        }

        return fiveArticles;
    }

    public void printArticles(List<WebElement> articles) {
        List<String> textArticles = findArticlesPage.textPrice(articles);
        for (int i = textArticles.size()-1; i > 0; i--) {
            System.out.println(textArticles.get(i));
        }

    }


}
