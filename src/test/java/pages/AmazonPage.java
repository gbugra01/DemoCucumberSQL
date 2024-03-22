package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='s-image'])[1]")
    public WebElement clickFirstElement;

    @FindBy(xpath = "//*[@id='productTitle']")
    public WebElement productName;
    @FindBy(xpath = "(//*[@class='a-price-whole'])[1]")
    public WebElement productPrice;
    @FindBy(xpath = "//*[@class='a-button-text a-text-center celwidget']")
    public WebElement rejectCookie;


}
