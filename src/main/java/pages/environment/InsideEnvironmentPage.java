package pages.environment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import pages.catalog.catalog.InsideApplicationPage;
import utils.LibraryUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class InsideEnvironmentPage extends LibraryUtils {

    private final SelenideElement runAnApplicationButton= $x("//*[@id='launchApplication']");
    private final SelenideElement modelContentPanelTitle= $x("//h1[@id='model-content-panel-title']");
    private final SelenideElement actionButton= $x("//*[contains(@class,'btn-lg dropdown-toggle')]");
    private final SelenideElement nameInputField=$x("//input[@id='run']");
    private final SelenideElement runApplicationButton=$x("//button[text()='Run Application']");
    private final SelenideElement upstreamTypeDropdown=$x("//select[@id='upstreamType']");
    private final SelenideElement catalogApplicationDropdown=$x("//select[@id='application']");
    private final SelenideElement deleteEnvironmentButton=$x("//a[@id='deleteEnvironment']");
    private final SelenideElement deleteAllApplicationsCheckbox=$x("//input[@id='deleteAllApplications']");
    private final SelenideElement deleteFromClusterCheckbox=$x("//input[@id='deleteOnCluster']");
    private final SelenideElement deleteButton=$x("//button[text()='Delete']");
    private final SelenideElement pendingDeleteState=$x("//span[@id='state-popover'][contains(.,'Pending Delete')]");
    private final SelenideElement applicationRunningState=$x("//span[@id='state-popover'][contains(.,'Running')]");
    private final SelenideElement applicationExecutingState=$x("//span[@id='state-popover'][contains(.,'Executing')]");
    private final SelenideElement clusterConnectedState=$x("//span[@id='state-popover'][contains(.,'Cluster Connected')]");
    private final SelenideElement toggleTableView=$x("//img[@id='toggleTableView']");
    private final SelenideElement toggleCardView=$x("//img[@id='toggleCardView']");
    private final SelenideElement nextButtonEnabled=$x("//button[contains(text(),'Next')][not(@disabled)]");
    private final SelenideElement nextButton = $x("//button[contains(text(),'Next')]");
    private final SelenideElement modalDialog=$x("//div[@class='modal-dialog']");
    private final SelenideElement applicationButton=$x("//li[@id='applications']");
    private final SelenideElement environmentLabel=$x("//div[@class='pull-left model-index-name'][contains(.,'Environment')]");
    private SelenideElement deployment, runningApplicationLink;
    private boolean found=false;


    private final WebDriver driver;


    public InsideEnvironmentPage(WebDriver driver){
        this.driver=driver;
        environmentLabel.shouldBe(visible);
        actionButton.shouldBe(visible);
        modelContentPanelTitle.shouldBe(visible);
        applicationButton.shouldBe(visible)
                .shouldHave(text("Applications"));
    }

    public InsideEnvironmentPage verifyPanelTitle(String environmentName){
        assertEquals(modelContentPanelTitle.text(),environmentName, "Incorrect environment name");
        return this;
    }

    public InsideEnvironmentPage clickRunAnApplicationButton(){
        click("Run Application Button",runAnApplicationButton);
        return this;
    }

    public InsideEnvironmentPage setNameInputField(String runName){
        type("Name Input Field",nameInputField,runName);
        return this;
    }

    public InsideEnvironmentPage selectUpstreamTypeFromDropdown(String upstreamType){
        selectOptionByText("Upstream Type Dropdown ",upstreamTypeDropdown,upstreamType);
        return this;
    }

    public InsideEnvironmentPage selectCatalogApplicationFromDropdown(String applicationName) {
        selectOptionByText("Catalog Application Dropdown ", catalogApplicationDropdown, applicationName);
        return this;
    }

    public InsideRunningApplicationPage clickRunApplicationButton(){
        click("Run Application Button",runApplicationButton);
        runAnApplicationButton.should(disappear);
        return new InsideRunningApplicationPage(driver);
    }

    public InsideEnvironmentPage clickActionButton(){
        click("Action Button",actionButton);
        return this;
    }

    public InsideEnvironmentPage clickDeleteEnvironmentButton(){
        click("Delete Environment Button",deleteEnvironmentButton);
        return this;
    }

    public InsideEnvironmentPage checkDeleteApplicationsCheckboxIfNecessary(){
        modalDialog.shouldBe(visible);
        if(deleteAllApplicationsCheckbox.exists()){
            click("Delete Application Checkbox",deleteAllApplicationsCheckbox);
        }
        return this;
    }

    public InsideEnvironmentPage checkDeleteFromClusterCheckboxIfNecessary(){
        modalDialog.shouldBe(visible);
        if(deleteFromClusterCheckbox.exists()){
            click("Delete From Cluster Checkbox",deleteFromClusterCheckbox);
        }
        return this;
    }


    public InsideEnvironmentPage setEnvironmentNameIfNecessary(String environmentName){
        modalDialog.shouldBe(visible);
        if(nameInputField.isDisplayed()){
            type("Name Input Field",nameInputField,environmentName);
        }
        return this;
    }

    public EnvironmentsPage clickDeleteButton(){
       click("Delete Button",deleteButton);
       deleteButton.should(disappear);
        return new EnvironmentsPage(driver);
    }

    public InsideEnvironmentPage isDeletedDeploymentDisplayed(String appDeployName){
        assertFalse(isDeploymentDisplayed(appDeployName),"Deployment was not deleted");
        return this;
    }


    public boolean isDeploymentDisplayed(String deploymentName){
        actionButton.shouldBe(visible);

        if(toggleTableView.exists()){
            deployment=$x("//div[@class='card-title']//*[text()='"+deploymentName+"']");
        }else if(toggleCardView.exists()){
            deployment=$x("//div[@class='runningAppName']//*[text()='"+deploymentName+"']");
        }

            if (deployment!=null && deployment.exists()) {
                found = true;
            } else
                if(nextButton.exists()){
                    if (nextButtonEnabled.exists()) {
                        do {
                            nextButton.click();
                            if (deployment.exists()){
                                found = true;
                                break;
                            }
                        }
                        while (nextButtonEnabled.exists());
                    }
                }
        return found;
    }


    public InsideRunningApplicationPage clickRunningApplicationWithName(String runningApplicationName){
        actionButton.shouldBe(visible);

        if(toggleTableView.exists()){
            runningApplicationLink=$x("//div[@class='card-title']//*[text()='"+runningApplicationName+"']");
        }else if(toggleCardView.exists()){
            runningApplicationLink=$x("//div[@class='application-name']//*[text()='"+runningApplicationName+"']");
        }
        click("Running Application Link: "+runningApplicationName,runningApplicationLink);
        return new InsideRunningApplicationPage(driver);
    }


    public InsideEnvironmentPage waitForClusterConnectedStatus(){
        waitFor("Cluster Connected Status",clusterConnectedState,120);
        return this;
    }
}
