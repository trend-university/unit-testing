## Unit Testing Test Double Practice

### Test double introduction

#### think about
* How can we verify logic independently when code it depends on is unusable?
* How can we avoid Slow Tests?

#### why test double
We replace a component on which the SUT depends with a "test-specific equivalent."

When we are writing a test in which we cannot (or chose not to) use a real depended-on component (DOC), we can replace it with a Test Double.

> The Test Double doesn't have to behave exactly like the real DOC; it merely has to provide the same API as the real one so that the SUT thinks it is the real one!

---

### Test doubles technologies

#### overview
```
graph TD
TestDoubles(Test Doubles)--> Dummy
TestDoubles --> Fake
TestDoubles --> Stub
TestDoubles --> Spy
Stub --> Mock
Spy --> Mock
Fake --> Mock
```

#### dummy
Dummy objects are passed around but never actually used. Usually they are just used to fill parameter lists.


> a Dummy Object isn't really a Test Double per se but rather an alternative to the value patterns.

#### fake
Fake objects actually have working implementations, but usually take some shortcut which makes them not suitable for production (an InMemoryTestDatabase is a good example).

> The most common reason for using a Fake Object is that the real depended-on component is not available yet, is too slow or cannot be used in the test environment because of deleterious side effects.

#### stub
Stubs provide canned answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test.

> Some people use the term "Test Stub" to mean a temporary implementation that is used only until the real object or procedure is available. I prefer to call this a Temporary Test Stub (see Test Stub) to avoid confusion.


#### spy
Spies are stubs that also record some information based on how they were called. One form of this might be an email service that records how many messages it was sent.

#### mock
Mocks are pre-programmed with expectations which form a specification of the calls they are expected to receive. They can throw an exception if they receive a call they don't expect and are checked during verification to ensure they got all the calls they were expecting.

> We can use a Mock Object as an observation point that is used to verify the indirect outputs of the SUT as it is exercised.

---

### test framework / tool libs
* [JUnit 4](http://junit.org/junit4/) JUnit is a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.
* [TestNG](http://testng.org/doc/) TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use
* [Mockito](http://site.mockito.org/) Tasty mocking framework for unit tests in Java
* [java-facter](https://github.com/DiUS/java-faker) A library for generating fake data such as names, addresses, and phone numbers.
* [random-beans](https://github.com/benas/random-beans/wiki) for create random object
* [H2 database](http://www.h2database.com/html/main.html) in-memory databases
* [spring-test](https://docs.spring.io/spring/docs/4.3.12.RELEASE/spring-framework-reference/html/overview.html#overview-testing) contains some test utils for Unit Testing


#### gradle dependencies

```
dependencies {

    // https://mvnrepository.com/artifact/junit/junit
    testCompile group: 'junit', name: 'junit', version: '4.12'

    // https://mvnrepository.com/artifact/org.testng/testng
    testCompile group: 'org.testng', name: 'testng', version: '6.11'

    // https://mvnrepository.com/artifact/io.github.benas/random-beans
    compile group: 'io.github.benas', name: 'random-beans', version: '3.7.0'

    // https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    compile group: 'com.github.javafaker', name: 'javafaker', version: '0.13'

    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    // testCompile group: 'org.mockito', name: 'mockito-core', version: '2.11.0'
    testCompile group: 'org.mockito', name: 'mockito-core', version: '2.+'

    // https://mvnrepository.com/artifact/com.h2database/h2
    testCompile group: 'com.h2database', name: 'h2', version: '1.4.196'

    // https://mvnrepository.com/artifact/org.springframework/spring-test
    testCompile group: 'org.springframework', name: 'spring-test', version: '4.3.12.RELEASE'
}
```

### sample code

https://github.com/trend-university/unit-testing


---

### good articles
* [How to write good tests](https://github.com/mockito/mockito/wiki/How-to-write-good-tests)
* [如何通过测试替代（Test Doubles）合理隔离单元测试以提高单元测试效率](https://www.ibm.com/developerworks/cn/java/j-lo-TestDoubles/)

### books
* [xUnit Test Patterns: Refactoring Test Code](http://xunitpatterns.com/)
* [Growing Object-Oriented Software,Guided by Tests](http://www.growing-object-oriented-software.com/)

#### 中文版本
* [xUnit测试模式：测试码重构](https://item.taobao.com/item.htm?id=560299118413)
* [测试驱动的面向对象软件开发](http://item.jd.com/10060248.html)
