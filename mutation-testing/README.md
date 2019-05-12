

# Voxxed Days Australia - 2019 - Mutation Testing
Mutation Testing - Start hunting the bugs
This is a follow up of the talk at [Tuesday from 14:50 til 15:40](https://vxdmelbourne2019.confinabox.com/talk/UWE-9156/Start_hunting_the_bugs_.._Mutation_Testing)

## this exercises 
We will have some practical exercises so that 
you will have good base for your daily work after this.

Junit5 will be part of this exercises.
If needed , have a look at the jUnit5 exercises first 
to make sure that you have all needed information's that we are using. 

## You will learn:
* The difference compared to other testing strategies
* How to start in a new project with mutation testing
* How to optimize mutation testing strategies for larger projects
* How to start in legacy projects with mutation testing
* How you can create the reports for
    * Developers

All of this will be in Core Java. 
If you are coding in kotlin as well, 
you will be able to try this too.

## Basic theory

JUnit is a well-known tool for Java developers in the area of TDD. 
Here it has become accepted, that CodeCoverage can be measured. 
In this case, we distinguish between coverage on the level of classes, 
methods and rows. The goal is to get the CodeCoverage as high as possible 
on the line level, but not higher than necessary.
What exactly does it mean? A CodeCoverage of appr. 
75% on the line level is excellent and can already provide a basis. 
However, what does this figure say?

In this exercises, we are dealing with the term Mutation Testing 
and show the practical ways of use. How can the coverage be defined 
and what can be achieved?
How can it be integrated into an existing project 
and what should be considered while running a test?

## for the impatiens
It’s the term Mutation Testing to be applied here. 
This term itself was mentioned for the first time in 
the literature in the 70s.  

The principle is straightforward: 
you create mutations out of one piece of source code. 
If you run them through the existing tests, at least one test should fail. 
Here it is common to say that the mutation did not survive. 
In another case, the mutation survived if all the tests end successfully. 
According to the tests, it is irrelevant what version remains, 
and it is not their goal.  

Besides, the system contains some vagueness which over 
the long-term in combination with other uncertainties can 
lead to indeterminable errors. Therefore the goal should be to 
create not only a high CodeCoverage but make it as robust as possible.
What kind of support accurately can a machine provide in this case?

## public additional informations
A few links to additional resources that will help to 
work on the topic later again.

[Mutation Testing engl - JFokus](https://youtu.be/9yG1c9Crnbk) 
[Mutation testing Framework](http://pitest.org/) 

## Slides
The slides are available as pdf in the main folder of this exercises.


## tasks to do

### ex01
* open the test class with the name **ServiceTest**
* start writing tests as much as needed to get a perfect line coverage
* to generate the line coverage report **mvn clean test**
    the report (html) will be under **target/site/jacoco/**
* after you are happy with your result, create the mutation test coverage
    **mvn clean test pitest:mutationCoverage**
* check the pitest report under **target/pit-reports/##timestamp##**
    after every run a new report will be created in a new directory (##timestap##)
    a browser reload is not enough ;-)
* write tests to increase the mutation test coverage
* remove tests that are not needed
* loop until you reached the max possible mutation test coverage

### ex02
Now we will use mutation testing for a refactoring task.
Open the class **LegacyService** in the package **ex02** 
and ty to understand what this implementation is doing.

The target is a refactored version of this **LegacyService**.
How to make sure to get a semantic equal implementation?

* open the class **LegacyServiceTest** and start increasing mutation test coverage
* after you reached the maximum mutation test coverage open the classes 
    * **RefactoredService**
    * **RefactoredServiceTest**
* copy all your tests from **LegacyServiceTest** into the class  **RefactoredServiceTest**
* change the class **RefactoredServiceTest** to test the implementation **RefactoredService**
* start refactoring the class **RefactoredService** and increase mutation test coverage
* to verify that both implementations are in sync, 
let all tests run against the legacy and the refactored implementation.

### ext2-solution
In this packages you will find one possible solution for the task **ext02**
To compare your result with the solution, 
enable the test class **SolutionTest** and generate all reports.
