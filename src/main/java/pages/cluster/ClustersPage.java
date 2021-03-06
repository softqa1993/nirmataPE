package pages.cluster;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.LibraryUtils;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;


public class ClustersPage extends LibraryUtils {

    private final SelenideElement toggleCardView=$x("//img[@id='toggleCardView']");
    private final SelenideElement toggleTableView=$x("//img[@id='toggleTableView']");
    private final SelenideElement addClusterButton= $x("//button[contains(.,'Add Cluster')]");
    private final SelenideElement createClusterButton= $x("//div[contains(.,'Create a Cluster')]");
    private final SelenideElement actionButton=$x("//div[@class='btn-group']");
    private final SelenideElement modelContentPanelTitle= $x("//h1[@id='model-content-panel-title']");
    private final SelenideElement filterButton= $x("//span[@id='filter-toggle-button']");
    private final SelenideElement setupButton= $x("(//button[contains(.,'Setup')])[1]");
    private final SelenideElement nextButton = $x("//button[contains(text(),'Next')]");
    private final SelenideElement nextButtonEnabled=$x("//button[contains(text(),'Next')][not(@disabled)]");
    private final SelenideElement acceptSelfSignedCertificate=$x("//input[@id='acceptAnyCert']");
    private final SelenideElement acceptText=$x("//span[contains(text(),'Accept Self-signed Certificate')]");
    //manage existing cluster
    private final SelenideElement manageExistingKubernetesClusterOption= $x("//div[contains(text(),'Manage an existing Kubernetes cluster')]");
    private final SelenideElement inputNameForDiscoveredCluster= $x("//div[@id='k8sDiscoveredCluster']//input[@id='name']");
    private final SelenideElement discoveredCloudProviderDropdown= $x("//select[@id='cloudProvider']");
    private final SelenideElement discoveredClusterPolicyDropdown= $x("//div[@id='k8sDiscoveredCluster']//select[@id='policySelector']");
    private final SelenideElement inputEndpointsForDiscoveredCluster= $x("//div[@id='k8sDiscoveredCluster']//input[@id='endpoint']");
    private final SelenideElement discoveredAcceptSelfSignCertificatesCheckbox= $x("//div[@id='k8sDiscoveredCluster']//div[@class='icheckbox_square-blue']");
    private final SelenideElement importKubernetesClusterButton= $x("//button[contains(.,'Import Kubernetes Cluster')]");

    //install and manage cluster
    private final SelenideElement installNewKubernetesClusterOption= $x("//div[contains(text(),'Install a new Kubernetes cluster')]");
  //  private final SelenideElement installNewKubernetesClusterOption= $("div[data-id='managed']");
    private final SelenideElement inputNameForManagedCluster= $x("//div[@id='k8sManagedCluster']//input[@id='name']");
    private final SelenideElement hostGroupDropdown= $x("//*[@id='hostGroups']");
    private final SelenideElement clusterPolicyDropdown= $x("//div[@id='k8sManagedCluster']//select[@id='policySelector']");
    private final SelenideElement createClusterAndStartInstallation= $x("//button[contains(.,'Create Cluster and Start the Installation')]");

