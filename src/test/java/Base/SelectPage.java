package Base;


import Base.BasePage;
import Base.ElementUISelect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Author:   RaoQingLong
 * Date:     2021/3/26 22:06
 * Description:
 */

public class SelectPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//section/div[1]//input")
    private WebElement selectOne;

    @FindBy(how = How.XPATH, using = "//section/div[2]//input")
    private WebElement selectTwo;

    public SelectPage(WebDriver webDriver) {
        super(webDriver, "https://element.eleme.cn/#/zh-CN/component/select");
    }

    public void selectFirst(){
        selectFirst("黄金糕");
    }

    public void selectFirst(String s){
        new ElementUISelect(selectOne).select(webDriver,s);
    }

    public void selectTwo(){
        selectTwo("蚵仔煎");
    }

    public void selectTwo(String s){
        new ElementUISelect(selectTwo).select(webDriver,s);
    }

}
