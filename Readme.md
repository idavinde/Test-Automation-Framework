# Test Automation Framework

This is a Java-based test automation framework.

The framework leverages various libraries and tools to facilitate data-driven testing, logging, reporting, and integration with cloud-based testing platform like lambdatest.

## 🚀 About Me
Hi, My Name is Davinder Raju and I have 6+ years of experience in Automation Testing using technologies like Selenium Webdriver, RestAssured, Appium.

My major expertise is in Java Programming Language.

## Author
- @[idavinde](https://github.com/idavinde)
- EmailAddress: davinderraju@gmail.com

## 🔗 Links

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://katherineoelsner.com/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/davinder-raju/)

## Prerequisites

Before running this framework, ensure the following software is installed on your system:

- **Java 16** - Make sure Java is installed and the JAVA_HOME environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.
- Downlod Link: https://maven.apache.org/download.cgi

## Features

- **Cross-Browser Testing**: Supports running tests on different browsers.
- **Headless Mode**: Faster execution by running tests in headless mode.
- **Cloud Testing**: Integrated with LambdaTest to run tests on the cloud.
- **Logging**: Uses Log4j for detailed logs.
- **Reporting**: Generates detailed reports using Extent Reports.

## Technologies Used
- Java 16
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports

## Setup Instructions


**Clone the Repository:**

```bash
  git clone https://github.com/idavinde/Test-Automation-Framework.git

  cd Test-Automation-Framework
```
**Running Tests on LambdaTest**
```bash
  mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```
**Running Test on Chrome browser on local Machine in Headless Mode.**
```bash
   mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
```
## Reports & Logs
Reports: After execution, a detailed HTML report will be generated at ./report.html.

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

## Logs:
Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project Github Actions
This automation framework is integrated with github actions. The tests will be executed at 11:30PM IST every single day.

The reports will be archieved in gh-pages branch You can view the html reports at : https://idavinde.github.io/Test-Automation-Framework/report.html