    //create gke cluster
    private final SelenideElement createGKEClusterOption= $x("//div[contains(text(),'Create a GKE cluster')]");
    private final SelenideElement inputNameForGKECluster= $x("//div[@id='k8sManagedGkeuserCluster']//input[@id='name']");
    private final SelenideElement gkeCloudProviderDropdown= $x("//div[@id='k8sManagedGkeuserCluster']//*[@id='select2-cloudProviderRef-container']");
    private final SelenideElement gkeRegionDropdown= $x("//div[@id='k8sManagedGkeuserCluster']//*[@id='region']");
    private final SelenideElement gkeKubernetesVersionDropdown= $x("//div[@id='k8sManagedGkeuserCluster']//*[@id='version']");
    private final SelenideElement gkeDiskSizeInputField= $x("//div[@id='k8sManagedGkeuserCluster']//*[@id='diskSize']");
    private final SelenideElement gkeNextButton= $x("//div[@class='modal-footer']//button[contains(.,'Next')]");
    private final SelenideElement gkeMachineTypeDropdown= $x("//select[@id='machineType']");
    private final SelenideElement inputNameForGKENodeCount= $x("//div[@id='k8sManagedGkeworkerCluster']//input[@id='nodeCount']");
  //  private final SelenideElement createClusterButton= $x("//button[contains(.,'Create Cluster')]");
    private final SelenideElement installationButton=$x("//*[contains(text(),'Start the Installation')]");
    //create eks cluster
    private final SelenideElement createEKSClusterOption= $x("//div[contains(text(),'Create an EKS cluster')]");
    private final SelenideElement inputNameForEKSCluster= $x("//div[@id='k8sManagedEksUserCluster']//input[@id='name']");
    private final SelenideElement eksCloudProviderDropdown= $x("//div[@id='k8sManagedEksUserCluster']//*[@id='select2-cloudProviderRef-container']");
    private final SelenideElement eksRegionDropdown= $x("//div[@id='k8sManagedEksUserCluster']//select[@id='region']");
    private final SelenideElement eksKubernetesVersionDropdown= $x("//div[@id='k8sManagedEksUserCluster']//select[@id='version']");
    private final SelenideElement eksVpcIdDropdown= $x("//select[@id='vpcId']");
    private final SelenideElement eksNetworksDropdown= $x("//div[@id='k8sManagedEksUserCluster']//select[@id='subnetId']");
    private final SelenideElement eksSecurityGroupDropdown= $x("//div[@id='k8sManagedEksUserCluster']//select[@id='securityGroups']");
    private final SelenideElement eksPrivateEndpointAccessCheckbox= $x("//div[@class='icheckbox_square-blue checked']");
    private final SelenideElement eksClusterRoleArnDropdown= $x("//select[@id='clusterRoleArn']");
    private final SelenideElement eksNextButton= $x("//div[@class='modal-footer']//button[contains(.,'Next')]");
    private final SelenideElement eksEnableAutoScalingCheckbox= $x("//div[@id='k8sManagedEksWorkerCluster']//*[@class='icheckbox_square-blue']");
    private final SelenideElement eksNodeSecurityGroupDropdown= $x("//div[@id='k8sManagedEksWorkerCluster']//select[@id='securityGroups']");
    private final SelenideElement eksInstanceTypeDropdown= $x("//div[@id='k8sManagedEksWorkerCluster']//select[@id='instanceType']");
    private final SelenideElement eksImageIdInputField= $x("//input[@id='imageId']");
    private final SelenideElement eksInputAutoScalingGroupDesiredCapacity= $x("//div[@id='k8sManagedEksWorkerCluster']//input[@id='nodeAutoScalingGroupDesiredCapacity']");
    private final SelenideElement eksInputAutoScalingGroupMinSize= $x("//div[@id='k8sManagedEksWorkerCluster']//input[@id='nodeAutoScalingGroupMinSize']");
    private final SelenideElement eksInputAutoScalingGroupMaxSize= $x("//div[@id='k8sManagedEksWorkerCluster']//input[@id='nodeAutoScalingGroupMaxSize']");
    private final SelenideElement eksSshKeyDropdown= $x("//select[@id='keyName']");
    private final SelenideElement eksInputDiskSize= $x("//div[@id='k8sManagedEksWorkerCluster']//input[@id='diskSize']");

