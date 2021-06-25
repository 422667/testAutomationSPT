@DCI_CS_Portal_Subscription_flow
Feature: 0.1 Customer - New Subscription Flow

  @Customer_E2E_Flow_IOT
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for IPVPN Product Offerings "<Product_Offering>" through customer portal
    Given I logged in to the customer portal with "<username>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,Template as "<Template>" ,Child_offer as "<Child_Offer>" ,Child_offer_Template as "<Child_offer_Template>" ,Site_location as "<Site_location>" for CSportal IoT
    #And I click on the Availbility Check button at the Product configure page
    When I click quote by key in contract_duration as "<Contract_duration>" for CSPortal
    #And I Verify the feasibility at the Nokia - Order Management System
    And I accept the quotation by placing the signature and verifying the terms and conditions
    Then I should see the order confirmation page
    #And I verify the Reservation of resources at the Nokia - Order Management System
    When I select the appointments for RFS "Request for Service Date"
    #Then I verify "Request for Service Date" calculated correctly
    When I confirm the order by selecting the "New Billing Account" along with billing contact details
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
    And I verify the billing details at the BRM

    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio ID          | username          | Product_Offering    | Product_Level_1  | Network_Name | Topology | Template                  | Child_Offer | Child_offer_Template | Site_location     | Contract_duration |
     # | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-Intensive-Business | IoT MEC     | IOT-MEC-Medium       | New Armenian Edge | 12 Months         |
      | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-General-Enterprise | IoT MEC     | IOT-MEC-Medium+      | Ayer Rajah        | 12 Months         |
     | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-General-Startup    | IoT MEC     | IOT-MEC-Large        | New Armenian Edge | 24 Months         |
     # | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-Intensive-Business | IoT MEC     | IOT-MEC-Medium       | Ayer Rajah        | 24 Months         |

     
      @Customer_E2E_Flow_IOT_Sample
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for IPVPN Product Offerings "<Product_Offering>" through customer portal
    Given I logged in to the customer portal with "<username>"

   

    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio ID          | username          | Product_Offering    | Product_Level_1  | Network_Name | Topology | Template                  | Child_Offer | Child_offer_Template | Site_location     | Contract_duration |
     # | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-Intensive-Business | IoT MEC     | IOT-MEC-Medium       | New Armenian Edge | 12 Months         |
      | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-General-Enterprise | IoT MEC     | IOT-MEC-Medium+      | Ayer Rajah        | 12 Months         |
     | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-General-Startup    | IoT MEC     | IOT-MEC-Large        | New Armenian Edge | 24 Months         |
     # | UAT_E2E_IOT_TC1.xx | testmo2.kanumuri@gmail.com | IoT Central Manager | IoT-as-a-Service | Network_IOT  | IOT HUB  | IOT-CM-Intensive-Business | IoT MEC     | IOT-MEC-Medium       | Ayer Rajah        | 24 Months         |
     