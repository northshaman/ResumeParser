package com.shaman.parser.utils;

import com.shaman.parser.entity.Resume;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * SiteParser HTML base class for working with Web Elements and generating Objects
 */
@Component
@PropertySource({"classpath:css.properties", "classpath:config.properties"})
public class SiteParserService {

    private String targetURL;

    private String CSS_RESUME_ELEMENT;

    private WebDriver driver;

    private Map<String, String> cssPropertiesMap = new HashMap<>();

    private final
    Environment env;


    @Autowired
    public SiteParserService(WebDriver driver, Environment env) {
        this.env = env;
        this.driver = driver;
        initCSSFromProps();
        this.targetURL = env.getProperty("phantomJS.defaultURL");
        this.CSS_RESUME_ELEMENT = env.getProperty("css.resume");
    }

    /**
     * Parse base Web elements for further parsing
     *
     * @return List of Root Web elements
     */
    public List<WebElement> getTargetElementsList() {
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1280, 1024));
        this.driver.get(targetURL);
        return driver.findElements(By.cssSelector(CSS_RESUME_ELEMENT));
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

    public List<Resume> getNewResumeList() {
        List<WebElement> resumeList = getTargetElementsList();
        List<Resume> resumeItems = new ArrayList<>();

        resumeList.forEach(resume -> {
            String fioAge = getElementVal(resume, "fioAndAge");
            String fio = fioAge.substring(0, fioAge.indexOf(','));
            String  stringAge = "";
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(fioAge.substring(fioAge.indexOf(',')));
            while (m.find()) {
                stringAge = m.group();
            }
            Resume resumeItem = new Resume();
            resumeItem.setIdOriginal(Long.parseLong(getElementVal(resume, "idOriginal", "name")));
            resumeItem.setFio(fio);
            resumeItem.setAge(stringAge!=null ? Integer.parseInt(stringAge) : null);
            resumeItem.setResumeLink(getElementVal(resume, "resumeLink", "href"));
            resumeItem.setPositionName(getElementVal(resume, "positionName"));
            resumeItem.setLastVisit(getElementVal(resume, "lastVisit"));
            resumeItem.setCity(getElementVal(resume, "city"));
            resumeItem.setWageLevel(getElementVal(resume, "wageLevel"));
            resumeItem.setEducation(getElementVal(resume, "education"));
            resumeItem.setExperience(getElementVal(resume, "experience"));
            resumeItem.setLastPlaceOfWork(getElementVal(resume, "lastPlaceOfWork"));
            resumeItem.setLastPositionName(getElementVal(resume, "lastPositionName"));
            resumeItem.setLastPlaceDuration(getElementVal(resume, "lastPlaceDuration"));
            resumeItem.setPictureLink(getElementVal(resume, "pictureLink", "src"));
            resumeItems.add(resumeItem);
        });
        return resumeItems;
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
}