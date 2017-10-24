## Unit Testing Extend Topics

### organize automation testing in project
* unit testing cases
  * included in modules
* integration testing cases
  * use separated module or project
* system testing cases
  * use separated project, separated from product code

### test resource management
* test data
  * prefer centralized than independent, e.g. use a `data` folder
* authorization data
  * oops! unit testing should no contains so much dependency
  * integration test? then do not submit to VCS
* virus samples
  * isolated storage, encrypted

### other test frameworks/tools

#### frameworks
* [robot framework](http://robotframework.org) a generic test automation framework for acceptance testing and acceptance test-driven development (ATDD).
* [cucumber](https://cucumber.io/docs/reference) a tool that supports Behaviour-Driven Development (BDD) - a software development process that aims to enhance software quality and reduce maintenance costs.

#### tool libraries
* [rest-assured](https://github.com/rest-assured/rest-assured) Java DSL for easy testing of REST services

#### front end test tools
* [seleniumhq](http://www.seleniumhq.org/) Selenium automates browsers. That's it!
* [autoitscript](https://www.autoitscript.com/site/autoit/) AutoIt v3 is a freeware BASIC-like scripting language designed for automating the Windows GUI and general scripting.

#### network simulate tools
* [clumsy](http://jagt.github.io/clumsy/index.html) makes your network condition on Windows significantly worse, but in a managed and interactive manner.
* [tcpreplay](http://tcpreplay.appneta.com/) is a suite of free Open Source utilities for editing and replaying previously captured network	traffic. Originally designed to replay malicious traffic patterns to Intrusion Detection/Prevention Systems, it has seen many evolutions including capabilities to replay to web servers.

#### performance test tools
* [ab](http://httpd.apache.org/docs/2.4/programs/ab.html) is a tool for benchmarking your Apache Hypertext Transfer Protocol (HTTP) server.
* [galting](http://gatling.io/) is an open-source load testing framework based on Scala, Akka and Netty
* [JMeter](http://jmeter.apache.org/) is a 100% pure Java application designed to load test functional behavior and measure performance. It was originally designed for testing Web Applications but has since expanded to other test functions.
* [Locust](http://locust.io/) An open source load testing tool written in Python.
