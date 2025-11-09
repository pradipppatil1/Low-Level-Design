# Design Patters
1) Something that repeat or occurces frequently 
2) Well established solution for problem that occurce during designing/ writing code

# Creational Design Patterns
- How to create object of class
- Diffrent ways to create object
## Singlton
- Allow us to create only one object for a class when needed e.g. Shared resources like DB connection
- Check detailed implemenation inside /designPatters/singleton/
## Builder
- Instead of calling a long constructor with many arguments,you build the object gradually using easy-to-read methods.
- It allow us to create object with following requirements
1) Class with lot of attributes
2) Validation required before object creation
- Details, create student class which have many attributes, so we have to use builder pattern as per above given 2 criterias.
- Will see how production builder pattern code going to be and for student will try to generate pattern
- #### inside Client class Student std = Student.getStudentBuilder().setName().build(); 
- Student class will have StudentBuilder as internal Builder class
- StudentBuilder will have same student attributes with getter setter methods and build() method, each attribute setter method will return StudentBuilder object,build() will do validation and student object creation.
- Student class will have all attributes without setter getter, private constructor with StudentBuilder parameter and getStudentBuilder method,which will return StudentBuilder object.
- Detailed implementation is inside /designPatterns/builder/ folder

## Prototype
- Prototype Pattern is a creational design pattern that lets you create new objects by copying (cloning) existing ones, instead of creating them from scratch.
- Make a duplicate of an existing object to save time and resources.
- Prototype Pattern using a Registry (Prototype Registry Pattern) —
a simplified version where prototypes are registered once in a central place (registry), and then cloned on demand.
- Detailed implementation is inside /designPatterns/prototype/ folder

## Factory
- Factory Pattern is a design pattern that provides a way to create objects without exposing the creation logic to the client,and instead, uses a common interface for all created objects.

- Abstract Factory
- Divide the interface in 2 separate interfaces
1) Interface with all attributes and non-factory methods
2) Interface with factory methods.

- Detailed implementation is inside /designPatterns/factory/ folder

# Structural Design Patterns
- How your class/ code should be structured
- How class should intract with another class

## Adapter Design Pattern
1) what is Adapter?
- Something which convert one form to another.
2) It acts as a bridge between two incompatible interfaces.
3) The Adapter Pattern allows incompatible classes to work together by converting the interface of one class into another interface that a client expects
4) Adapter pattern ensure that our codebase remain maintainable when we are talking to incompatible interface or 3rd parties api

- Detailed implementation is inside /designPatterns/adapter/ folder 

### How to use Adapter
- Define an interface
- Implementation of an interface in Adapter class

# Behavioural Design Patterns
- How to write behaviour
- How to implement actions/ methods in our code base

## Stratergy Design Pattern
- When we have multiple way to implement method/action.
- When you want to switch logic at runtime without using lots of if-else statements.
- It allows you to change the behavior (algorithm) of a class without changing its code.

- Detailed implementation is inside /designPatterns/strategy/ folder 
