package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Tests extends WebDriverSettings {

    @Test
    public void testSearch(){
        PageFactoryGoogle googlePF = PageFactory.initElements(chromeDriver, PageFactoryGoogle.class);
        googlePF.search("Гладиолус");
        Assertions.assertTrue(googlePF.getSearchResult().size() > 3);
    }

    @Test
    public void testSearchWikiGladiolus(){
        PageFactoryGoogle googlePF = PageFactory.initElements(chromeDriver, PageFactoryGoogle.class);
        googlePF.search("Гладиолус");
        var result = googlePF.getSearchResult();
        Assertions.assertFalse(
                result.stream().filter(x->x.getText().contains("Википедия"))
                                .anyMatch(x->x.getText().contains("Гладиолус"))
        );


    }
}
