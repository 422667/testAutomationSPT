@IPVPN_CS_Portal_Subscription_flow_Cloud_Connect_VAS
Feature: 0.1 Customer - New Subscription Flow

  @Customer_E2E_Flow_IPVPN_Cloud_Connect
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for IPVPN Product Offerings "<Product_Offering>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,postal_code as "<Postal_code_Config>" and bandwidth details for more than 1G CSportal
    And I configure the cloud connect offer in Quote configuration provider as "<Cloud_Provider>" and DC as "<Data_Center>"
    #And I click on the Availbility Check button at the Product configure page
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " Site Survey "," Wiring "," Installation " and Cloud Connect RFS Date
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "Existing Billing Account" along with billing contact details
    Then I should see the order submitted successfully
    When I click on the View Order button at the Thank you page
    Then I should see newly created order at the My order page
    Given I as a Sales admin logged in to Staff portal
    And I clicked order search under sales menu
    And I search for customer order submitted from CS portal
    And I verify the details at the Track and Monitor page
    #And I verify the reserved appointments at the DWFM
    #Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters

   Given I as a BRM_admin logged in to Staff portal
    And I verify the billing details at the BRM
    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio_ID          | username                   | Product_Offering                                    | Product_Level_1 | Network_Name                           | Topology      | Postal_code_Config | Contract_duration | Cloud_Provider | Data_Center              |
   | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Hub and Spoke |             139952 | 24 Months         | Alibaba Cloud  | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Hub and Spoke |             139951 | 24 Months         | Azure          | Global Switch (Tai Seng) |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Hub and Spoke |             139951 | 24 Months         | AWS            | Equinix SG2              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate with Auto Backup Port     | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Hub and Spoke |             139951 | 24 Months         | Google Cloud   | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Any to Any    |             139951 | 24 Months         | AWS            | Equinix SG2              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             139951 | 24 Months         | Google Cloud   | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Any to Any    |             139951 | 24 Months         | Azure          | Global Switch (Tai Seng) |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate with Auto Backup Port     | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             139951 | 24 Months         | Google Cloud   | Equinix SG1              |

  @Customer_E2E_Flow_IPVPN_BGP_VAS_Cos_Upgrade_Cloud_Connect
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for IPVPN Product Offerings "<Product_Offering>" and "<VAS>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,postal_code as "<Postal_code_Config>" ,bandwidth details and VAS as "<VAS>" for CSportal
    And I configure the cloud connect offer in Quote configuration provider as "<Cloud_Provider>" and DC as "<Data_Center>"
    #And I click on the Availbility Check button at the Product configure page
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " Site Survey "," Wiring "," Installation " and Cloud Connect RFS Date
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "Existing Billing Account" along with billing contact details
    Then I should see the order submitted successfully
    When I click on the View Order button at the Thank you page
    Then I should see newly created order at the My order page
    Given I as a Sales admin logged in to Staff portal
    And I clicked order search under sales menu
    And I search for customer order submitted from CS portal
    And I verify the details at the Track and Monitor page
    #And I verify the reserved appointments at the DWFM
    #Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters

    Given I as a BRM_admin logged in to Staff portal
    And I verify the billing details at the BRM
    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio_ID          | username                   | Product_Offering                                    | Product_Level_1 | Network_Name                           | Topology      | Postal_code_Config | VAS         | Contract_duration | Cloud_Provider | Data_Center              |
     # | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Hub and Spoke |             139951 | Cos Upgrade | 24 Months         | Alibaba Cloud  | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Hub and Spoke |             139951 | Cos Upgrade | 24 Months         | Azure          | Global Switch (Tai Seng) |
      #| UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Hub and Spoke |             139951 | Cos Upgrade | 24 Months         | AWS            | Equinix SG2              |
      #| UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate with Auto Backup Port     | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Hub and Spoke |             139951 | Cos Upgrade | 24 Months         | Google Cloud   | Equinix SG1              |
      #| UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Any to Any    |             139951 | Cos Upgrade | 24 Months         | AWS            | Equinix SG2              |
      #| UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             139951 | Cos Upgrade | 24 Months         | Azure          | Global Switch (Tai Seng) |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Any to Any    |             139951 | Cos Upgrade | 24 Months         | Google Cloud   | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate with Auto Backup Port     | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             139951 | Cos Upgrade | 24 Months         | AWS            | Equinix SG2              |

  @Customer_E2E_Flow_IPVPN_VAS_Flexi_Cos_Cloud_Connect
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for IPVPN Product Offerings "<Product_Offering>" and "<VAS>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,postal_code as "<Postal_code_Config>" ,bandwidth details and VAS as "<VAS>" for CSportal
    #And I click on the Availbility Check button at the Product configure page
    And I configure the cloud connect offer in Quote configuration provider as "<Cloud_Provider>" and DC as "<Data_Center>"
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " Site Survey "," Wiring "," Installation " and Cloud Connect RFS Date
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "Existing Billing Account" along with billing contact details
    Then I should see the order submitted successfully
    When I click on the View Order button at the Thank you page
    Then I should see newly created order at the My order page
    Given I as a Sales admin logged in to Staff portal
    And I clicked order search under sales menu
    And I search for customer order submitted from CS portal
    And I verify the details at the Track and Monitor page
    #And I verify the reserved appointments at the DWFM
    #Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters
   Given I as a BRM_admin logged in to Staff portal
    And I verify the billing details at the BRM
    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio_ID          | username                   | Product_Offering                                    | Product_Level_1 | Network_Name                           | Topology      | Postal_code_Config | VAS       | Contract_duration | Cloud_Provider | Data_Center              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Hub and Spoke |             139951 | Flexi Cos | 24 Months         | Azure          | Global Switch (Tai Seng) |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Hub and Spoke |             139951 | Flexi Cos | 24 Months         | Google Cloud   | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Hub and Spoke |             139951 | Flexi Cos | 24 Months         | Alibaba Cloud  | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate with Auto Backup Port     | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Hub and Spoke |             139951 | Flexi Cos | 24 Months         | AWS            | Equinix SG2              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Any to Any    |             139951 | Flexi Cos | 24 Months         | Azure          | Global Switch (Tai Seng) |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             139951 | Flexi Cos | 24 Months         | AWS            | Equinix SG2              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Any to Any    |             139951 | Flexi Cos | 24 Months         | Google Cloud   | Equinix SG1              |
      | UAT_E2E_IPVPN_TC1.xx | regspweekk37@gmail.com | Standard IPVPN Fixed Rate with Auto Backup Port     | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             139951 | Flexi Cos | 24 Months         | Azure          | Global Switch (Tai Seng) |
