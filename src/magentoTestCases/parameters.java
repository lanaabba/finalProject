package magentoTestCases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class parameters {
	SoftAssert softassert = new SoftAssert();

	static WebDriver driver = new ChromeDriver ();
	Random rand=new Random();
	int RandomIndexForEmail=rand.nextInt(999);
	
static String ss = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
	static String TheWebSite="https://magento.softwaretestingboard.com/";
	static String SingUp="https://magento.softwaretestingboard.com/customer/account/create";
	static String [] FirstNames = {"Dana" ,"mera","Dania"};
	static String [] lastNames = {"Omar","Ahmad","Sami"};
    static String logOut="https://magento.softwaretestingboard.com/customer/account/logout/\"";
    static String logIn ="https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dC8%2C/";
    static String logInUrl="https://magento.softwaretestingboard.com/";
	int randomIndexForTheName= rand.nextInt(3);
	String firstName=FirstNames[randomIndexForTheName];
	String lastName=lastNames[randomIndexForTheName];
	String Email =firstName+lastName+RandomIndexForEmail+"@gamil.com";
	String password ="ASDasd123!" ;
	
	


}
