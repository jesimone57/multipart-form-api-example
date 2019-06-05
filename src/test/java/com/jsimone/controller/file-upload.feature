Feature: file upload

  Background:
    * url baseUrl
    * configure lowerCaseResponseHeaders = true
    * def myJson = {name: 'joe', description: 'stuff' }

    # fails.  peter thomas suggestion from https://stackoverflow.com/questions/55640639/karate-how-to-test-multipart-form-data-endpoint
  Scenario: upload file 1
    Given path '/document'
    And header Content-Type = 'multipart/form-data'
    * def temp = karate.readAsString('people.csv')
    * print temp
    * print myJson
    And multipart file file =  { value: '#(temp)', filename: 'people.csv', contentType: 'text/csv' }
    And multipart field metadata = { value: '#(myJson)', filename: 'myjson.json', contentType: 'application/json' }
    When method post
    Then status 200

    # fails.  Pratiksha Mokal suggestion from https://stackoverflow.com/questions/55640639/karate-how-to-test-multipart-form-data-endpoint
  Scenario: upload file 2
    Given path '/document'
    And header Content-Type = 'multipart/form-data'
    And multipart file file = { read:'classpath:com/jsimone/controller/people.csv', filename: 'people.csv' }
    And multipart field metadata = { value: '#(myJson)', filename: 'myjson.json', contentType: 'application/json' }
    When method post
    Then status 200