    //create aks cluster
    private final SelenideElement createAKSClusterOption= $x("//div[contains(text(),'Create an AKS cluster')]");
    private final SelenideElement inputNameForAKSCluster= $x("//div[@id='k8sManagedAksUserCluster']//input[@id='name']");
    private final SelenideElement aksCloudProviderDropdown=$x("//div[@id='k8sManagedAksUserCluster']//*[@id='select2-cloudProviderRef-container']");
    private final SelenideElement aksRegionDropdown=$x("//div[@id='k8sManagedAksUserCluster']//select[@id='region']");
    private final SelenideElement aksKubernetesVersion=$x("//div[@id='k8sManagedAksUserCluster']//*[@id='version']");
    private final SelenideElement aksResourceGroupDropdown=$x("//div[@id='k8sManagedAksUserCluster']//*[@id='resourceGroup']");
    private final SelenideElement aksNextButton=$x("//div[@class='modal-footer']//button[contains(.,'Next')]");
    private final SelenideElement aksNetworkConfigurationDropdown=$x("//select[@id='networkProfile']");
    private final SelenideElement aksClusterSubnetDropdown=$x("//*[@id='k8sManagedAksNetworkCluster']//*[@id='subnetId']");
    private final SelenideElement aksKubernetesServiceAddressRangeInputField=$x("//*[@id='k8sManagedAksNetworkCluster']//*[@id='serviceCidr']");
    private final SelenideElement aksKubernetesDNSServiceIpInputField=$x("//*[@id='k8sManagedAksNetworkCluster']//*[@id='dnsServiceIp']");
    private final SelenideElement aksDockerBridgeAddressInputField=$x("//*[@id='k8sManagedAksNetworkCluster']//*[@id='dockerBridgeCidr']");
    private final SelenideElement aksPodCidrInputField=$x("//*[@id='k8sManagedAksNetworkCluster']//*[@id='podCidr']");
    private final SelenideElement aksHTTPSApplicationRoutingCheckbox=$x("//*[@id='k8sManagedAksNetworkCluster']//*[@class='icheckbox_square-blue']");
    private final SelenideElement aksContainerMonitoringCheckbox=$x("//span[contains(@class,'bootstrap-switch-handle-off bootstrap-switch-default')]");
    private final SelenideElement aksVMSetTypeDropdown=$x("//select[@id='vmSetType']");
    private final SelenideElement aksNodeTypeDropdown=$x("//div[@id='k8sManagedAksWorkerCluster']//*[@id='instanceType']");
    private final SelenideElement aksDiskSizeInput=$x("//*[@id='k8sManagedAksWorkerCluster']//*[@id='diskSize']");
    private final SelenideElement aksNodeCountInput=$x("//*[@id='k8sManagedAksWorkerCluster']//*[@id='nodeCount']");
    private final SelenideElement fetchingMessage=$x("//em[contains(.,'Fetching')]");



    private final SelenideElement runningPreInstallChecksLabel=$x("//span[@class='subtitle'][contains(.,'Running Pre-install Checks')]");
    private final SelenideElement preparingInstallLabel=$x("//span[@class='subtitle'][contains(.,'Preparing Install')]");
    private final SelenideElement deployingClusterLabel=$x("//span[@class='subtitle'][contains(.,'Deploying Cluster')]");
    private final SelenideElement controllerConnectLabel=$x("//span[@class='subtitle'][contains(.,'Waiting For Controller Connect')]");

    private final SelenideElement deployingNirmataControllerLabel=$x("//span[@class='subtitle'][contains(text(),'Deploying Nirmata Controller')]");
    private final SelenideElement viewDetailsOfMyClusterButton=$x("//div[@id='k8sManagedClusterFinish']//div[@id='check-button']");
    private final SelenideElement deployingControlPlaneLabel=$x("//span[@class='subtitle'][contains(.,'Deploying Control Plane')]");
    private final SelenideElement deployingWorkerNodeLabel=$x("//span[@class='subtitle'][contains(.,'Deploying Worker Node')]");
    private final SelenideElement loadingAWSAuthConfigMapLabel=$x("//span[@class='subtitle'][contains(.,'Loading AWS Auth Config Map')]");
    private final SelenideElement deployingMetricsServerLabel=$x("//span[@class='subtitle'][contains(.,'Deploying Metrics Server')]");


    private SelenideElement cluster, readyClusterState,unknownCLusterState,shuttingDownCLusterState,deletedCLusterState;
    private final WebDriver driver;



    public ClustersPage(WebDriver driver){
        this.driver=driver;
        createClusterButton.shouldBe(visible);
        modelContentPanelTitle.shouldBe(visible);
        assertEquals(modelContentPanelTitle.getText(), "Clusters", "Incorrect Panel Title");
//        assertEquals(title(), "Nirmata | Clusters", "Incorrect Page Title");
    }

