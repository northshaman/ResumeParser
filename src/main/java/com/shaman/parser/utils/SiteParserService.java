package com.shaman.parser.utils;

import com.shaman.parser.entity.ResumeObj;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * SiteParser HTML
 */
@Service
public class SiteParserService {

    @Value("${phantomJS.defaultURL}")
    private String targetURL;

    @Value("${css.resume}")
    private String CSS_RESUME_ELEMENT;

    private WebDriver driver;

    private Map<String, String> cssPropertiesMap = new HashMap<>();

    @Autowired
    public SiteParserService(WebDriver driver) {
        this.driver = driver;
        initCSSFromProps();
    }

    public List<WebElement> getTargetElementsList() {
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1280, 1024));
        this.driver.get(targetURL);
        return driver.findElements(By.cssSelector(CSS_RESUME_ELEMENT));
    }

    public Map<String, String> getCssPropertiesMap() {
        return cssPropertiesMap;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTargetURL() {
        return targetURL;
    }

    public void setTargetURL(String targetURL) {
        this.targetURL = targetURL;
        this.driver.get(targetURL);
    }

    /**
     * initialize map for storage css selectors
     */
    private void initCSSFromProps() {
        Properties prop = null;
        InputStream is;
        try {
            prop = new Properties();
            is = this.getClass().getResourceAsStream("/css.properties");
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Object> keys = prop.keySet();
        Properties finalProp = prop;
        keys.forEach(k ->
                cssPropertiesMap.put((String) k, finalProp.getProperty((String) k))
        );
    }

    /**
     * @param element     Web element - source for searching
     * @param elementName name of element for searching
     * @return String value of searching element or null if can't find anything
     */
    public String getElementVal(WebElement element, String elementName) {
        String elementValue = null;
        try {

            elementValue = element.findElement(By.cssSelector(cssPropertiesMap.get(elementName))).getText();
        } catch (NoSuchElementException nse) {
//        NOP
        }
        return elementValue;
    }

    /**
     * @param element     Web element - source for searching
     * @param elementName name of element for searching
     * @param attrName    name of attribute for reading
     * @return String value of attribute searching element or null if can't find anything
     */
    public String getElementVal(WebElement element, String elementName, String attrName) {
        String elementValue = null;
        try {
            elementValue = element.findElement(By.cssSelector(cssPropertiesMap.get(elementName))).getAttribute(attrName);
        } catch (NoSuchElementException nse) {
//        NOP
        }
        return elementValue;
    }
    public List<ResumeObj> getNewResumeList() {
        List<WebElement> resumeList = getTargetElementsList();
        List<ResumeObj> resumeItems = new ArrayList<>();

        resumeList.forEach(resume -> {
            String fioAge = getElementVal(resume, "fioAndAge");
            String fio = fioAge.substring(0, fioAge.indexOf(','));
            String age = "";
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(fioAge.substring(fioAge.indexOf(',')));
            while (m.find()) {
                age = m.group();
            }
//            ResumeObj resumeItem = new ResumeObj(
//                    Long.parseLong(parserService.getElementVal(resume, "idOriginal", "name")),
//                    fio,
//                    Integer.parseInt(age),
//                    parserService.getElementVal(resume, "resumeLink", "href"),
//                    parserService.getElementVal(resume, "positionName"),
//                    parserService.getElementVal(resume, "lastVisit"),
//                    parserService.getElementVal(resume, "city"),
//                    parserService.getElementVal(resume, "wageLevel"),
//                    parserService.getElementVal(resume, "education"),
//                    parserService.getElementVal(resume, "experience"),
//                    parserService.getElementVal(resume, "lastPlaceOfWork"),
//                    parserService.getElementVal(resume, "lastPositionName"),
//                    parserService.getElementVal(resume, "lastPlaceDuration"),
//                    parserService.getElementVal(resume, "pictureLink", "src"));
//            resumeItems.add(resumeItem);
        });
        return resumeItems;
    }
}