import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.util.logging.*;
import javax.sql.rowset.WebRowSet;
import java.util.ResourceBundle;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;
import java.util.MissingResourceException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.TimeoutException;
import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Thread;
import java.util.ArrayList;
import  static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Proxy;
import java.lang.Object;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.JavascriptException;
import java.net.URL;
import org.springframework.util.StringUtils;
//import jdk.javadoc.internal.doclets.toolkit.util.JavaScriptScanner;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import ChromeBot.ChromeBot1;
import org.openqa.selenium.logging.LocalLogs;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Cookie.Builder;
import java.util.Arrays;

public class SeleniumBot1 extends Thread implements Runnable{
    public WebDriver webDriver;
    public WebDriverWait webWait;
    public static  Logger logger=Logger.getLogger(SeleniumBot1.class.getName());
    //String str;
    ChromeOptions options;
    ChromeDriverService cds;
    int var1;
    public SeleniumBot1(int var1){
        try{
        //this.str = str;
        options = new ChromeOptions()
        .setAcceptInsecureCerts(true)
        .setBinary(new File("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"));
        //options.addArguments("user-data-dir=C:\\Users\\PAUL\\AppData\\Local\\Google\\Chrome\\User Data2");
        //options.addArguments("profile-directory=Profile 8");
        options.setCapability("strictFileInteractability", true);
        options.setCapability("javascriptEnabled" ,true);
        options.setCapability("networkConnectionEnabled", true);
        options.setCapability("pageLoadStrategy", PageLoadStrategy.NORMAL);
        ArrayList<String> list = new ArrayList<String>();
        list.add("user-data-dir=C:\\Users\\PAUL\\AppData\\Local\\Google\\Chrome\\User Data2");
        list.add("profile-directory=Profile 8");
        //options.addArguments(list);
        cds = new ChromeDriverService
        .Builder()
        .usingAnyFreePort()
        .usingDriverExecutable(new File("C:/Users/PAUL/Documents/AAAfiles/c++/SeleniumBot/chromedriver_win32/chromedriver.exe"))
        .build();
        //WebDriver driver = new ChromeDriver(cds,options);
        //WebDriverWait wait =  new WebDriverWait(driver,var1);
        this.var1 = var1;
        //webDriver = new ChromeDriver(cds,options);
        //webWait=  new WebDriverWait(webDriver,var1);
    }
        catch(WebDriverException| ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
    }
}   
        @Override
        public void run(){
        webDriver = new ChromeDriver(cds,options);
        webWait=  new WebDriverWait(webDriver,var1);
        String rand1=null;
        String rand2=null;
        //SeleniumBot1 driver = this ;
        //File baseDirectory=new File("SeleniumBot.java");
        Logger logger1=Logger.getLogger(SeleniumBot1.class.getName());
        try{
        System.setProperty("webdriver.chrome.driver","C:/Users/PAUL/Documents/AAAfiles/c++/SeleniumBot/chromedriver_win32/chromedriver.exe");
        webDriver.navigate().to("https://tuckercraig.com/dino/");
        rand1=webDriver.getCurrentUrl();
        log(rand1);
        rand2=webDriver.getTitle();
        log(rand2);
        WebElement body = webDriver.findElement(By.cssSelector("body"));
         webDriver.manage().window().setPosition(new Point(-10,0));
        webDriver.manage().window().setSize(new Dimension(715,780));
        body.click();
        body.sendKeys(" ");
        body.sendKeys(" ");
        System.out.println(webDriver.manage().getCookies().toArray(new Cookie[0])[0].getName());
        System.out.println(Arrays.deepToString(webDriver.manage().getCookies().toArray(new Cookie[0])));
        Cookie cookie = new Cookie.Builder
        ("This is random","Random")
        .build();
        webDriver.manage().addCookie(cookie);
        System.out.println(Arrays.deepToString(webDriver.manage().getCookies().toArray(new Cookie[0])));
        //System.out.println(Arrays.deepToString(webDriver.manage().logs().getAvailableLogTypes().toArray(new LocalLogs[0])));
        while(true){
            try{
            Thread.sleep(80000);
            webDriver.navigate().refresh();
            Thread.sleep(2500);
            webDriver.findElement(By.cssSelector("body")).sendKeys(" ");
            Thread.sleep(80000);
            webDriver.findElement(By.xpath("/html/body/footer/ul/li[1]/a")).click();
            Thread.sleep(2500);
            webDriver.findElement(By.cssSelector("body")).sendKeys(" ");
            }
            catch(InterruptedException E){
                E.getMessage();
            }
        }
    }
        catch(ElementNotInteractableException|NoSuchElementException|
        InvalidArgumentException |TimeoutException e){ 
            logger1.log(Level.SEVERE,e.toString());
    } 
    }
    public static synchronized void impose(Thread T1,int priority,String var1){
        T1.setPriority(priority);
        T1.setName(var1);
        T1.start();
        System.out.println("Thread " + T1.getName() + " is running");
    }
    public void log(WebElement webElement){
        this.logger.log(Level.INFO, webElement.toString());
    }
    public void log(String webElement){
        this.logger.log(Level.INFO, webElement.toString());
    }
    public static void main(String[] args){
        try{
    //while(true){
    Thread Thread1 = new SeleniumBot1(8); 
    Thread Thread2= new ChromeBot1();
    SeleniumBot1.impose(Thread1,8,"SeleniumBot");
    Thread.sleep(40000);
    SeleniumBot1.impose(Thread2,6,"ChromeBot");
        }
        catch(InterruptedException E){
            E.printStackTrace();
        }       
    } 
}               