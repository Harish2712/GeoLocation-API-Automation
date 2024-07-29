Feature: Geolocation API Testing

  @positive	
  Scenario Outline: Test Geolocation API with positive data new
    Given the user provides geolocation data from "<jsonFile>"
    When the user sends a request to the geolocation API
    Then the API should return a valid geolocation response

    Examples: 
      | jsonFile                                               |
      | src/test/resources/testdataAPI/positive/positive1.json |
      | src/test/resources/testdataAPI/positive/positive2.json |
@negative
  Scenario Outline: Test Geolocation API with negative data
    Given the user provides geolocation data from "<jsonFile>"
    When the user sends a request to the geolocation API
    Then the API should return an error response

    Examples: 
      | jsonFile                                               |
      | src/test/resources/testdataAPI/negative/negative1.json |
      | src/test/resources/testdataAPI/negative/negative2.json |
