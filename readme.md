Application: Car Lease calculator (https://www.seb.lt/eng/private/calculator-leasing)

--Test plan--

*Introduction: 
Car Lease calculator purpose is to help customers find out approximate lease for their car.
Main purpose is to present customer with approximate down, monthly payments and interest rate.

*Scope: Automate E2E regression testing for Car Lease calculator by covering happy flow and validations test cases.

*Reasoning: It is recommended to cover most useful cases or so called happy flows, so we can emulate customer and testers don't need to waste time on main flows, time then can be spent on edge case scenarios as it is not recommended to automate something super complex what would take forever to automate, but human to check in a few mins. Also, it is recommended to automate most common validations, so we can be assured that our product is behaving as expected and doesn't give user undesirable errors.

*Software: Selenium, JUnit, Maven

--Test cases--

TC1: Happy flow (Enter valid inputs, submit them and validate result)

TC2: Validations (Validate that inputs throw validations correctly)

TC3: Labels (Validate that labels presented are correct)

TC4: Validate calculations with negative amounts

TC5: Submit form few times and validate compare functionality


