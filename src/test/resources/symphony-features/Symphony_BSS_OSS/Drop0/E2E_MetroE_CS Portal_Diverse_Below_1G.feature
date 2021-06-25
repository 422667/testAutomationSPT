@Subscription_flow_for_Customer_Portal
Feature: 0.1 Customer - New Subscription Flow

  @Customer_E2E_Flow_MetroE_Diverse_less_than_1G
  
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Metro E Product Offerings "<Product_Offering>" through customer portal
    Given I logged in to the customer portal with "<username>"
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
    And I add the Diversepath offering as "<DiversePath_offer>", Protocol as "<Protocol>" for "<Postal_code_2>" for CSPortal for less than 1G
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for " Site Survey "," Wiring "," Installation " for 2 sites
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
      | Sceanrio ID           | username                   | Product_Offering                                        | Product_Level_1 | Network_Name                             | Postal_code_Config | DiversePath_offer                                     | Protocol | Postal_code_2 | Committed_bandwidth | Burstable_bandwidth | Contract_duration |
   		| UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE PTMP Fixed Rate                         | SG Connectivity | Network_MetroE_PTMP_Fixed_Diverse        |             139951 | Standard MetroE PTMP Fixed Rate with Diverse Path     | NA       |        139951 |                 700 | NA                  | 12 Months         |
      | UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE PTMP Burstable Rate with Protected Path | SG Connectivity | Network_PTMP_Burstable_Protected_Diverse |             139951 | Standard MetroE PTMP Burstable Rate with Diverse Path | NA       |        139951 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE PTMP Burstable Rate                     | SG Connectivity | Network_MetroE_PTMP_Burstable_Diverse    |             139951 | Standard MetroE PTMP Burstable Rate with Diverse Path | NA       |        139951 |                 700 | NA                  | 12 Months         |
     	| UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE PTMP Fixed Rate with Protected Path     | SG Connectivity | Network_PTMP_Fixed_Protected_Diverse     |             139951 | Standard MetroE PTMP Fixed Rate with Diverse Path     | NA       |        139951 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE ATA Burstable Rate                      | SG Connectivity | Network_ATA_Fixed_Burstable              |             139951 | Standard MetroE ATA Burstable Rate with Diverse Path  | NA       |        139951 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE ATA Burstable Rate with Protected Path  | SG Connectivity | Network_ATA_Fixed_Burstable              |             139951 | Standard MetroE ATA Burstable Rate with Diverse Path  | NA       |        139951 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE ATA Fixed Rate                          | SG Connectivity | Network_ATA_Fixed_Diverse_Fixed          |             139951 | Standard MetroE ATA Fixed Rate with Diverse Path      | NA       |        139951 |                 700 |                 900 | 12 Months         |
      | UAT_E2E_MetroE_TC1.XX | nanyang_dc@mailnesia.com | Standard MetroE ATA Fixed Rate with Protected Path      | SG Connectivity | Network_ATA_Fixed_Protected_Diverse      |             139951 | Standard MetroE ATA Fixed Rate with Diverse Path      | NA       |        139951 |                 700 |                 900 | 12 Months         |
     