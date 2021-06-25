@Subscription_flow_for_Customer_Portal
Feature: 0.1 Customer - New Subscription Flow

  @Customer_Auto_E2E_Flow_Multiline_IPVPN
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,postal_code as "<Postal_code_Config>" and bandwidth details for CSportal
    #And I click on the Availbility Check button at the Product configure page
    
    #When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,postal_code as "<Postal_code_Config>" and bandwidth details for more than 1G CSportal
    #And I click on the Availbility Check button at the Product configure page
     And I add the "<ADD_NEW_Location>" for "<Postal_code_2>" for CSPortal
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
     Then I should see the system recommendation to GPON offering
    When I reconfigure the quotaion for recommended GPON offering including "<ADD_NEW_Location>"
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
   
  
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    # And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " NLT Wiring "," Installation " for 2 GPON sites
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "Existing Billing Account" along with billing contact details for "two" site order
    Then I should see the order submitted successfully
    When I click on the View Order button at the Thank you page
    Then I should see newly created order at the My order page
    Given I as a Sales admin logged in to Staff portal
    And I clicked order search under sales menu
    And I search for customer order submitted from CS portal
    And I verify the details at the Track and Monitor page
    # And I verify the reserved appointments at the DWFM
    #  Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters

    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio ID          | username               | Product_Offering                                    | Product_Level_1 | Network_Name                           | Topology      | Postal_code_Config | ADD_NEW_Location                                | Postal_code_2 | Contract_duration |
      | UAT_E2E_IPVPN_TC1.xx | nanyang_dc@mailnesia.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Multi_1                                | Hub and Spoke |             542116 | Standard IPVPN Burstable Rate                   |        542117 | 24 Months         |
      | UAT_E2E_IPVPN_TC1.xx | nanyang_dc@mailnesia.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Multi_2                                | Hub and Spoke |             542116 | Standard IPVPN Fixed Rate with Auto Backup Port |        542117 | 24 Months         |
      | UAT_E2E_IPVPN_TC1.xx | nanyang_dc@mailnesia.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Any to Any    |             542116 | Standard IPVPN Fixed Rate                       |        542117 | 24 Months         |
      | UAT_E2E_IPVPN_TC1.xx | nanyang_dc@mailnesia.com | Standard IPVPN Fixed Rate                           | SG Connectivity | Network_IPVPN_Fixed                    | Any to Any    |             542116 | Standard IPVPN Burstable Rate                   |        542117 | 24 Months         |
      | UAT_E2E_IPVPN_TC1.xx | nanyang_dc@mailnesia.com | Standard IPVPN Burstable Rate with Auto Backup Port | SG Connectivity | Network_IPVPN_Burstable_AutoBackUpPort | Any to Any    |             542116 | Standard IPVPN Fixed Rate with Auto Backup Port |        542117 | 24 Months         |
      | UAT_E2E_IPVPN_TC1.xx | nanyang_dc@mailnesia.com | Standard IPVPN Burstable Rate                       | SG Connectivity | Network_IPVPN_Burstable                | Hub and Spoke |             542116 | Standard IPVPN Fixed Rate                       |        542117 | 24 Months         |

  @Customer_E2E_Flow_Multiline_MetroE
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
   When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,postal_code as "<Postal_code_Config>" and bandwidth details for CSportal
    #And I click on the Availbility Check button at the Product configure page
    And I add the "<ADD_NEW_Location>" for "<Postal_code_2>" for CSPortal
     When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    Then I should see the system recommendation to GPON offering
    When I reconfigure the quotaion for recommended GPON offering including "<ADD_NEW_Location>"
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
   
  
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    # And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " NLT Wiring "," Installation " for 2 GPON sites
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "Existing Billing Account" along with billing contact details for "two" site order
    Then I should see the order submitted successfully
    When I click on the View Order button at the Thank you page
    Then I should see newly created order at the My order page
    Given I as a Sales admin logged in to Staff portal
    And I clicked order search under sales menu
    And I search for customer order submitted from CS portal
    And I verify the details at the Track and Monitor page
    #And I verify the reserved appointments at the DWFM
    # Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters
    And I verify the billing details at the BRM

    Examples: 
      | Sceanrio ID           | username               | Product_Offering                                        | Product_Level_1 | Network_Name                 | Postal_code_Config | ADD_NEW_Location                                    | Postal_code_2 | Committed_bandwidth | Burstable_bandwidth | Contract_duration |
      | UAT_E2E_MetroE_TC1.6  | nanyang_dc@mailnesia.com | Standard MetroE PTMP Fixed Rate                         | SG Connectivity | Network_MetroE_PTMP_Fixed_Burstable    |             542116 | Standard MetroE PTMP Burstable Rate                 |        542117 |                 700 | NA                  | 12 Months         |
      | UAT_E2E_MetroE_TC1.11 | nanyang_dc@mailnesia.com | Standard MetroE PTMP Burstable Rate with Protected Path | SG Connectivity | Network_PTMP_Fixed_Burstable |             542116 | Standard MetroE PTMP Fixed Rate with Protected Path |        542117 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.11 | nanyang_dc@mailnesia.com | Standard MetroE ATA Burstable Rate                      | SG Connectivity | Network_ATA_Fixed_Burstable  |             542116 | Standard MetroE ATA Fixed Rate                      |        542117 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.11 | nanyang_dc@mailnesia.com | Standard MetroE ATA Burstable Rate with Protected Path  | SG Connectivity | Network_ATA_Fixed_Burstable |             542116 | Standard MetroE ATA Fixed Rate with Protected Path  |        542117 |                 700 |                 900 | 12 Months         |
