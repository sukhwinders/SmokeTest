package icix.Locators;

import org.openqa.selenium.By;

public class GlobalRepo {
	
	public static By txtGlobalSrc=By.xpath("//input[@placeholder='Search Salesforce']");
	// public static By optionSearchInSalesforce=By.xpath("//input[@placeholder='Search Salesforce']/following-sibling::div/div[@class='listContent']/ul/li/a/span[contains(text(),'in Salesforce')]");
	 public static By optionSearchInSalesforce=By.xpath("//input[@placeholder='Search Salesforce']/following-sibling::div/div[@class='listContent']/ul/li/a/span[1]"); // New Added 22Aug RK

	 public static By lnkShowMore=By.linkText("Show More");
	 public static By divLeftSideMenu=By.id("allItemsList");
	 public static By appLauncherIcon=By.className("slds-icon-waffle");
	 public static By closeAppLauncher=By.xpath("//div[contains(@class,'appLauncherModalHeader')]/parent::h2/following-sibling::button");
	 public static By globalSearchRequestTab=By.xpath("//div[@data-aura-class='forceSearchScopesList']/ul/li/a[contains(text(),'Requests')]");
	 public static By globalSearchWorkflowsTab=By.xpath(".//*[@id='allItemsList']/ul/li/a[contains(text(),'Workflows')]");
	 public static By globalSearchTradingPartnerGroups = By.xpath(".//*[@id='allItemsList']/ul/li/a[contains(text(),'Trading Partner Groups')]");
	// public static By globalSearchResult=By.xpath("//div[@class='active oneContent']/div/div/div/div/div/div[contains(@class,'searchResultsGridHeader')]/div/div/div[1]/p");
	  public static By globalSearchResult=By.xpath("html/body/div[5]/div[1]/section/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div/div[1]/p"); // New Added

	//public static By globalSearchResultNumber=By.xpath("//div[@class='active oneContent']/div/div/div/div/div/div[contains(@class,'searchResultsGridHeader')]/div/div[contains(@class,'searchResultsSummary')]");
	public static By 	 globalSearchResultNumber=By.xpath("html/body/div[5]/div[1]/section/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div[@class='searchResultsSummary slds-text-body--small slds-text-color--weak']");	   // New Added25Aug
	public static By 	 globalSearchResultNumber1=By.xpath("//div[contains(text(),'No results for')]");	   // New Added25Aug

	 public static By imgWaitingLoader = By.xpath("//img[@class='waitingImage']");

	//For selectDate() method in Common.java
	public static By tblDate = By.xpath("//table[@class='datepicker__month']");
	public static By tblNextMonth = By.xpath("//button[@title='Next Month']");
	public static By tblTd = By.tagName("td");
	public static By frame=By.tagName("iframe");

}







