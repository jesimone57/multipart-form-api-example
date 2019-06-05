Feature:  say hello
  In all of these tests we want to validate the
    1. http status code
    2. headers
    3. response body

  Background:
    * url baseUrl
    * configure lowerCaseResponseHeaders = true

  Scenario: Hello using a path variable
    Given path '/hello/tom'
    When method get
    Then status 200
    And match header content-type contains 'text/plain'
    And match header content-type contains 'charset=utf-8'
    And match response == 'Hello tom'

  Scenario: Hello name using required URL parameter with validation constraint
    Given path '/hello3'
    And param name = 'fred'
    When method get
    Then status 200
    And match header content-type contains 'text/plain'
    And match header content-type contains 'charset=utf-8'
    And match response == 'Hello fred'

  Scenario: Hello using an optional url named parameter
    Given path '/hello4'
    And param name = ''
    When method get
    Then status 200
    And match header content-type contains 'text/plain'
    And match header content-type contains 'charset=utf-8'
    And match response == 'Hello unknown'

  Scenario: Hello using an optional url named parameter
    Given path '/hello4'
    When method get
    Then status 200
    And match header content-type contains 'text/plain'
    And match header content-type contains 'charset=utf-8'
    And match response == 'Hello unknown'

