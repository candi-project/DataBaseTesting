import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host="localhost";
		String port="3306";
		
		Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port, "root", "0apob6059");
		Statement s=con.createStatement();
		
		s.executeQuery("use Demo");
		ResultSet rs=s.executeQuery("select * from credentials where scenario='zero_balance_card'");
		
		while(rs.next())
		{
		/*
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		*/
			System.setProperty("webdriver.chrome.driver", "/Users/candichiu/Documents/chromedriver92");
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://login.salesforce.com/");
			
			driver.findElement(By.cssSelector("#username")).sendKeys(rs.getString("username"));
			driver.findElement(By.name("pw")).sendKeys(rs.getString("password"));
			
			
		}	
		
	}

}
