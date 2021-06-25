@Internet_CS_Portal_Subscription_flow_>1G
Feature: 0.1 Customer - New Subscription Flow

  @Customer_E2E_Flow_Internet_>_1G_IPV6_Static
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Internet Product Offerings "<Product_Offering>" through customer portal
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
    And I record the order details for the submitted order


    Examples: 
      | Sceanrio_ID             | username               | Product_Offering                                                   | Product_Level_1   | Network_Name                      | Topology         | Postal_code_Config | Contract_duration |
      | UAT_E2E_IS_DDOS_TC1.59  | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN                        | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE |             139951 | 24 Months         |
      | UAT_E2E_IS_DDOS_TC1.57  | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN                            | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE |             139951 | 24 Months         |
      | UAT_E2E_IS_DDOS_TC1.63  | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN with Auto Backup Port  | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE |             139951 | 24 Months         |
      | UAT_E2E_IS_DDOS_TC1.61  | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN with Auto Backup Port      | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE |             139951 | 24 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.14 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE                       | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE |             139951 | 24 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.13 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE                           | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE |             139951 | 24 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.15 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE with Auto Backup Port | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE |             139951 | 24 Months         |
      |  UAT_E2E_IS_DDOS_TC_SPTEL1.16 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE with Auto Backup Port     | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE |             139951 | 24 Months         |

  @Customer_E2E_Flow_Internet_>_1G_IPV6_BGP
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Internet Product Offerings "<Product_Offering>" through customer portal

   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,Protocol as "<Protocol>" ,postal_code as "<Postal_code_Config>" and bandwidth details for more than 1G CSportal
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


    #And I verify the connect order at the Nokia - Order Management System
    Examples: 
      | Sceanrio_ID                 | username               | Product_Offering                                                   | Product_Level_1   | Network_Name                      | Topology         | Protocol | Postal_code_Config | Contract_duration |
      | UAT_E2E_IS_DDOS_TC1.60      | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN                        | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.58      | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN                            | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.64      | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN with Auto Backup Port  | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.62      | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN with Auto Backup Port      | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.1 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE                       | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.2 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE                           | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.3 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE with Auto Backup Port | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.4 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE with Auto Backup Port     | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE | BGP      |             139951 | 36 Months         |

  @Customer_E2E_Flow_Internet_>_1G_IPV4_Static
  
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Internet Product Offerings "<Product_Offering>" through customer portal

   Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,postal_code as "<Postal_code_Config>" ,IPVersion as IPV4 and bandwidth details for more than 1G CSportal
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


    Examples: 
      | Sceanrio_ID                 | username               | Product_Offering                                                   | Product_Level_1   | Network_Name                      | Topology         | Postal_code_Config | Contract_duration |
      | UAT_E2E_IS_DDOS_TC1.51      | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN                        | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.49      | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN                            | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.55      | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN with Auto Backup Port  | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.53      | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN with Auto Backup Port      | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.6 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE                       | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.5 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE                           | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.12     | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE with Auto Backup Port | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.7 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE with Auto Backup Port     | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE |             139951 | 36 Months         |

  @Customer_E2E_Flow_Internet_>_1G_IPV4_BGP
  Scenario Outline: Sceanrio "<Sceanrio ID>" I as a customer verify the New Subscription flow for Internet Product Offerings "<Product_Offering>" through customer portal

     Given I logged in to the customer portal with "<username>" to verify "<Sceanrio_ID>"
    Then I should see the "OTP" page
    When I click the sign in button upon enter the OTP for customer portal login
    Then I should see the customer portal "Dashboard" page
    When I click on the Explore by Product button under the Explore menu
    And I choose the Product offering as "<Product_Offering>" for the product catalogue "<Product_Level_1>"
    Then I should see product offering "<Product_Offering>" added to the cart
    When I click on the Proceed to Quote button in the add to cart page
    Then I should see the Product configure page
    When I key in the product config details Network_Name as "<Network_Name>" ,Topology as "<Topology>" ,Protocol as "<Protocol>" ,postal_code as "<Postal_code_Config>" ,IPVersion as "IPV4" and bandwidth details for more than 1G CSportal
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


    #And I verify the connect order at the Nokia - Order Management System
    Examples: 

      | Sceanrio_ID             | username               | Product_Offering                                                   | Product_Level_1   | Network_Name                      | Topology         | Protocol | Postal_code_Config | Contract_duration |
      | UAT_E2E_IS_DDOS_TC1.52 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN                        | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.50 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN                            | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.56 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by IPVPN with Auto Backup Port  | Internet Services | Network_Internet_IPVPN_Burstable  | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC1.54 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by IPVPN with Auto Backup Port      | Internet Services | Network_Internet_IPVPN_FIXED      | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.8 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE                       | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.9| regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE                           | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.10 | regspweekk37@gmail.com | Enterprise Internet Burstable Rate by MetroE with Auto Backup Port | Internet Services | Network_Internet_MetroE_Burstable | INTERNET SERVICE | BGP      |             139951 | 36 Months         |
      | UAT_E2E_IS_DDOS_TC_SPTEL1.11 | regspweekk37@gmail.com | Enterprise Internet Fixed Rate by MetroE with Auto Backup Port     | Internet Services | Network_Internet_MetroE_FIXED     | INTERNET SERVICE | BGP      |             139951 | 36 Months         |

