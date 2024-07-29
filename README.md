# Geolocation API Automation Project

## Overview

This project is an automation framework for testing the Geolocation API using the Rest-Assured and Cucumber frameworks. The tests are written in Java and executed using TestNG. The framework reads input data from multiple JSON files for both positive and negative scenarios, and generates test execution reports using Extent Reports.

## Project Structure



## Prerequisites

- Java 8 or later
- Maven
- An API key for the Geolocation API (replace `YOUR_API_KEY` in the code)

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/geolocation-automation.git
    cd geolocation-automation
    ```

2. Add your Geolocation API key:
   ```sh
    - Open `GeolocationSteps.java`
    - Replace `YOUR_API_KEY` with your actual API key.
   ```

3. Install dependencies:
    ```sh
    mvn clean install
    ```

## Running the Tests

To run the tests, use the following command:
```sh
mvn test
```


Extent Reports
After running the tests, the Extent Reports will be generated in the target directory:
```sh
target/cucumber-reports/cucumber-pretty.html
target/cucumber-reports/CucumberTestReport.json
geolocation-api-automation/extent-report.html(recommended report file)
```

Test Scenarios
```sh
The framework reads test data from JSON files located in src/test/resources/testdataAPI/positive and src/test/resources/testdataAPI/negative.
```

Positive Scenario Example (positive/test1.json)
```sh
{
    "homeMobileCountryCode": 91,
    "homeMobileNetworkCode": 405,
    "radioType": "gsm",
    "carrier": "Jio",
    "considerIp": true
}
```


Negative Scenario Example (negative/test1.json)
```sh
{
    "homeMobileCountryCode": "INVALID",
    "homeMobileNetworkCode": 405,
    "radioType": "gsm",
    "carrier": "Jio",
    "considerIp": true
}
```

## Code Details

GeolocationSteps.java

This class contains the step definitions for the Cucumber tests. It sends requests to the Geolocation API using the data from the JSON files and validates the responses.

Hooks.java

This class is responsible for loading the JSON test data before the tests are run. It reads all JSON files from the positive and negative directories and stores them in lists.

JsonUtils.java

This utility class provides a method to read and parse JSON files into maps.

TestRunner.java

This class configures the Cucumber test runner and specifies the locations of the feature files and step definitions. It also integrates the Extent Reports plugin.

Geolocation.feature

This feature file defines the test scenarios for the Geolocation API. It uses scenario outlines to iterate through the different sets of test data.


## Troubleshooting
```sh
Ensure all dependencies are correctly specified in the pom.xml.
Verify that the API key is correctly set in the code.
Ensure JSON files are correctly formatted and located in the appropriate directories.
```

## Contributing
```sh
Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.
```


## License

This project is licensed under the MIT License.
```sh
Make sure to replace any placeholder values like `YOUR_API_KEY` and the GitHub URL with actual values relevant to your project.
```
