# Evernote with Cucumber

## About

This framework is built with SeleniumWebdriver and Cucumber for UI testing of Evernote web application. Java programming language is used. And it is based on Page Object Model.

The framework is designed to be scalable so that new tests and functions can be easily added later.

## Usage

Test methods can be run from Feature or Runner files. By running from the Feature file, only the scenarios in that Feature are run. When run from Runner file, scenarios to which @tags defined in that Runner are assigned are run sequentially from Feature files.

## Structure

**pom.xml**

The basic Maven pom.xml file. Added Selenium Webdriver and Cucumber dependencies. New dependencies can be added according to the new functionalities that can be included in the framework later on.

**configuration.properties**

This bundle contains the basic data used in the framework, such as URL, user information, browser model, basic settings. It is used to avoid a hard coded implementation. Information and settings can be easily changed from this file.

***src/test/java/***

**pages/**

This package contains the Page files. A separate Page file has been designed for each web page. Page files contain web elements, locators and methods specific to that page.

**runners/**

This package contains the Runner files. Runner files are designed to run certain test groups according to different settings. A new Runner file can be created to run a different test group with different settings as needed. Annotations (@tags) are used to group tests.

**stepdefinitions/**

This package contains the Java files with the test methods. The methods were grouped according to the web pages they are related to and the generality of use and saved in different files. Scalability was taken into account in the design of the methods.

***utilities/***

**Auxiliary.java**

This Java file contains helper methods that are not related to a specific test but may be needed more than once in different places throughout the framework.

**ConfigReader.java**

This Java file is responsible for reading the settings from the configuration.properties file.

**Driver.java**

This Java file configures the basic driver settings. It is responsible for installing the browser driver, setting it to the desired settings, and closing it when requested.

***src/test/resources/***

**note.txt**

This file contains the note to be saved for testing purposes in the Evernote application.

**features/**

This folder contains Feature files specific to the Cucumber framework, written according to the Gherkin language standards.