    public String getPanelTitle(){
        waitFor("Content Panel Title",modelContentPanelTitle);
        return modelContentPanelTitle.text();
    }

    public String getPageTitle(){
        addClusterButton.shouldBe(visible);
        return title();
    }

    public ClustersPage clickAddClusterButton(){
        click("Add Cluster Button",addClusterButton);
        return this;
    }

    public ClustersPage clickManageExistingKubernetesClusterOption(){
        click("Manage Existing Kubernetes Cluster Option",manageExistingKubernetesClusterOption);
        return this;
    }

    public ClustersPage setInputNameForDiscoveredCluster(String clusterName){
        type("Name Input Field",inputNameForDiscoveredCluster,clusterName);
        return this;
    }

    public ClustersPage selectDiscoveredCloudProviderFromDropdown(String cloudProvider){
        selectOptionByText("Cloud Provider Dropdown",discoveredCloudProviderDropdown,cloudProvider);
        return this;
    }

    public ClustersPage selectDiscoveredClusterPolicyFromDropdown(String clusterPolicy){
        selectOptionByText("Cluster Policy Dropdown",discoveredClusterPolicyDropdown,clusterPolicy);
        return this;
    }

    public ClustersPage setInputEndpointForDiscoveredCluster(String inputEndpoint){
        type("Endpoint Input Field",inputEndpointsForDiscoveredCluster,inputEndpoint);
        return this;
    }

    public ClustersPage checkDiscoveredAcceptSelfSignCertificatesCheckbox(){
        click("Accept Self-sign Certificate Checkbox",discoveredAcceptSelfSignCertificatesCheckbox);
        return this;
    }

    public ClustersPage clickImportKubernetesClusterButton(){
        click("Import Kubernetes Cluster Button",importKubernetesClusterButton);
        return this;
    }
/*
    public ClustersPage clickAcceptSelfSignedCertificate() {

        findElement("//div[@class='icheckbox_square-blue']",acceptSelfSignedCertificate);
     //   scrollIntoView("Accept Self Signed Certificate",acceptSelfSignedCertificate);

        acceptText.scrollIntoView(false);
        acceptSelfSignedCertificate.click();
      //  click("Accept Self Signed Certificate",acceptSelfSignedCertificate);
        return this;
    }
    */

    public ClustersPage clickInstallationButton() {
        click("Installation button",installationButton);
        return this;
    }

    public ClustersPage clickInstallNewKubernetesClusterOption(){
        click("Install New Kubernetes Cluster Option",installNewKubernetesClusterOption);
       return this;
    }

    public ClustersPage setInputNameForInstallAndManageCluster(String clusterName){
        type("Name Input Field",inputNameForManagedCluster,clusterName);
        return this;
    }

    public ClustersPage selectHostGroupFromDropdown(String hostGroupOption){
        selectOptionByText("Host Groups Dropdown",hostGroupDropdown,hostGroupOption);
        return this;
    }

    public ClustersPage selectClusterPolicyFromDropdown(String clusterPolicy){
        selectOptionByText("Cluster Policy Dropdown",clusterPolicyDropdown,clusterPolicy);
        return this;
    }

    public ClustersPage clickCreateClusterAndStartInstallationButton(){
        click("Create Cluster And Start Installation Button",createClusterAndStartInstallation);
        createClusterAndStartInstallation.waitUntil(disappear,20000);
        return this;
    }

    public ClustersPage waitForRunningPreInstallChecksLabel(){
        waitFor("Running Pre Install Checks Label",runningPreInstallChecksLabel,60);
        return this;
    }

    public ClustersPage waitForPreparingInstallLabel(){
        waitFor("Preparing Install Label",preparingInstallLabel,60);
        return this;
    }

    public ClustersPage waitForDeployingClusterLabel(){
        waitFor("Deploying Cluster Label",deployingClusterLabel,60);
        return this;
    }

    public ClustersPage waitForWaitingForControllerConnectLabel(){
        waitFor("Controller Connect label",controllerConnectLabel,350);
        return this;
    }

