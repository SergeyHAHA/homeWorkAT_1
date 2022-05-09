package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryGoogle {

    private WebDriver chromeDriver;
    private String url = "https://www.google.com/";

    public PageFactoryGoogle(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        chromeDriver.get(url);
    }
    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchField;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    private WebElement searchButton;

    public List<WebElement> getSearchResult() {
        return searchResult;
    }

    @FindAll(@FindBy(how = How.XPATH, xpath = "//*[@id=\"rso\"]//div/a/h3"))
    private List<WebElement> searchResult;

    public void search(String searchString){
        searchField.click();
        searchField.sendKeys(searchString);
        searchButton.click();
    }


}
