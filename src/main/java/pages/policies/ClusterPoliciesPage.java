package pages.policies;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import pages.cluster.InsideClusterPage;
import utils.LibraryUtils;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.*;

public class ClusterPoliciesPage extends LibraryUtils {

    private WebDriver driver;
    private SelenideElement addClusterPolicyButton=$x("//button[contains(.,'Add Cluster Policy')]");
    private SelenideElement nameInputField=$x("//input[@id='name']");
    private SelenideElement clusterTypeDropdown=$x("//span[@id='select2-clusterMode-container']");
    private SelenideElement cloudProviderDropdown=$x("//select[@id='cloud']");
    private SelenideElement nextButton=$x("//button[contains(@class,'btn-next')]");
    private SelenideElement finishButton=$x("//button[contains(@class,'btn-finish')]");
    private SelenideElement kubernetesVersionDropdown=$x("//select[@id='version']");

    public ClusterPoliciesPage(WebDriver driver){
        this.driver=driver;
        addClusterPolicyButton.shouldBe(visible);
    }

    public ClusterPoliciesPage clickAddClusterPolicy(){
        click("Add Cluster Policy Button",addClusterPolicyButton);
        return this;
    }

    public ClusterPoliciesPage setPolicyName(String clusterPolicyName){
        type("Policy Name Input Field",nameInputField,clusterPolicyName);
        return this;
    }

    public ClusterPoliciesPage selectClusterTypeFromDropdown(String clusterTypeValue){
        select2OptionByText("Cluster Type Dropdown",clusterTypeDropdown,clusterTypeValue);
        return this;
    }

    public ClusterPoliciesPage selectCloudProviderFromDropdown(String cloudProviderValue){
        selectOptionByValue("Cloud Provider Dropdown",cloudProviderDropdown,cloudProviderValue);
        return this;
    }

    public ClusterPoliciesPage selectKubernetesVersionFromDropdown(String kubernetesVersionValue){
        selectOptionByValue("Kubernetes Version Dropdown",kubernetesVersionDropdown,kubernetesVersionValue);
        return this;
    }

    public ClusterPoliciesPage clickNextButton(){
        click("Next Button",nextButton);
        return this;
    }

    public InsideClusterPolicyPage clickFinishButton(){
        click("Finish Button", finishButton);
        finishButton.should(disappear);
        return new InsideClusterPolicyPage(driver);
    }

    public InsideClusterPolicyPage clickClusterPolicyWithName(String clusterPolicyName){
        SelenideElement clusterPolicy = $x("//*[@class='rt-tr-group']//*[text()='"+clusterPolicyName+"']");
        click("Cluster Policy "+clusterPolicyName, clusterPolicy);
        return new InsideClusterPolicyPage(driver);
    }

    public ClusterPoliciesPage isCreatedClusterPolicyDisplayed(String clusterPolicyName){
        assertTrue(isClusterPolicyDisplayed(clusterPolicyName),"Cluster Policy Was Not Created");
        return this;
    }

    public ClusterPoliciesPage isDeletedClusterPolicyDisplayed(String clusterPolicyName){
        assertFalse(isClusterPolicyDisplayed(clusterPolicyName),"Cluster Policy Was Not Deleted");
        return this;
    }

    private boolean isClusterPolicyDisplayed(String clusterPolicyName) {
        addClusterPolicyButton.shouldBe(visible);
        boolean found = false;
        SelenideElement clusterPolicy = $x("//*[@class='rt-tr-group']//*[text()='"+clusterPolicyName+"']");


        if (clusterPolicy.exists()) {
            found = true;
        }
        return found;
    }





}
