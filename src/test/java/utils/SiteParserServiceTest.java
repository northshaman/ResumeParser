package utils;


import com.shaman.parser.config.RootConfig;
import com.shaman.parser.utils.SiteParserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for test simple operations with WebDriver
 */
@ContextConfiguration(classes = {RootConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SiteParserServiceTest {
    @Autowired
    private SiteParserService parserService;

//    @Ignore
    @Test
    public void testProps() {
        parserService.getCssPropertiesMap().forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }
//@Ignore
    @Test
    public void getTargetElementsListTest() {
        List<WebElement> resumeList = parserService.getTargetElementsList();
        System.out.println("Found -> " + resumeList.size() + " resume\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Resume N" + i);
            System.out.println(parserService.getElementVal(resumeList.get(i), "idOriginal", "name"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "fioAndAge"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "resumeLink", "href"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "positionName"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "lastVisit"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "city"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "wageLevel"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "education"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "experience"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "lastPlaceOfWork"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "lastPositionName"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "lastPlaceDuration"));
            System.out.println(parserService.getElementVal(resumeList.get(i), "pictureLink", "src"));
            System.out.println();
        }
    }
@Ignore
    @Test
    public void parseIntegerValuesTest() {
        List<WebElement> resumeList = parserService.getTargetElementsList();
        System.out.println("Found -> " + resumeList.size() + " resume\n");
        for (int i = 0; i < 15; i++) {
            System.out.println("Resume N" + i);
            String fioAge = parserService.getElementVal(resumeList.get(i), "fioAndAge");
            System.out.println(fioAge);
            String fio = fioAge.substring(0, fioAge.indexOf(','));
            String age="";
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(fioAge.substring(fioAge.indexOf(',')));
            while (m.find()) {
                 age = m.group();
            }
            System.out.println("FIO -> " + fio + " age -> " + Integer.parseInt(age));
        }
    }

}