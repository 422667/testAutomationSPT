@MetroE_CS_Portal_Subscription_flow_More_Than_1G
Feature: 0.1 Customer - New Subscription Flow

  @Customer_E2E_Flow_ATA_>_1G
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,postal_code as "<Postal_code_Config>" and bandwidth details more than 1G for CSportal
    #And I click on the Availbility Check button at the Product configure page
   
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
  When I select the appointments for " Site Survey "," Wiring "," Installation "
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "Existing Billing Account" along with billing contact details
    Then I should see the order submitted successfully
    When I click on the View Order button at the Thank you page
    Then I should see newly created order at the My order page
    Given I as a Sales admin logged in to Staff portal
    And I clicked order search under sales menu
    And I search for customer order submitted from CS portal
    And I verify the details at the Track and Monitor page
   # And I verify the reserved appointments at the DWFM
    #Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters
   Given I as a BRM_admin logged in to Staff portal
    And I verify the billing details at the BRM
    Examples: 
      | Sceanrio ID           | username               | Product_Offering                                       | Product_Level_1 | Network_Name                | Postal_code_Config | Contract_duration |
      | UAT_E2E_MetroE_TC1.9  | regspweekk37@gmail.com | Standard MetroE ATA Fixed Rate                         | SG Connectivity | Network_ATA_Fixed           |             139951 | 24 Months         |
      | UAT_E2E_MetroE_TC1.xx | regspweekk37@gmail.com | Standard MetroE ATA Burstable Rate                     | SG Connectivity | Network_ATA_Burst           |             139951 | 24 Months         |
      | UAT_E2E_MetroE_TC1.10 | regspweekk37@gmail.com | Standard MetroE ATA Burstable Rate with Protected Path | SG Connectivity | Network_ATA_Burst_Protected |             139951 | 24 Months         |
      | AT_E2E_MetroE_TC1.xx  | regspweekk37@gmail.com | Standard MetroE ATA Fixed Rate with Protected Path     | SG Connectivity | Network_ATA_Fixed_Protected |             139951 | 24 Months         |

  @Customer_E2E_Flow_PTMP_>_1G
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
     When I key in the product config details Network_Name as "<Network_Name>" ,postal_code as "<Postal_code_Config>" and bandwidth details more than 1G for CSportal
    #And I click on the Availbility Check button at the Product configure page
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " Site Survey "," Wiring "," Installation "
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
   # Then I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters
   Given I as a BRM_admin logged in to Staff portal
    And I verify the billing details at the BRM

    Examples: 
      | Sceanrio ID           | username               | Product_Offering                                        | Product_Level_1 | Network_Name                      | Postal_code_Config | Committed_bandwidth | Burstable_bandwidth | Contract_duration |
     | UAT_E2E_MetroE_TC1.6  | regspweekk37@gmail.com | Standard MetroE PTMP Fixed Rate                              | SG Connectivity | Network_MetroE_PTMP_Fixed     |             139951 |                 700 | NA                  | 12 Months         |
      | UAT_E2E_MetroE_TC1.8  | regspweekk37@gmail.com | Standard MetroE Burstable Rate                          | SG Connectivity | Network_MetroE_PTMP_Burstable |             139951 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.xx | regspweekk37@gmail.com | Standard MetroE PTMP Fixed Rate with Protected Path     | SG Connectivity | Network_PTMP_Fixed_Protected      |             139951 |                 700 | NA                  | 12 Months         |
      | UAT_E2E_MetroE_TC1.11 | regspweekk37@gmail.com | Standard MetroE PTMP Burstable Rate with Protected Path | SG Connectivity | Network_PTMP_Fixed_Burstable      |             139951 |                 700 |                 900 | 12 Months         |

  @Customer_E2E_Flow_PTP_>_1G
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
   Then I should see the "OTP" page
   When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,postal_code_1 as "<postal_code_1>" ,postal_code_2 as "<postal_code_2>" and bandwidth details for more than 1G CSportal
    #And I click on the Availbility Check button at the Product configure page
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
   # And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " Site Survey "," Wiring "," Installation " for site1,site2
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

    Examples: 
      | Sceanrio ID           | username               | Product_Offering                                       | Product_Level_1 | Network_Name | postal_code_1 | postal_code_2 | Committed_bandwidth | Burstable_bandwidth | Contract_duration |
      | UAT_E2E_MetroE_TC1.1  | regspweekk37@gmail.com | Standard MetroE PTP Burstable Rate                     | SG Connectivity | Network_PTP  |        139951 |        139952 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.2  | regspweekk37@gmail.com | Standard MetroE PTP Fixed Rate                         | SG Connectivity | Network_PTP  |        139951 |        139952 |                 700 | NA                  | 12 Months         |
      | UAT_E2E_MetroE_TC1.xx | regspweekk37@gmail.com | Standard MetroE PTP Fixed Rate with Protected Path     | SG Connectivity | Network_PTP  |        139951 |        139952 |                 700 | NA                  | 12 Months         |
      | UAT_E2E_MetroE_TC1.18 | regspweekk37@gmail.com | Standard MetroE PTP Burstable Rate with Protected Path | SG Connectivity | Network_PTP  |        139951 |        139952 |                 700 | NA                  | 12 Months         |

  
