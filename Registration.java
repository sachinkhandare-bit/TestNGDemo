package completeRegistrationDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "F:\\Software\\Crome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String path="C:\\Users\\admin\\My-Eclipse-Workspace\\BestPractices\\config.properties";
		//FileImageInputStream fis=new FileImageInputStream(path);
		FileInputStream fis=new FileInputStream(path);
		Properties pr=new Properties();
		pr.load(fis);
		
		
		driver.get(pr.getProperty("url"));
		
		System.out.println("Complete Registration Page");
		
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys(pr.getProperty("Name"));
		
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys(pr.getProperty("Surname"));
		
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Rahatani Pune 17");
		
		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("sachinpatil123@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("1234567890");
		
		
		//Approach 1 for Radio Button
		WebElement male=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input"));
		male.click();
		System.out.println("Male Selected");
		WebElement fmale=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input"));
		fmale.click();
		System.out.println("FeMale Selected");
		
		//Approach2 for radio button
		
		List<WebElement> lst=driver.findElements(By.name("radiooptions"));
		int i=lst.size();
		for (int j = 0; j < i; j++) {
			
			String val=lst.get(j).getAttribute("value");
			System.out.println("Radion Button Selected Value is "+val);
			
			if(val.equalsIgnoreCase("Male"))
			{
				lst.get(j).click();
			}
			else
			{
				lst.get(j).click();
			}
			
			}
		
		
				//CheckBox options
		WebElement cricket=driver.findElement(By.xpath("//*[@id=\"checkbox1\"]"));
		cricket.click();
		System.out.println("Hobedbies cricket selected");
		WebElement movie=driver.findElement(By.id("checkbox2"));
		
		movie.click();
		System.out.println("Hobedbies movie selected");
		WebElement Hockey=driver.findElement(By.id("checkbox3"));
		
		Hockey.click();
		System.out.println("Hobedbies Hockey selected");
		
		//ComboBox Multiselector
		WebElement lang=driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget'][@Id='msdd']"));
		lang.click();
		
		//Thread.sleep(5000);
		////*[@id="msdd"]
	//	WebElement langg=driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']"));
		//langg.click();
		
		/*WebElement setlang=driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li[5]"));
		setlang.click();
		String slanguage=setlang.getText();
		System.out.println("Selected Language is "+slanguage);*/

		
		//**********Get All Elements**************
		List<WebElement> alllang=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		for (int j = 0; j < alllang.size(); j++) {
			String cName=alllang.get(j).getText();
			
			if(alllang.get(j).getText().equalsIgnoreCase("Hindi")||alllang.get(j).getText().equalsIgnoreCase("English"))
			{
				
				System.out.println("Hindi language is present at location "+ j+" "+cName);
				alllang.get(j).click();
				break;
			}
			System.out.println("Lis of countre is "+j+"\t"+cName);
			
		}
		
		
		WebElement skill=driver.findElement(By.id("Skills"));
		Select skl=new Select(skill);
		skl.selectByValue("AutoCAD");
		
		//Approch 2 wiyhout Select Class
		
		WebElement country=driver.findElement(By.id("countries"));
		Select con=new Select(country);
		con.selectByIndex(15);
		
		WebElement ccountry=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span"));
		ccountry.click();
		Thread.sleep(5000);
		WebElement scountry=driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		scountry.sendKeys("India");
		//Thread.sleep(5000);
		
		WebElement selectedcountry=driver.findElement(By.xpath("//span/ul/li[@class='select2-results__option select2-results__option--highlighted']"));
			
		selectedcountry.click();
		
		
		
		
		
		
		WebElement year=driver.findElement(By.id("yearbox"));
		
		Select selectyear=new Select(year);
		selectyear.selectByValue("1981");
		
		WebElement month=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
		
		Select selectmonth=new Select(month);
		selectmonth.selectByValue("May");
		
		WebElement day=driver.findElement(By.id("daybox"));
		
		Select selectday=new Select(day);
		selectday.selectByValue("4");
		
		
		driver.findElement(By.id("firstpassword")).sendKeys("Sachin@3567");
		
		driver.findElement(By.id("secondpassword")).sendKeys("Sachin@3567");
		
		driver.findElement(By.id("submitbtn")).click();
		
		Thread.sleep(9000);
		
		driver.close();
		
		
		
		
		
	}

}
