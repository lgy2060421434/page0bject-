package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class ElementUISelect {
    public static Logger BaseLogger = Logger.getLogger(ElementUISelect.class);
    protected final WebElement selectBoxElement;

    public ElementUISelect(WebElement selectBoxElement) {
        this.selectBoxElement = selectBoxElement;
    }

    //    ElementUI 选择框的处理
    private WebElement section(WebDriver webDriver, String s) {
        BaseLogger.info("搜索选项 -> " + s);
        return new WebDriverWait(webDriver, 10).until(
                ExpectedConditions.visibilityOf(webDriver.findElement(new By.ByXPath(String.format("//div[@x-placement]//li/span[text()=\"%s\"]", s)))));
    }
    /*
     * 单选
     * */
    public void select(WebDriver webDriver, String selection) {
        selectBoxElement.sendKeys(selection);
        selectBoxElement.click();
        BaseLogger.info("点击选项 -> "+selectBoxElement.toString().split("->")[1].replace(']',' ') );
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            BaseLogger.error("线程错误");
        }
        section(webDriver, selection).click();
    }

    /*
     * 多选
     * */
    public void select(WebDriver webDriver, String[] selections) {
        selectBoxElement.click();
        BaseLogger.info("点击选项 -> "+selectBoxElement.toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.stream(selections).forEach(s -> section(webDriver, s));
    }

}
