package stepDefinations;

import ConnectionDB.DemoConnectionDB;
import com.mysql.cj.jdbc.ConnectionImpl;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.*;

public class AmazonStepDefination {
    public static final String Data_URL="jdbc:mysql://localhost/db";
    public static final String USER_DB="user";
    public static final String PASSWORD_DB="password";
    private Connection connection;
    private Statement statement;

    public static void setUpDB() throws SQLException,ClassNotFoundException{
        Connection connect = null;
        String sql="SELECT * FROM SiteProduct";
        try {
            connect = DriverManager.getConnection(Data_URL, USER_DB, PASSWORD_DB);
            Statement   statement= connect.createStatement();
            ResultSet data=statement.executeQuery(sql);
            if (connect !=null){
                System.out.println("sdasdasdasd");
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
    public void tearDown() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    AmazonPage amazonPage=new AmazonPage();

    @Given("User navigates to {string}")
    public void user_navigates_to(String demoURL) {
        Driver.getDriver().get(ConfigReader.getProperty(demoURL));
        amazonPage.rejectCookie.click();

    }

    @When("User writes some {string} into the searchbox and starts search")
    public void user_writes_some_into_the_searchbox_and_starts_search(String products) {
        amazonPage.searchBox.sendKeys(products, Keys.ENTER);

    }

    @Then("User clicks first result element")
    public void user_clicks_first_result_element() {
        amazonPage.clickFirstElement.click();


    }

    @Then("User gets productname and productprice")
    public void user_gets_productname_and_productprice() throws ClassNotFoundException,SQLException {
        ReusableMethods.waitForVisibility(amazonPage.productName,10);
        try {


            setUpDB();
            String sqlInsert = "INSERT INTO SiteProduct (ProductName ,ProductPrice) VALUES(?,?)";
            if (connection ==null){
                setUpDB();
                return;
            }
            ReusableMethods.waitForVisibility(amazonPage.productName,10);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, amazonPage.productName.getText());
            preparedStatement.setString(2, amazonPage.productPrice.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        } finally {
            tearDown();
        }
    }

    @Then("User closes to browser")
    public void user_closes_to_browser() {
        Driver.quitDriver();
    }





    }



