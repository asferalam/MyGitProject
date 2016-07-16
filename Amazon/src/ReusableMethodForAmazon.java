import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class ReusableMethodForAmazon {
	

	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	
	/*Name of the Method:enterText
	 * Brief description: Enter text value to text boxes
	 * Arguments: obj--> Webelement Object, textval-->Text to be entered, objName-->Object name
	 * Created By: TechPirates
	 * Created Date: June 29 2016
	 * Last Modified: June 29 2016
	 */
	public static void enterText(WebElement obj,String textVal,String objName) throws IOException{
    	if(obj.isDisplayed()){
	    	Update_Report("Pass", "enterText", textVal+ " is entered in " +objName +" field");
	    	obj.sendKeys(textVal);
	    }
	    else{
	    	Update_Report("Fail", "enterText", objName +" field not displayed.Please check your application");
	    			        
	    }
	    }
	

	/*Name of the Method:clickElement
	 * Brief description: click on a web element
	 * Arguments:  obj--->webelement object, objName-->Object Name
	 * Created By: TechPirates
	 * Created Date: June 29 2016
	 * Last Modified: June 29 2016
	 */
	public static void clickElement(WebElement obj,String objName) throws IOException{
	if(obj.isDisplayed()){
		obj.click();
		Update_Report("Pass", "clickElement", objName+ " is clicked");
	}else{
		Update_Report("Fail", "clickElement", objName+ "is not displayed please check your application");
		
	
	}
}

	
	
	
	/*Name of the method: ValidateCheckbox
	 * Brief Description: validate check Box
	 * Arguments:obj--->webElement object
	 * created By:  Techpirates
	 * Creation date:June 29 2016
	 * Last Modification:June 29 2016
	 */
	public static void ValidateCheckBox(WebElement obj) throws IOException{
		if(obj.isDisplayed()){
			boolean click;
			click=obj.isSelected();
			
			if(click==false){
				obj.click();
			}else
				System.out.println("Checkbox is already selected");
		}else{
			Update_Report("Fail", "ValidateCheckBox", obj + " Checkbox field is not displayed please check your application ");
		}
				
			
	}
	
	
	
	
	/*Name of the method: ValidateDeselect
	 * Brief Description: validate check Box
	 * Arguments:obj--->webElement object
	 * created By:  Techpirates
	 * Creation date:June 29 2016
	 * Last Modification:June 29 2016
	 */
	public static void ValidateDeselect(WebElement obj) throws IOException{
		if(obj.isDisplayed()){
			boolean click;
			click=obj.isSelected();
			
			if(click==true){
				obj.click();
			}else
				System.out.println("Already deselected");
		}else{
			Update_Report("Fail", "ValidateDeselect", obj + " Checkbox field is not displayed please check your application ");
		}
				
			
	}
	
	
	/* Name of the Method: validateElementInDropdown
	 * Brief description: validate drop down menu text //div -tag
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 5 2016
	 * Last Modified: July 5 2016
	 * */
	public static void validateElementInDropdown(WebElement obj, String[] expectedDropdownElement, String objname) throws IOException{
		String[] DropdownElement = obj.getText().split("[\\r\\n]+");
		
			for(int i = 0; i <expectedDropdownElement.length; i++){
              
				
				if(DropdownElement[i].equalsIgnoreCase(expectedDropdownElement[i])){
					Update_Report("Pass", "validateElementInDropdown",  "Expected menu item is: "  +expectedDropdownElement[i]+ " is matched to actual item: "+DropdownElement[i]);

				}
				else{
					Update_Report("Fail", "validateElementInDropdown",  "Expected menu item is: "  +expectedDropdownElement[i]+ " is not matched to actual item: "+DropdownElement[i]);

				}

			}}

			
	
	
	
	
	public static void ElementDisplayed(WebElement obj, String objname) throws Exception{
	if(obj.isDisplayed()){
		Update_Report("Pass", objname, objname+"  option is available");
	}else{
		Update_Report("Fail", objname, objname+"  option is not available.Please check your application");
	}
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void test() throws Exception {

		startReport("Decending order sort","C:/Users/ADMIN/Desktop/framework/AmazonReport/");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		Update_Report( "Fail", "Decending order sort",  "Decending order sort executing is complete.");
		
		bw.close();


	}


	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
}

