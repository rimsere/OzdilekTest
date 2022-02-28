import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assert;
import org.junit.Assert;
import org.openqa.selenium.By;
public class BasePage extends BaseTest{
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {
        Thread.sleep(wait * 1000);
    }
    @Step("id <id> li elemente tıkla")
    public void clickById(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }
    @Step("id <id> li elementi kontrol et")
    public void checkText(String id) {
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assert.assertEquals("ALIŞVERİŞE BAŞLA", chectText);
    }
    @Step("<scroll et>")
    public void scrollEt(String scroll) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(538,1538)).moveTo(PointOption.point(538,420)).release().perform();
        logger.info("Scroll yapıldı.");
    }
    @Step("Rasgele bir ürün seç")
    public void selectRandomProduct(){
        Random rdn = new Random();
        List<MobileElement> scr =appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        System.out.println("scr"  +scr);
        MobileElement element;
        element = scr.get(rdn.nextInt(scr.size()));
        System.out.println("element"  +element);
        element.click();

    }
    @Step("Urun detay sayfasi acildigi kontrol edilir")
    public void checkProductDetail() throws InterruptedException {
        Thread.sleep(1000);
        String checkProductText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvSizeDesc")).getText();
        Assert.assertEquals("Beden:", checkProductText);
        System.out.println("Urun detayına girildi.");
        logger.info("Urun detayına girildi.");
    }
    @Step("Urun favorilere eklenir")
    public void addToFav() throws InterruptedException {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/imgFav")).click();
        System.out.println("Favorilere ekle butonuna basildi.");
        logger.info("Favorilere ekle butonuna basildi.");
    }


}