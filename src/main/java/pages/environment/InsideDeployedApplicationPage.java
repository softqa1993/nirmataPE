package pages.environment;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import utils.LibraryUtils;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.*;

public class InsideDeployedApplicationPage extends LibraryUtils {


    private SelenideElement actionButton= $x("//a[@class='btn btn-default dropdown-toggle']");
    private SelenideElement modelContentPanelTitle= $x("//h1[@id='model-content-panel-title']");
    private SelenideElement deleteApplicationButton= $x("//a[@id='deleteApplication']");
    private SelenideElement deleteOnClusterCheckbox=$x("//input[@id='deleteOnCluster']");
    private SelenideElement deleteButton=$x("//button[contains(.,'Delete')]");
    private SelenideElement nameInputField=$x("//input[@id='run']");
    private SelenideElement runningDeploymentState=$x("//span[@id='state-popover'][contains(.,'Running')]");
    private SelenideElement degradedDeploymentState=$x("//span[@id='state-popover'][contains(.,'Degraded')]");
    private SelenideElement executingDeploymentState=$x("//span[@id='state-popover'][contains(.,'Executing')]");
    private SelenideElement failedDeploymentState=$x("//span[@id='state-popover'][contains(.,'Failed')]");
    private SelenideElement importToApplicationButton=$x("//a[@id='importApplication']");
    private SelenideElement yamlInputField=$x("(//input[@class='dz-hidden-input'])[1]");
    private SelenideElement yaml=$x("//div[@class='dz-details']");
    private SelenideElement importButton=$x("//button[text()='Import']");
    private SelenideElement deleteDeploymentButton=$x("//a[@id='deleteComponent']");
    private SelenideElement deploymentNameInputField=$x("//input[@id='name']");
    private SelenideElement alarmsButton=$x("//li[@id='alarms']");
    private SelenideElement cloneApplicationButton=$x("//a[@id='cloneApplication']");
    private SelenideElement targetEnvironmentDropdown=$x("//select[@id='environment']");
    private SelenideElement cloneButton=$x("//button[contains(.,'Clone Application')]");

    private SelenideElement deployment;
    private WebDriver driver;

    public InsideDeployedApplicationPage(WebDriver driver){
        this.driver=driver;
        actionButton.shouldBe(visible);
        modelContentPanelTitle.shouldBe(visible);

    }

    public InsideDeployedApplicationPage verifyPanelTitle(String appDeployName){
        waitFor("Content Panel Title",modelContentPanelTitle);
        assertEquals(modelContentPanelTitle.text(),appDeployName,"Incorrect deployed application title");
        return this;
    }

    public InsideDeployedApplicationPage verifyPageTitle(String environmentName, String appDeployName){
        assertEquals(title(), "Nirmata | Environments | "+environmentName+" | "+appDeployName+" | Workloads", "Incorrect Page Title");
        return this;
    }

    public InsideDeployedApplicationPage clickActionButton(){
        click("Action Button",actionButton);
        return this;
    }

    public InsideDeployedApplicationPage clickDeleteApplicationButton(){
        click("Delete Application Button",deleteApplicationButton);
        return this;
    }

    public InsideDeployedApplicationPage checkDeleteOnClusterIfNecessary(){
        deleteButton.shouldBe(visible);
        if(deleteOnClusterCheckbox.exists()){
            click("Delete On Cluster Checkbox",deleteOnClusterCheckbox);
        }
        return this;
    }

    public InsideDeployedApplicationPage setApplicationNameToDeleteIfNecessary(String applicationName){
        deleteButton.shouldBe(visible);
        if(nameInputField.exists()){
            type("Application Name",nameInputField,applicationName);
        }
        return this;
    }

    public InsideEnvironmentPage clickDeleteButton(){
        click("Delete Button",deleteButton);
        deleteButton.should(disappear);
        waitFor("Executing Deployment State",executingDeploymentState);
        return new InsideEnvironmentPage(driver);
    }

    public InsideDeployedApplicationPage waitForDegradedApplicationState(){
        waitFor("Degraded Application State",degradedDeploymentState,120);
        return this;
    }

    public InsideDeployedApplicationPage waitForRunningApplicationState(){
        waitFor("Running Application State",runningDeploymentState,150);
        return this;
    }

    public InsideDeployedApplicationPage waitForExecutingApplicationState(){
        waitFor("Running Application State",executingDeploymentState,120);
        return this;
    }

    public InsideDeployedApplicationPage clickImportToApplicationButton(){
        click("Import To Application Button",importToApplicationButton);
        return this;
    }

    public InsideDeployedApplicationPage setYamlFile(String yamlName){
        absolutePathOfFile+="/resources/yaml/"+ yamlName+".yaml";
        upload("Yaml File "+yamlName+".yaml",yamlInputField,absolutePathOfFile);
        return this;
    }

    public InsideDeployedApplicationPage clickImportButton(){
        click("Import Button",importButton);
        return this;
    }

    public InsideDeployedApplicationPage waitForExecutingDeploymentState(String deploymentName){
        deployment=$x("//tr[contains(.,'"+deploymentName+"')][contains(.,'Executing')]");
        waitFor("Executing Deployment State", deployment,120);
        return this;
    }

    public InsideDeployedApplicationPage waitForRunningDeploymentState(String deploymentName){
        deployment=$x("//tr[contains(.,'"+deploymentName+"')][contains(.,'Running')]");
        waitFor("Running Deployment State", deployment,120);
        return this;
    }

    public InsideDeployedApplicationPage clickOnDeployment(String deploymentName){
        deployment=$x("//tr//a[contains(text(),'"+deploymentName+"')]");
        click("Deployment "+deploymentName,deployment);
        return this;
    }

    public InsideDeployedApplicationPage clickDeleteDeploymentButton(){
        click("Delete Deployment Button",deleteDeploymentButton);
        return this;
    }

    public InsideDeployedApplicationPage setDeploymentNameToDelete(String deploymentName){
        type("Name Input Field",deploymentNameInputField,deploymentName);
        return this;
    }

    public InsideDeployedApplicationPage clickDelete(){
        click("Delete Button",deleteButton);
        return this;
    }

    public InsideDeployedApplicationPage isCreatedDeploymentDisplayed(String deploymentName){
        deployment=$x("//tr//a[contains(text(),'"+deploymentName+"')]");
        assertTrue(deployment.exists(),"Yaml File Was Not Applied");
        return this;
    }

    public InsideDeployedApplicationPage isDeletedDeploymentDisplayed(String deploymentName){
        deployment=$x("//tr//a[contains(text(),'"+deploymentName+"')]");
        deployment.shouldNotBe(visible);
        assertFalse(deployment.exists(),"Deployment was not deleted");
        return this;
    }

    public InsideDeployedApplicationPage clickCloneApplicationButton(){
        click("Clone Application Button",cloneApplicationButton);
        return this;
    }

    public InsideDeployedApplicationPage setNewNameForClonedApplication(String clonedApplicationName){
        type("Clone Application Name Input Field",nameInputField,clonedApplicationName);
        return this;
    }

    public InsideDeployedApplicationPage selectEnvironmentFromDropdown(String environmentName){
        selectOptionByText("Environment Dropdown",targetEnvironmentDropdown,environmentName);
        return this;
    }

    public InsideDeployedApplicationPage clickCloneButton(){
        click("Clone Button", cloneButton);
        return this;
    }


}