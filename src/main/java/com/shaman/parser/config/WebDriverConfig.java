package com.shaman.parser.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;


/**
 *
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan({"com.shaman.parser.entity","com.shaman.parser.utils"})
public class WebDriverConfig {

    @Autowired
    private
    Environment env;

    @Bean(destroyMethod = "quit")
    public WebDriver getPhantomJSWebDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        ArrayList<String> cliArgsCap = new ArrayList<>();
        cliArgsCap.add("--webdriver-loglevel=NONE");

        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, env.getRequiredProperty("phantomJS.path"));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,cliArgsCap);

        return new PhantomJSDriver(caps);

    }

}
