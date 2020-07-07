package com.test.automation.stepDefinitions;

import com.test.automation.steps.FindObjectsStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindObjectsStepDefinitions {

    @Steps
    FindObjectsStep findObjectsStep;

    List<WebElement> fiveArticles = null;

    @Given("Estoy en la pagina de amazon")
    public void openPage() {
        findObjectsStep.openPage();
    }


    @When("Ingrese el articulo (.*)")
    public void setArticle(String article) {
        findObjectsStep.setArticle(article);
        findObjectsStep.clickBtnGo();
    }

    @And("Seleccione la marca adidas")
    public void setBrand() {
        findObjectsStep.clickChkBrandAdidas();
    }

    @And("Seleccione el estado Nuevo")
    public void setStateNew() {
        findObjectsStep.clickChkNew();
    }

    @And("Ordene los precios de forma (.*)")
    public void orderPriceUpward(String order) {
        findObjectsStep.setChbOrderUpward(order);
    }

    @And("Tome los 5 primeros artículos")
    public void takeFiveArticles() throws Exception {
        fiveArticles = findObjectsStep.getArticles();
    }

    @When("Los productos deben estar ordenados de forma descendente")
    public void orderProductFalling() throws Exception {
        findObjectsStep.printArticles(fiveArticles);
        Thread.sleep(5000);
    }

}
