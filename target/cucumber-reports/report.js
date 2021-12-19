$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/TestNewDesign.feature");
formatter.feature({
  "line": 1,
  "name": "Demo QA",
  "description": "",
  "id": "demo-qa",
  "keyword": "Feature"
});
formatter.before({
  "duration": 504958900,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Technical test",
  "description": "",
  "id": "demo-qa;technical-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "We are on the BlankFactor main page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "We look for a given blog",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "We validate that the page shown is the correct one",
  "keyword": "Then "
});
formatter.match({
  "location": "StepTest.weAreOnTheBlankFactorMainPage()"
});
formatter.result({
  "duration": 4555232700,
  "status": "passed"
});
formatter.match({
  "location": "StepTest.weLookForAgivenBlog()"
});
