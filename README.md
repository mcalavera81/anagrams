# Anagram Detector

## Description
 This is a simple application to detect anagrams.

### Assumptions
 Empty String is not an anagram.
 Non-alphanumeric characters are ignored.
 
## Running test
```
./gradlew test
```

## Run app
Sample:
```
./gradlew run --args="'a gentleman' 'elegant man'"
```

## Areas of improvement
* Create an interactive menu to evaluate continuously anagrams until you decide to leave.
* Include linter
* OWASP sec. check.
* Prepare Docker infrastructure:
  * Dockerfile
  * Image security analysis
* Expose the Program as a REST service:
  * Define Controller/Service layers
  * Define Error Schema
  * Define DTO
  * Include API/service tests
  * Include OpenAPI contract
