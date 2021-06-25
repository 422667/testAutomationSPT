@Subscription_flow_for_IPVPN_Staff_Portal
Feature: 0.1 Customer/Staff portal - New Subscription Flow for IPVPN Staff Portal

  @Staff_E2E_Flow_IPVPN
  Scenario Outline: Sceanrio "<Scenario ID>" Verify the New Subscription flow for "<Product_Offering>" through staff portal
    # Given I logged in to the staff portal with "<username>"
    Given I as a Sales_admin logged in to Staff portal
    When I clicked quote creation under sales menu
    And I created quote using Quote_Type as "<Quote_Type>" ,Quote_Description as "<Description>" ,Quote_Order_Type as "<Quote_Order_Type>" ,Quote_Currency as "<Quote_Currency>" ,Customer_Name as "<Customer_Name>" ,Postal_Code as "<Postal_code>"
    And I choose the Product offering as "<Product_Offering>" for the product "<Product_Level_2>" under product catalogue "<Product_Level_1>"
    Then I should see the product config page for product offering "<Product_Offering>"
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,postal_code as "<Postal_code_Config>" ,contract_duration as "<Contract_duration>" and bandwidth details for more than 1G staffportal
    And I add the Diversepath offering as "<DiversePath_offer>", Protocol as "<Protocol>" for "<Postal_code_2>" for staffPortal
    And I click on generate upon selecting the template as SPTel Quotaion document
    #Then I should see "Document Generation Successful" message is displayed
    When I click on the Finalize Quotation
    And I should see the Quotation "submitted for approval"
    # When I logged in to the staff portal with Approver as "<Approver>"
    # And I clicked quote search under sales menu
    # And I search for Quotation submitted for approval
    Then I should see as Quotation submitted for approval
    When I approve the Quotation submitted for approval
    # When I as a requestor logged in to Staff portal with "<username>"
    # And I clicked quote search under sales menu
    # And I search for approved Quotation
    When I submit the Quotation for acceptance
    And I proceed Quotation for accept_onbehalf
    And I accept the Quotation by uploading acceptance document
    # When I as a Sales_admin logged in to Staff portal
    #And I clicked quote search under sales menu
    #And I search for accepted Quotation
    When I navigate to order confirm page by verifying the requestor acceptance
    When I select the "Existing Billing Account" along with billing contact details for two sites for staff portal
    When I select the appointments for "Site Survey","Wiring","Installation" for two sites for staff portal
    Then I should see the order submitted successfully via staff Portal
    And I verify the details at the Track and Monitor page
    #And I verify the reserved appointments at the DWFM
    #When I create manaul work order for the selected appointments
    And I complete the CRM order by keying the required paramaters
    Given I as a BRM_admin logged in to Staff portal
    And I verify the billing details at the BRM

    Examples: 
      | Scenario ID | username             | Approver         | Quote_Type    | Description      | Quote_Order_Type | Quote_Currency | Customer_Name | Postal_code | Product_Level_1 | Product_Level_2 | Product_Offering                                    | Network_Name                              | Topology   | Postal_code_Config | DiversePath_offer                 | Protocol | Postal_code_2 | Contract_duration |
      |          01 | SPT\\maricar.ocampo2 | SPT\\jill.deono2 | CustomerOrder | QuoteDescription | Acquire Order    | SGD            | Aleph         |      139951 | SG Connectivity | IPVPN           | Standard IPVPN Burstable Rate                       | Network_IPVPN_Burtsable_Diverse_Burstable | Any to Any |             139951 | Diverse Path IPVPN Burstable Rate | Static   |        139951 | 24 Months         |
     # |          02 | SPT\\maricar.ocampo2 | SPT\\jill.deono2 | CustomerOrder | QuoteDescription | Acquire Order    | SGD            | Aleph         |      139951 | SG Connectivity | IPVPN           | Standard IPVPN Fixed Rate                           | Network_IPVPN_Fixed_Diverse_Fixed         | Any to Any |             139951 | Diverse Path IPVPN Fixed Rate     | Static   |        139951 | 24 Months         |
     # |          01 | SPT\\maricar.ocampo2 | SPT\\jill.deono2 | CustomerOrder | QuoteDescription | Acquire Order    | SGD            | Aleph         |      139951 | SG Connectivity | IPVPN           | Standard IPVPN Burstable Rate with Auto Backup Port | Network_IPVPN_Burtsable_Protected_Diverse_Burstable | Any to Any |             139951 | Diverse Path IPVPN Burstable Rate | Static   |        139951 | 24 Months         |
      #|          02 | SPT\\maricar.ocampo2 | SPT\\jill.deono2 | CustomerOrder | QuoteDescription | Acquire Order    | SGD            | Aleph         |      139951 | SG Connectivity | IPVPN           | Standard IPVPN Fixed Rate with Auto Backup Port     | Network_IPVPN_Fixed_Protected_Diverse_Fixed         | Any to Any |             139951 | Diverse Path IPVPN Fixed Rate     | Static   |        139951 | 24 Months         |
