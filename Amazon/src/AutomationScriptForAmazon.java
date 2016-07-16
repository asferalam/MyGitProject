import java.awt.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationScriptForAmazon extends ReusableMethodForAmazon {

	static WebDriver driver;

	//Test Case ---1


	public static void LaunchTheAmazonApplication() throws IOException, InterruptedException {

		startReport("LaunchTheAmazonApplication", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");

		//Launch the browser
		driver = new FirefoxDriver();

		AmazonModule.OpenAmazon();

		Update_Report("Pass", "Launch Amazon Application", "Amazon Application is launched");

		bw.close();
		driver.quit();

	}


	//Test case --2

	public static void DropDownOption() throws IOException, InterruptedException{

		startReport("DropDownOption", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");

		String FirstItem="iphone 6s case in All Departments";
		String SecondItem="iphone 6s case in Electronics";
		String ThirdItem="iphone 6s case in Cell Phones & Accessories";

		//Launch the browser
		driver = new FirefoxDriver();

		AmazonModule.OpenAmazon();

		Update_Report("Pass", "Launch Amazon Application", "Amazon Application is launched");

		WebElement SearchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(SearchBox, "Iphone", "SearchBox");
		Thread.sleep(2000);
		WebElement FirstDropdownText = driver.findElement(By.xpath(".//*[@id='issDiv0']"));
		String firstText = FirstDropdownText.getText();

		WebElement SecondDropdownText = driver.findElement(By.xpath(".//*[@id='issDiv1']"));
		String SecondText = SecondDropdownText.getText();

		WebElement ThirdDropdownText = driver.findElement(By.xpath(".//*[@id='issDiv2']"));
		String ThirdText = ThirdDropdownText.getText();

		if (firstText.equalsIgnoreCase(FirstItem)){
			System.out.println(firstText +" is present in dropdown");
			Update_Report("Pass", "FirstText",firstText+" is present in dropdown" );
		}else{
			System.out.println(firstText +" is not present in dropdown");
			Update_Report("Fail", "FirstText",firstText+" is not present in dropdown" );
		}

		if (SecondText.equalsIgnoreCase(SecondItem)){
			System.out.println(SecondText +" is present in dropdown");
			Update_Report("Pass", "SecondText",SecondText+" is present in dropdown" );
		}else{
			System.out.println(firstText +" is not present in dropdown");
			Update_Report("Fail", "SecondText",SecondText+" is not present in dropdown" );
		}
		if (ThirdText.equalsIgnoreCase(ThirdItem)){
			System.out.println(ThirdText +" is present in dropdown");
			Update_Report("Pass", "ThirdText",ThirdText+" is present in dropdown" );
		}else{
			System.out.println(firstText +" is not present in dropdown");
			Update_Report("Fail", "ThirdText",ThirdText+" is not present in dropdown" );
		}



		bw.close();
		driver.quit();

	}

	//Test Case --03
	public static void ClickSearchButton() throws IOException, InterruptedException{

		startReport("ClickSearchButton", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");

		//Launch the browser
		driver = new FirefoxDriver();

		AmazonModule.OpenAmazon();

		Update_Report("Pass", "Launch Amazon Application", "Amazon Application is launched");

		WebElement SearchBox = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
		enterText(SearchBox, "Iphone", "SearchBox");
		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath("//input[@value='Go']"));
		clickElement(search, "Search Button");

		bw.close();
		driver.quit();

	}

	//Test Case --04
	public static void CellPhonesAccessories() throws Exception{
		startReport("CellPhonesAccessories", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");

		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		Update_Report("Pass", "Launch Amazon Application", "Amazon Application is launched");

		//Verify cellphone accessories option

		WebElement cellphacc = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(cellphacc).build().perform();

		ElementDisplayed(cellphacc, "Cell Phone Accessoried");

		WebElement CellPhCase = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));
		ElementDisplayed(CellPhCase, "Cell Phone cases");

		WebElement seeMore = driver.findElement(By.xpath("//ul[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		ElementDisplayed(seeMore, "See More");

		bw.close();  
		driver.quit();
	}

	//Test Case ----05

	public static void ComputersAndAccessories() throws Exception{
		startReport("ComputersAndAccessories", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul/li/a/span[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//ul[@id='seeAllDepartmentClosed1']/li/span/a/span[2]")).click();

		WebElement CopmAcce = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[1]/a/span[1]"));
		ElementDisplayed(CopmAcce, "Computer and Accessories Header");


		WebElement CompComponent = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a/span"));
		ElementDisplayed(CompComponent, "Computer components");

		bw.close();
		driver.quit();

	}

	//Test Case--06

	public static void Electronics() throws Exception{
		startReport("Electronics", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul/li/a/span[2]")).click();
		Thread.sleep(2000);

		WebElement seeDipart = driver.findElement(By.xpath("//ul[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		ElementDisplayed(seeDipart, "See All 35 departments");
		seeDipart.click();
		Thread.sleep(2000);

		WebElement Electro = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/a/span[1]"));
		ElementDisplayed(Electro, "Electronics");

		WebElement smartwatches = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[1]/a/span"));
		ElementDisplayed(smartwatches, "Smart Watches");

		WebElement bluetoothSpeeker = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[2]/a/span"));
		ElementDisplayed(bluetoothSpeeker, "Portable Bluetooth Speeker");


		bw.close();
		driver.quit();

	}
	//Test Case --07
	public static void RefinebyHeader() throws Exception{

		startReport("RefinebyHeader", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");
		//Launch the browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");


		WebElement AmazonPrime = driver.findElement(By.xpath(".//*[@id='refinements']/h2[1]"));
		ElementDisplayed(AmazonPrime, "Amazon Prime");

		WebElement chkbox= driver.findElement(By.xpath(".//*[@id='ref_2470954011']/li/a/div/span/img"));

		ValidateDeselect(chkbox);

		WebElement freeshipping = driver.findElement(By.xpath(".//*[@id='refinements']/h2[3]"));
		ElementDisplayed(freeshipping, "Eligible for free shipping");

		WebElement freeShipByAmazon = driver.findElement(By.xpath(".//*[@id='ref_2491144011']/li/a/img"));
		ValidateDeselect(freeShipByAmazon);

		//Brand
		WebElement brand = driver.findElement(By.xpath(".//*[@id='refinements']/h2[5]"));
		ElementDisplayed(brand, "Brand");
		//Apple
		WebElement Apple = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[1]/a/img"));
		ElementDisplayed(Apple, "Apple Icon");
		ValidateDeselect(Apple);

		//Rinbers
		WebElement rinbers = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[3]/a/img"));
		ElementDisplayed(rinbers, "Rinbers Icon");
		ValidateDeselect(rinbers);

		//Buyeee

		WebElement Buyee = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[4]/a/img"));
		ElementDisplayed(Buyee, "Buyee Icon");
		ValidateDeselect(Buyee);

		//Grantwood Technology
		WebElement Grantwood = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[5]/a/img"));
		ElementDisplayed(Grantwood, "GrantWood Technology");
		ValidateDeselect(Grantwood);

		//Energen
		WebElement Energen = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[6]/a/img"));
		ElementDisplayed(Energen, "Energen Icon");
		ValidateDeselect(Energen);

		//RCO
		WebElement Rco = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[7]/a/img"));
		ElementDisplayed(Rco, "RCO Icon");
		ValidateDeselect(Rco);

		//KingLAKE
		WebElement kinglake = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[8]/a/img"));
		ElementDisplayed(kinglake, "KINGLAKE Icon");
		ValidateDeselect(kinglake);

		//UNU
		WebElement UNU = driver.findElement(By.xpath(".//*[@id='ref_2528832011']/li[9]/a/img"));
		ElementDisplayed(UNU, "UNU Icon");
		ValidateDeselect(UNU);

		//CellPhone Internal Memory
		WebElement memory =driver.findElement(By.xpath(".//*[@id='refinements']/h2[6]"));
		ElementDisplayed(memory, "Cell Phone Internal Memory");

		//4GB
		WebElement FourGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[1]/span/img"));
		FourGB.isEnabled();
		Update_Report("Pass", "FourGB checBox", "4GB Check Box is disable");

		//8GB
		WebElement EightGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[2]/a/img"));
		ElementDisplayed(EightGB, "8GB memory");
		ValidateDeselect(EightGB);

		//16GB

		WebElement SixteenGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[3]/a/img"));
		ElementDisplayed(SixteenGB, "16GB memory");
		ValidateDeselect(SixteenGB);

		//32GB

		WebElement ThirtyTwoGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[4]/a/img"));
		ElementDisplayed(ThirtyTwoGB, "32GB memory");
		ValidateDeselect(ThirtyTwoGB);

		//64GB
		WebElement SixtyfourGB = driver.findElement(By.xpath(".//*[@id='ref_7805160011']/li[5]/a/img"));
		ElementDisplayed(SixtyfourGB, "64GB memory");
		ValidateDeselect(SixtyfourGB);

		//cell phone display size option

		WebElement displaySize = driver.findElement(By.xpath(".//*[@id='refinements']/h2[10]"));
		ElementDisplayed(displaySize, "Cell Phone Display Size");

		//3.9 Inches  Under Option
		WebElement Inches = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[1]/a/img"));
		ElementDisplayed(Inches, "3.9 Inches & Under");
		ValidateDeselect(Inches);
		//4.0 to 4.4 Inches  Option
		WebElement Inches1 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[2]/a/img"));
		ElementDisplayed(Inches1, "4.0 to 4.4 Inches");
		ValidateDeselect(Inches1);
		//4.5 to 4.9 Inches Option
		WebElement Inches2 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[3]/a/img"));
		ElementDisplayed(Inches2, "4.5 to 4.9 Inches");
		ValidateDeselect(Inches2);
		//5.0 to 5.4 Inches Option
		WebElement Inches3 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[4]/a/img"));
		ElementDisplayed(Inches3, "5.0 to 5.4 Inches");
		ValidateDeselect(Inches3);
		//5.5 Inches & Over Option
		WebElement Inches4 = driver.findElement(By.xpath(".//*[@id='ref_6215726011']/li[5]/a/img"));
		ElementDisplayed(Inches4, "35.5 Inches & Over");
		ValidateDeselect(Inches4);


		//Cell Phone Compatibility Option
		WebElement PhComp = driver.findElement(By.xpath(".//*[@id='refinements']/h2[12]"));
		ElementDisplayed(PhComp, "Cell Phone Compatibility");

		//iPhone 6 Option
		WebElement Iphone6 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[1]/a/img"));
		ElementDisplayed(Iphone6, "iPhone 6/6S");
		ValidateDeselect(Iphone6);
		
		//iPhone 6Plus  Option
		WebElement Iphone6plus = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[2]/a/img"));
		ElementDisplayed(Iphone6plus, "iPhone 6/6S Plus");
		ValidateDeselect(Iphone6plus);
		
		//iPhone  5  option
		WebElement Iphone5 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[3]/a/img"));
		ElementDisplayed(Iphone5, "iPhone  5/5S/SE ");
		ValidateDeselect(Iphone5);
				
		//iPhone 5C Option 
		WebElement Iphone5C = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[4]/a/img"));
		ElementDisplayed(Iphone5C, "iPhone 5C");
		ValidateDeselect(Iphone5C);
		
		//iPhone 4/4S Option
		WebElement Iphone4 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[5]/a/img"));
		ElementDisplayed(Iphone4, "iPhone 4/4S");
		ValidateDeselect(Iphone4);
		
		//Samsung Galaxy S 7 Option
		WebElement GalaxyS7 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[6]/span/img"));
		ElementDisplayed(GalaxyS7, "Samsung Galaxy S 7");
		ValidateDeselect(GalaxyS7);
		
		//Samsung Galaxy S 7 Edge Option
		WebElement GalaxyS7Edge = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[7]/span/img"));
		ElementDisplayed(GalaxyS7Edge, "Samsung Galaxy S 7 Edge");
		ValidateDeselect(GalaxyS7Edge);
		
		//Samsung Galaxy S 6 option
		WebElement GalaxyS6 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[8]/a/img"));
		ElementDisplayed(GalaxyS6, "Samsung Galaxy S 6");
		ValidateDeselect(GalaxyS6);
		
		//Samsung Galaxy S 6 Edge option
		WebElement GalaxyS6Edge = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[9]/a/img"));
		ElementDisplayed(GalaxyS6Edge, "Samsung Galaxy S 6 Edge");
		ValidateDeselect(GalaxyS6Edge);
		
		//Samsung Galaxy S 5  option
		WebElement GalaxyS5 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[10]/a/img"));
		ElementDisplayed(GalaxyS5, "Samsung Galaxy S 5 ");
		ValidateDeselect(GalaxyS5);
		
		//Samsung Galaxy S 4  option
		WebElement GalaxyS4 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[11]/a/img"));
		ElementDisplayed(GalaxyS4, "Samsung Galaxy S 4 ");
		ValidateDeselect(GalaxyS4);
		
		
		//Samsung Galaxy Note 4  option
		WebElement Note4 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[12]/a/img"));
		ElementDisplayed(Note4, "Samsung Galaxy Note 4 ");
		ValidateDeselect(Note4);
		
		//LG G3 Option
		WebElement LGG3 = driver.findElement(By.xpath(".//*[@id='ref_2488708011']/li[13]/a/img"));
		ElementDisplayed(LGG3, "LG G3");
		ValidateDeselect(LGG3);


		bw.close();
		driver.quit();

	}
   //Test case--08
	
	
	public static void CheckMainTab() throws Exception{
		startReport("CheckMainTab", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");
		
		//Launch the browser
		driver = new FirefoxDriver();

		AmazonModule.OpenAmazon();

		Update_Report("Pass", "Launch Amazon Application", "Amazon Application is launched");
		
		
		WebElement department = driver.findElement(By.xpath("//a[@id='nav-link-shopall']/span[2]"));
		ElementDisplayed(department, "Shop by Department");
		
		
		//Verifying link
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.amazon.com/";
		if (actualURL.equals(expectedURL)){
			Update_Report("Pass", actualURL, actualURL+" is same as expected URL"+expectedURL);
		}else{
			Update_Report("Fail", actualURL, actualURL+" is not same as expected URL"+expectedURL);
		}
				
	   //Today's deal
	
		WebElement todaysDeal = driver.findElement(By.xpath("//div[@id='nav-xshop-container']//div[@id='nav-xshop']//a[2]"));
		ElementDisplayed(todaysDeal, "Today's Deals");
		
		//Verifying GiftCards
		
		WebElement giftCard = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[3]"));
		ElementDisplayed(giftCard, "Gift Cards");
		
		//Verify sell
		WebElement sell = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[4]"));
		ElementDisplayed(sell, "Sell");
		
		//verifying help
		WebElement help = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[5]"));
		ElementDisplayed(help, "Help");
				
		//verifying hello sign in
		WebElement signIn = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[1]"));
		ElementDisplayed(signIn, "'Hello. Sign in  Your Account");
		
		//verifying prime
		WebElement prime = driver.findElement(By.xpath("//a[@id='nav-link-prime']/span[2]"));
		ElementDisplayed(prime, "Try Prime");
		
		//verifying lists
		WebElement lists = driver.findElement(By.xpath("//a[@id='nav-link-wishlist']/span[2]"));
		ElementDisplayed(lists, "Your Lists");
		
		//verifying cart
		WebElement cart = driver.findElement(By.xpath("//a[@id='nav-link-wishlist']/span[2]"));
		ElementDisplayed(cart, "Cart");
	    	
		
		bw.close();
		 
    	driver.quit();
	 
 }
	
//Text Case --09
	
	public static void Department() throws Exception{
		startReport("Department", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");
		String[] expMenuElements = {"Amazon Video","Digital & Prime Music", "Appstore for Android","Amazon Photos & Drive", "Kindle E-readers & Books","Fire Tablets","Fire TV","Echo & Alexa","AmazonFresh NEW","Books & Audible","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools","Beauty, Health & Grocery","Toys, Kids & Baby","Clothing, Shoes & Jewelry","Sports & Outdoors","Automotive & Industrial","Handmade","Home Services","Credit & Payment Products","Full Store Directory" };

		//Launch the browser
		driver = new FirefoxDriver();

		AmazonModule.OpenAmazon();

		Update_Report("Pass", "Launch Amazon Application", "Amazon Application is launched");
		
		WebElement department = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		ElementDisplayed(department, "Department tab");
		        
		//Actions action = new Actions(driver);
		
		Thread.sleep(5000);
		String[] DropdownElement = department.getText().split("[\\r\\n]+");
		try{
		for(int i = 0; i <expMenuElements.length-1; i++){
			Actions action = new Actions(driver);
			action.moveToElement(department).build().perform();
			
			if(DropdownElement[i].equalsIgnoreCase(expMenuElements[i])){
				Update_Report("Pass", "validateElementInDropdown",  "Expected menu item is: "  +expMenuElements[i]+ " is matched to actual item: "+DropdownElement[i]);

			}
			else{
				Update_Report("Fail", "validateElementInDropdown",  "Expected menu item is: "  +expMenuElements[i]+ " is not matched to actual item: "+DropdownElement[i]);

			}}

		}catch(Exception e){
		System.out.println(e);	
		}
				
		
	bw.close();
	driver.quit();
	}
	
	//Test Case 010>>>> Validate 'Your Account' dropdown list
	 public static void yourAccount()throws Exception{
		 
		 startReport("yourAccount", "C:/Users/ADMIN/Desktop/framework/AmazonReport/");
		 //Launch the browser
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.com/");
		 
		 Thread.sleep(3000);
		 
		//dropdown youraccount
		 WebElement yourAccount = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[2]"));
		 String account = yourAccount.getText();
		
			Actions action = new Actions(driver);
			
			Thread.sleep(5000);
			action.moveToElement(yourAccount).build().perform();
					
			 WebElement list = driver.findElement(By.xpath("//div[@id='nav-belt']//div[@id='nav-flyout-yourAccount']"));
			 
			 java.util.List<WebElement> options = list.findElements(By.tagName("div"));
			 
			 String expElements[]= new String[options.size()]; 
		     for (int i = 0 ; i < options.size(); i++) {
		    	 
			    	 	if(options.get(i).getText()!= null){
			    	     	System.out.println(options.get(i).getText());
			    	   	    expElements[i] = options.get(i).getText(); 
			    	    	    	   
			    	}
			  
		     }
		     
		     System.out.println("---------------------------");
		     for(int j = 0 ; j < expElements.length; j++){
				   
				   System.out.println(expElements[j]);
				   
				   
			   }
}}