    public ClustersPage waitForDeployingNirmataControllerLabel(){
        waitFor("Deploying Nirmata Controller Label",deployingNirmataControllerLabel,1000);
        return this;
    }

    public ClustersPage waitForDeployingControlPlaneLabel(){
        waitFor("Deploying Control Plane Label",deployingControlPlaneLabel,1200);
        return this;
    }

    public ClustersPage waitForDeployingWorkerNodeLabel(){
        waitFor("Deploying Worker Node Label",deployingWorkerNodeLabel,1000);
        return this;
    }

    public ClustersPage waitForLoadingAWSAuthConfigMapLabel(){
        waitFor("Loading AWS Auth Config Map Label",loadingAWSAuthConfigMapLabel);
        return this;
    }

    public ClustersPage waitForDeployingMetricsServerLabel(){
        waitFor("Deploying Metrics Server Label",deployingMetricsServerLabel);
        return this;
    }

    public InsideClusterPage clickViewDetailsOfMyClusterButton(){
        waitFor("View Details Of My Cluster Button",viewDetailsOfMyClusterButton,700);
        click("View Details Of My Cluster Button",viewDetailsOfMyClusterButton);
        return new InsideClusterPage(driver);
    }

    public ClustersPage waitForReadyClusterStatus(String clusterName){
        if(toggleCardView.exists()){
            readyClusterState=$x("//*[text()='"+clusterName+"']/../../..//*[contains(text(),'Ready')]");
        }else if(toggleTableView.exists()){
            readyClusterState=$x("//*[contains(text(),'Ready')]/../..//*[text()='"+clusterName+"']");
        }
        waitFor("Ready Cluster State",readyClusterState);
//        readyCLusterState.waitUntil(disappear,60);
        return this;
    }

    public ClustersPage waitForUnknownClusterStatus(String clusterName){
        if(toggleCardView.exists()){
            unknownCLusterState=$x("//*[text()='"+clusterName+"']/../../..//*[contains(text(),'Unknown')]");
        }else if(toggleTableView.exists()){
            unknownCLusterState=$x("//*[contains(text(),'Unknown')]/../..//*[text()='"+clusterName+"']");
        }
        waitFor("Unknown Cluster State",unknownCLusterState,500);
        unknownCLusterState.waitUntil(disappear,1000);
        return this;
    }

    public ClustersPage waitForShuttingDownClusterStatus(String clusterName){
        if(toggleCardView.exists()){
            shuttingDownCLusterState=$x("//*[text()='"+clusterName+"']/../../..//*[contains(text(),'Shutting Down')]");
        }else if(toggleTableView.exists()){
            shuttingDownCLusterState=$x("//*[contains(text(),'Shutting Down')]/../..//*[text()='"+clusterName+"']");
        }
        waitFor("Shutting Down Cluster State",shuttingDownCLusterState,350);
        return this;
    }

    public ClustersPage waitForDeletedClusterStatus(String clusterName){
        if(toggleCardView.exists()){
            deletedCLusterState=$x("//*[text()='"+clusterName+"']/../../..//*[contains(text(),'Deleted')]");
        }else if(toggleTableView.exists()){
            deletedCLusterState=$x("//*[contains(text(),'Deleted')]/../..//*[text()='"+clusterName+"']");
        }
        waitFor("Deleted Cluster State",deletedCLusterState,350);
        refresh();
        deletedCLusterState.should(disappear);
        return this;
    }

    public ClustersPage clickCreateGKEClusterOption(){
        click("Create GKE Cluster Option",createGKEClusterOption);
        return this;
    }

    public ClustersPage setInputNameForGKECluster(String clusterName){
        type("Name",inputNameForGKECluster,clusterName);
        return this;
    }

    public ClustersPage selectGKECloudProviderFromDropdown(String cloudProviderValue){
        select2OptionByText("Cloud Provider Dropdown",gkeCloudProviderDropdown,cloudProviderValue);
        return this;
    }

    public ClustersPage selectGKERegionFromDropdown(String regionValue){
        fetchingMessage.shouldNotBe(visible);
        selectOptionByValue("Region Dropdown",gkeRegionDropdown,regionValue);
        return this;
    }

