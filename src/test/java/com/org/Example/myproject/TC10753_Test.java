package com.org.Example.myproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

import ModuleLocatorRepository.FormBuilderRepo;
import ModuleLocatorRepository.RequestRepo;
import ModuleLocatorRepository.TPGroupCompRepo;

public class TC10753_Test {
 FormBuilderRepo ObjForm=new FormBuilderRepo();
 Data_loading guitils = new Data_loading(); 
 String ReqUserName = guitils.getUserName("RequestorUsername");
 String ReqPassword = guitils.getPassword("RequestorPassword");  

 Date date = new Date(System.currentTimeMillis());
 String tpgName = "reqGetsClosedAfterRemovingReq" +date; // Trading partner Group Name
 //String tpgTags[] = {"Organic"};  // Tag Names
 // String tpgTags[] = { "High Risk"}; // Tag Names  for KLRespStg@icix.com
 String tpgTags[] = {"Organic"};  // Tag Names for q@pkgo1rk@icix.com
 String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
 String tpgType[] = {}; // tpg Relationship types

 String requestType[] = {"All"}; 
 //String btnClick = "btnSend"; // save or send reqs, supported values are btnSave and btnSend
 String tabName = "Workflow"; // on which object you want to search 
 boolean removeReqs = true; // remove requirements or not?
 String wfStatus = "Cancelled"; // Workflow status, supported values are Closed, Open.
 String ReqStatus = "Closed"; // Request Status , Supported values are New,Approved, Rejected, Cancelled etc..
 String saveOrSend  = "btnSend";
 //String searchKeyWord = "804-ab"+date;// name of the record
 @BeforeClass
 public void beforeClass() {
  guitils.InitilizeBrowser(); 
 }

 @AfterClass
 public void afterClass() { 
  /*guitils.logoutFromPortal();
  guitils.driver.close();*/
 }

 @Test
 public void  VerifyRequestClosedAfterRemovingRequirement() throws Exception {
  guitils.loginToSalesForce(ReqUserName, ReqPassword);  
// Create a form
   guitils.createNewForm();
   String formNames[] = {ObjForm.container_Name+guitils.d};
   //String formNames[] = {"804-ab"};
   String searchKeyWord = ObjForm.container_Name+guitils.d;// name of the record

  

  int assertReqsSize = formNames.length; // No of Requirements for Assert. i.e No of forms 
  
  // Create a Trading partner Group  
  guitils.createTPG(tpgName, tpgTags, tpgStatus, tpgType);
  guitils.driver.manage().deleteAllCookies();
  Thread.sleep(10000);
  // Set the Requirements then send   
  guitils.SetRequirement(requestType,formNames, saveOrSend);
  // Remove Requirement then Verify status
  guitils.assertAndDeleteReqs(assertReqsSize,removeReqs);
  guitils.driver.manage().deleteAllCookies();
  guitils.driver.navigate().refresh();
  guitils.searchAnything(tabName,searchKeyWord);
 
  
  //guitils.assertWFnReqStatus("",ReqStatus);
  
  /*Workflow status still "Open"*/
  //guitils.assertReqWFnStatus(ReqStatus, wfStatus);


 }
}