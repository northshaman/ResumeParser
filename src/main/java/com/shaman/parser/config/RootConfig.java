package com.shaman.parser.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 *
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan({"com.shaman.parser.entity","com.shaman.parser.services","com.shaman.parser.utils"})
public class RootConfig {

    @Autowired
    private
    Environment env;

    @Bean(destroyMethod = "quit")
    public WebDriver getPhantomJSWebDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, env.getRequiredProperty("phantomJS.path"));
        return new PhantomJSDriver(caps);
    }

}