    public ClustersPage selectGKEKubernetesVersionFromDropdown(String kubernetesVersionValue){
        fetchingMessage.shouldNotBe(visible);
        selectOptionByValue("Kubernetes version Dropdown",gkeKubernetesVersionDropdown,kubernetesVersionValue);
        return this;
    }

    public ClustersPage setGKEDiskSpace(String diskSpaceGB){
        type("Disk Space",gkeDiskSizeInputField,diskSpaceGB);
        return this;
    }

    public ClustersPage clickGKENextButton(){
        click("Next Button",gkeNextButton);
        return this;
    }

    public ClustersPage selectGKEMachineTypeFromDropdown(String machineTypeValue){
        selectOptionByValue("Machine Type dropdown",gkeMachineTypeDropdown,machineTypeValue);
        return this;
    }

    public ClustersPage setGKENodeCount(String nodeCountNr){
       type("Node count",inputNameForGKENodeCount,nodeCountNr);
        return this;
    }

    public ClustersPage clickCreateClusterButton(){
        click("Create Cluster Button",createClusterButton);
        return this;
    }

    public ClustersPage clickCreateEKSClusterOption(){
        click("Create EKS Cluster Option",createEKSClusterOption);
        return this;
    }

    public ClustersPage setInputNameForEKSCluster(String clusterName){
        type("Name Input Field",inputNameForEKSCluster,clusterName);
        return this;
    }

    public ClustersPage selectEKSCloudProviderFromDropdown(String cloudProviderValue){
        select2OptionByText("Cloud Provider Dropdown",eksCloudProviderDropdown,cloudProviderValue);
        return this;
    }

    public ClustersPage selectEKSRegionFromDropdown(String regionValue){
        selectOptionByValue("Region Dropdown",eksRegionDropdown,regionValue);
        return this;
    }

    public ClustersPage selectEKSKubernetesVersionFromDropdown(String kubernetesVersionValue){
        selectOptionByValue("Kubernetes Version Dropdown",eksKubernetesVersionDropdown,kubernetesVersionValue);
        return this;
    }

    public ClustersPage selectEKSVpcIdFromDropdown(String vpcIdValue){
        fetchingMessage.shouldNotBe(visible);
        selectOptionByText("VPC ID Dropdown",eksVpcIdDropdown,vpcIdValue);
        return this;
    }

    public ClustersPage scrollDownToClusterRole(){
        eksClusterRoleArnDropdown.scrollIntoView(true);
        return this;

    }

    public ClustersPage selectEKSNetworksFromDropdown(String networksValue){
        fetchingMessage.shouldNotBe(visible);
        selectOptionByValue("Network Dropdown",eksNetworksDropdown,networksValue);
        return this;
    }

    public ClustersPage selectEKSSecurityGroupFromDropdown(String securityGroupValue){
        fetchingMessage.shouldNotBe(visible);
        selectOptionByValue("Security Group Dropdown",eksSecurityGroupDropdown,securityGroupValue);
        return this;
    }

    public ClustersPage checkEKSPrivateEndpointAccessCheckbox(){
        click("Private Endpoints Access Checkbox",eksPrivateEndpointAccessCheckbox);
        return this;
    }

    public ClustersPage selectEKSClusterRoleArnFromDropdown(String clusterRoleArnValue){
        selectOptionByValue("Cluster Role ARN Dropdown",eksClusterRoleArnDropdown,clusterRoleArnValue);
        return this;
    }

    public ClustersPage clickEKSNextButton(){
        click("Next Button",eksNextButton);
        return this;
    }

    public ClustersPage scrollUpToEnableAutoScaling(){
        createClusterButton.shouldBe(visible);
        eksEnableAutoScalingCheckbox.scrollIntoView(true);
        return this;
    }

    public ClustersPage checkEKSEnableAutoScalingCheckbox(){
        click("Enable Auto Scaling Checkbox",eksEnableAutoScalingCheckbox);
        return this;
    }

