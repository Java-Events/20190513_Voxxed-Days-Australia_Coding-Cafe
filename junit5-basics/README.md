# Voxxed Days Australia - 2019 - JUnit5

With JUnit 5 we have a new JUnit written entirely from scratch. 
We will have some exercises to see how we can create Extensions to customize jUnit 5.


## Preparations
Open the pom.xml in your IDE and make sure the project is propperly imported.
To test this, invoke the following maven targets.

* mvn clean
* mvn install

After this is successfully ended, you should have all needed dependencies 
in your **.m2** folder that are needed for this exercises.

## Info
For all exercises you have a valid solution. These solutions are in the sub-package **solutions**.

## Ex01
Navigate to the package **ex01**. Here we are working on a plain and basic jUnit5 test.

* create inside the class BasicTests a test-method (annotated with **@Test**) with the name **test001** and the return value **void**. 
* invoke this empty test method to see if every thing is ok so far.

* **DisplayName :**
    jUnit5 will give you the possibility to define a logical display name that is independent from the method name itself.
    For this add the Annotation **@DisplayName** and a value of your choice.
    After this run the test again and check if you see your choosen name.
    [Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names)

* in the test method **test002** you will find the definition of a value called **person**.
    Test that the **person** will have to two attributes set. Both asserts should be grouped 
    with: **assertAll**
    [Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)

* inside the test method **test003** an exception is thrown. 
    * first: enable the test again : [Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling)
    * second: catch the exception and check if the message inside this exception is **a message**
    hint: **assertThrows**
    [Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)

You are able to write basic tests now. Next step will show you how to deal with basic life cycles.

## Ex02
Navigate to the package **ex02** and open the class **TestSimple**
* the method **beforeEach** must be invoked before every test method invocation. 
* the method **afterEach** must be invoked after every test method invocation.
* the method **beforeAll** must be invoked before all test method invocations. 
* the method **afterAll** must be invoked after all test method invocations.

[Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle)

Navigate to the package **ex02** and open the class **TestNonStatic**
* disable the tests
* fix the tests, -> don´t <- make **beforeAll** and **afterAll** static

Navigate to the package **ex02** and open the class **TestNonStatic**

You are able to customize the basic tests lifecycle now. 
Next step will show you how to get and publish informations during a test run.

## Ex03
Navigate to the package **ex03** and open the class **TestReporterTest**

Writing information´s via **System.out.println** is not the best idea. (println is synchronized)
But how we could write informations without adding a logger?
JUnit5 will give you a **TestReporter** for this.

* un-comment the lines in the test-methods and the method **beforeEach**
* get an instance of a TestReporter
    
[Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dependency-injection)

Navigate to the package **ex03** and open the class **TestInfoTest**

* un-comment the lines and get the tests green again.

[Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dependency-injection)

You are able to publish informations during the test-run and you are able to get 
informations about the test method itself that could be used for preparations or to customize the test run itself.
 
Next step will show you how to create an extension.

## Ex04
The annotations **Before** and **After** (-Each and -All) are not enough.
To handle more complex customizations, extensions are needed.


Instead of using **Before-** and **After-** Annotations we want to solve this 
with extensions now. 

An extension is a class that implements the interfaces that are responsible for the 
needed lifecycle step. A replacement for **BeforeEach** would be the implementation of the two 
interfaces **BeforeEachCallback** and **AfterEachCallback**.

Navigate to the package **ex04** and open the class **LifecycleExtensionTest**

* extract the methods **beforeEach** and **afterEach** into the class **MyArroundMethodExtension**
* extract the methods **beforeAll** and **afterAll** into the class **MyArroundClassExtension**
* activate the extensions via **@ExtendWith** [Docu-Ref](https://junit.org/junit5/docs/current/user-guide/#extensions)

* use the extension context (**ExtensionContext context**) to get the store to transfer values between **Before** and **After** steps.
    use the given namespace **context.getStore(namespace)**
* publish in the **After** methods the stored values from the extension store.

You are able to create and register extensions, now. You learned how to store values 
in the context and to share this between extensions as well as extensions steps.

Happy Coding

