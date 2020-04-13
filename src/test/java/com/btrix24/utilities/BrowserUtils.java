package com.btrix24.utilities;

import org.openqa.selenium.WebElement;

import java.util.*;

public class BrowserUtils {

    /*
        We can improve this class based on our project
          This class :
                    - takes a list of web elements
                    - returns a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> listElement){

        List<String> stringList = new ArrayList<>();

        for(WebElement element : listElement){
            stringList.add(element.getText());
        }

        return stringList;

    }
}
