Feature: E2E Flow 


  @Customer_E2E_Flow_WWWW
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
    Given I as a BRM_admin logged in to Staff portal
   # And I configure the cloud connect offer in Quote configuration provider as "<Cloud_Provider>" and DC as "<Data_Center>"
   

  Examples: 
      | Sceanrio ID           | username               | Product_Offering                                       | Product_Level_1 | Network_Name                | Postal_code_Config | Contract_duration |
      | UAT_E2E_MetroE_TC1.9  | jetti.dinesh@mailnesia.com | Standard MetroE ATA Fixed Rate                         | SG Connectivity | Network_ATA_Fixed           |             139951 | 24 Months         |
  