    public ClustersPage selectEKSNodeSecurityGroupFromDropdown(String nodeSecurityGroupValue){
        selectOptionByValue("Node Security Group Dropdown",eksNodeSecurityGroupDropdown,nodeSecurityGroupValue);
        return this;
    }

    public ClustersPage selectEKSInstanceTypeFromDropdown(String instanceTypeValue){
        selectOptionByValue("Instance Type Dropdown",eksInstanceTypeDropdown,instanceTypeValue);
        return this;
    }

    public ClustersPage setEKSImageId(String imageId){
        type("Image ID Input Field ",eksImageIdInputField,imageId);
        return this;
    }

    public ClustersPage setEKSInputAutoScalingGroupDesiredCapacity(String desiredCapacity){
        type("Auto Scaling Group Desire Capacity",eksInputAutoScalingGroupDesiredCapacity,desiredCapacity);
        return this;
    }

    public ClustersPage setEKSInputAutoScalingGroupMinSize(String minSize){
       type("Auto Scaling Group Min Size",eksInputAutoScalingGroupMinSize,minSize);
        return this;
    }

    public ClustersPage scrollDownToDiskSize(){
        eksInputDiskSize.scrollTo();
        return this;
    }

    public ClustersPage setEKSInputAutoScalingGroupMaxSize(String maxSize){
        type("Auto Scaling Group Max Size",eksInputAutoScalingGroupMaxSize,maxSize);
        return this;
    }

    public ClustersPage selectEKSSshKeyFromDropdown(String sshKey){
        selectOptionByText("SSH Key Dropdown",eksSshKeyDropdown,sshKey);
        return this;
    }

    public ClustersPage setEKSDiskSize(String diskSize){
        type("Disk Size Input Field",eksInputDiskSize,diskSize);
        return this;
    }


    public ClustersPage scrollToAKSClusterOption(){
        setupButton.shouldBe(visible);
        createAKSClusterOption.scrollIntoView(true);
        return this;
    }

    public ClustersPage clickCreateAKSClusterOption(){
        click("Create AKS Cluster Option",createAKSClusterOption);
        return this;
    }

    public ClustersPage setInputNameForAKSCluster(String clusterName){
        type("Name Input Field",inputNameForAKSCluster,clusterName);
        return this;
    }

    public ClustersPage selectAKSCloudProviderFromDropdown(String cloudProviderValue){
        select2OptionByText("Cloud Provider Dropdown",aksCloudProviderDropdown,cloudProviderValue);
        return this;
    }

    public ClustersPage waitForFetchingMessageToDisappear(){
       waitFor("Fetching Message",fetchingMessage);
       fetchingMessage.waitUntil(disappear,60000);
        return this;
    }

    public ClustersPage selectAKSRegionFromDropdown(String regionValue){
        selectOptionByValue("Region Dropdown",aksRegionDropdown,regionValue);
        return this;
    }

    public ClustersPage selectAKSKubernetesVersionFromDropdown(String kubernetesVersionValue) {
        selectOptionByValue("Kubernetes Version Dropdown",aksKubernetesVersion,kubernetesVersionValue);
        return this;
    }

    public ClustersPage selectAKSResourceGroupFromDropdown(String resourceGroupValue){
        selectOptionByValue("Resource Group Dropdown",aksResourceGroupDropdown,resourceGroupValue);
        return this;
    }

    public ClustersPage clickAKSNextButton(){
        click("Next Button",aksNextButton);
        return this;
    }

    public ClustersPage selectAKSNetworkConfigurationFromDropdown(String networkConfigurationValue){
        selectOptionByValue("Network Configuration Dropdown",aksNetworkConfigurationDropdown,networkConfigurationValue);
        return this;
    }

    public ClustersPage selectAKSClusterSubnetFromDropdown(String clusterSubnet){
        selectOptionByText("Cluster Subnet Dropdown",aksClusterSubnetDropdown,clusterSubnet);
        return this;
    }

    public ClustersPage setAKSKubernetesServiceAddressRange(String serviceAddressRange){
        type("Kubernetes Service Address range Input Field",aksKubernetesServiceAddressRangeInputField,serviceAddressRange);
        return this;
    }

