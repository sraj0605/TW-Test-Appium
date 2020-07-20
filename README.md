# TW-Test-Appium

This is the repository for automation of mySiteXYZ as Mobile App using Appium.
This framework is of type POM (Page Object Model), maven project on TestNG.

package com.thoughtworks.mysite.base 
BastTest java file consists of all base test scripts 
* Reading input config file
* Reading static input as an xml file
* Handling actions on mobile elements

package com.thoughtworks.mysite.listeners 
* Used for report on failed testcases

package com.thoughtworks.mysite.pages
4 Pages are created for the elements present
1. LogIn Page - handle Login scenarios
2. OrderProductsPage - handling orders of items
3. PaymentsPage - handling of payment
4. ConfirmationPage - Empty page on assumption created as there is no screen given

package com.thoughtworks.mysite.testcases
1. Testcases for all the above pages

package com.thoughtworks.mysite.util
TestUtils.Java class is created for below cases
1. Handling constant wait value
2. Method to read xml values for (static messages of the app)

Under main/resources folder
created a folder as app for placing apk file
created a folder for data - jsontest file

The above framework is built on TestNG framework with pom file and testng.xml file to run test suite.







