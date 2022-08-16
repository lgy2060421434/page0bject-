package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver webDriver;
    protected String url;
    public static Logger BaseLogger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BasePage(WebDriver webDriver, String url) {
        this.webDriver = webDriver;
        BaseLogger.info("打开浏览器 -> " + webDriver.toString());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BaseLogger.info("设置时间和超时");
        this.url = url;
        webDriver.get(url);
        BaseLogger.info("访问的网址为：" + url);
        PageFactory.initElements(webDriver, this);
        BaseLogger.info("初始化页面元素-》" + this.getClass());
    }

    public void closeBrowser() {
        BaseLogger.info("关闭浏览器 -> " + webDriver.toString());
        webDriver.close();
    }
}