    public ClustersPage setAKSKubernetesDNSService(String kubernetesDNSServiceIp){
        type("Kubernetes DNS Service Input Field",aksKubernetesDNSServiceIpInputField,kubernetesDNSServiceIp);
        return this;
    }

    public ClustersPage setAKSDockerBridgeAddress(String dockerBridgeAddress){
        type("Docker Bridge Address",aksDockerBridgeAddressInputField,dockerBridgeAddress);
        return this;
    }

    public ClustersPage setAKSPodCidr(String podCidr){
        type("Pod Cidr Input Field",aksPodCidrInputField,podCidr);
        return this;
    }

    public ClustersPage checkAKSHTTPSApplicationRoutingCheckbox(){
        click("HTTPS Application Routing Checkbox",aksHTTPSApplicationRoutingCheckbox);
        return this;
    }

    public ClustersPage clickAKSContainerMonitoringCheckbox(){
        click("Container Monitoring Checkbox",aksContainerMonitoringCheckbox);
        return this;
    }

    public ClustersPage selectAKSVMSetTypeFromDropdown(String vmSetTypeValue){
        selectOptionByValue("VM Set Type Dropdown",aksVMSetTypeDropdown,vmSetTypeValue);
        return this;
    }

    public ClustersPage selectAKSNodeTypeFromDropdown(String nodeTypeValue){
        selectOptionByValue("Node Type Dropdown",aksNodeTypeDropdown,nodeTypeValue);
        return this;
    }

    public ClustersPage setAKSDiskSize(String diskSizeGB){
        type("Disk Space Input Field",aksDiskSizeInput,diskSizeGB);
        return this;
    }

    public ClustersPage setAKSNodeCount(String nodeCount){
     type("Node Count",aksNodeCountInput,nodeCount);
     return this;
    }

    public ClustersPage isDeletedClusterDisplayed(String clusterName){
        refresh();
        assertFalse(isClusterDisplayed(clusterName),"Cluster Was Not Deleted");
        return this;
    }

    public ClustersPage isCreatedClusterDisplayed(String clusterName){
        assertTrue(isClusterDisplayed(clusterName),"Cluster Was Not Created");
        return this;
    }


    private boolean isClusterDisplayed(String clusterName) {
        addClusterButton.shouldBe(visible);
        boolean found = false;

        if (toggleCardView.exists()) {
            cluster = $x("//div[contains(@class,'cluster-name')]//*[text()='" + clusterName + "']");
        } else if (toggleTableView.exists()) {
            cluster = $x("//div[contains(@class,'card-content card-select')]//*[text()='" + clusterName + "']");
        }

        if (cluster != null && cluster.exists()) {
            found = true;
        } else if (nextButton.exists()) {
            nextButton.scrollIntoView(true);
            if (nextButtonEnabled.exists()) {
                do {
                    click("Next Button", nextButton);
                    modelContentPanelTitle.scrollIntoView(true);
                    if (cluster.exists()) {
                        found = true;
                        break;
                    }
                } while (nextButtonEnabled.exists());
            }
        }
        return found;
    }

    public InsideClusterPage clickOnClusterWithName(String clusterName)  {
        addClusterButton.shouldBe(visible);

        if(toggleCardView.exists()){
            cluster=$x("//div[contains(@class,'cluster-name')]//*[text()='"+clusterName+"']");
        }else if(toggleTableView.exists()){
            cluster=$x("//div[contains(@class,'card-content card-select')]//*[text()='"+clusterName+"']");
        }

        if (cluster!=null && cluster.exists()){
                click("Cluster "+clusterName,cluster);
        }else if(nextButton.exists()){
            nextButton.scrollIntoView(true);
            if(nextButtonEnabled.exists()) {
                do {
                    click("Next Button",nextButton);
                    modelContentPanelTitle.scrollIntoView(true);
                    if (cluster.exists()) {
                        click("Cluster " + clusterName, cluster);
                        break;
                    }
                }
                while (nextButtonEnabled.exists());
            }
        }
        return new InsideClusterPage(driver);
    }
}
