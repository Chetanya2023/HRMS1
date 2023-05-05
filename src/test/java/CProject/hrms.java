package CProject;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class hrms {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote=allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://172.232.75.138/HR-Management/");
		driver.manage().window().maximize();
		
		
		//login validations and Flow
		WebElement valid1 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		valid1.click();
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebElement emailvalidation = driver.findElement(By.id("login_email_help"));
		String validation = emailvalidation.getText();
		
		WebElement passvalidation = driver.findElement(By.id("login_password_help"));
		String passwordvalidation = passvalidation.getText();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		if(validation.contains("Please enter your email"))
				{
			WebElement login = driver.findElement(By.id("login_email"));
			login.sendKeys("admin@gmail.com");
				}
		else 
		{
			System.out.println("Email id Validation is not proper");
		}
		
		if(passwordvalidation.contains("Please add a password"))
		{
			WebElement pass = driver.findElement(By.id("login_password"));
			pass.sendKeys("Admin@123");
		}
		
		else
		{
			System.out.println("Password validation is not proper");
		}
		
		
			WebElement log =driver.findElement(By.xpath("//button[@type='submit']"));
			log.click();
		
		
		String tit = driver.getTitle();
		System.out.println("Company Website is " +  tit);
	

	//Side Module // Role Management
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	driver.findElement(By.linkText("Role Management")).click();
	 WebElement AddRole = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-lg custom_btn']"));
	 AddRole.click();
	 driver.switchTo().activeElement();
	 WebElement ok = driver.findElement(By.xpath("//button[@type='button'][2]"));
	 ok.click();
	 System.out.println(driver.findElement(By.xpath("//div[text()='Please Enter Title']")).getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		//Search and Add Employee
		driver.findElement(By.xpath("(//li[@role='menuitem'])[5]")).click();
		driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-lg custom_btn']")).click();
		
		//Add Employee- Validations ( Click on Okay button)
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='OK']")).click();
		
		//Employee-UploadImage
		
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:/Users/baps/eclipse-workspace/HRMS/target/pexels-craig-adderley-1563355.jpg");
		
		//Employee-Role
		String rolevalid= driver.findElement(By.xpath("(//div[@class='ant-form-item-explain-error'])[1]")).getText();
		if(rolevalid.contains("Please Select Role"))
		{
			driver.findElement(By.xpath("(//div[@class='ant-form-item-control-input-content'])[2]")).click();
			driver.findElement(By.xpath("//div[text()='Team Leader']")).click();
		}
		else
		{
			System.out.print("Role validation is missing");
		}
		
		//Employee-Department
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.xpath("(//div[@class='ant-form-item-control-input-content'])[3]")).click();
		driver.findElement(By.xpath("//div[text()='QA']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Rupal");
		driver.findElement(By.id("last_name")).sendKeys("Shah");
		driver.findElement(By.id("phoneNo")).sendKeys("9871234560");
		driver.findElement(By.id("alternateNo")).sendKeys("9874561230");
		driver.findElement(By.id("aadharcardNo")).sendKeys("123456789012");
		driver.findElement(By.id("age")).sendKeys("25");
		driver.findElement(By.id("joiningdate")).sendKeys("12-12-2003");
		driver.findElement(By.id("releavingDate")).sendKeys("12-04-2023");
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.xpath("//div[text()='Female']")).click();
		driver.findElement(By.id("salary")).sendKeys("25000");
		driver.findElement(By.id("email")).sendKeys("rupal@mailinator.com");
		driver.findElement(By.id("personalemailId")).sendKeys("rupal1@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		driver.findElement(By.id("permanent_address")).sendKeys("Gr Circle , New Delhi , 385555");
		driver.findElement(By.id("temparory_address")).sendKeys("NA");
		driver.findElement(By.id("birthdate")).sendKeys("22-12-2000");
		driver.findElement(By.id("city")).sendKeys("Delhi");
		driver.findElement(By.xpath("//span[text()='OK']")).click();
		
		//Detail Screen  of Employee
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//*[@class='feather feather-more-vertical feather_icon'])[2]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Detail']")).click();
		
			
		}
		
		
		
		
		
		
		
	}

