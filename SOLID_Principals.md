# Agenda
## SOLID Design Principals
1) S:- Single Responsibility Principal
2) O:- Open Close Principal
3) L:- Liskov's Substitution Principal
4) I:- Interface segregation Principal
5) D:- Dependency Inversion Principal

Principals are set of guidelines defined to write good code.

Good code which is Extensible, Moodular, Maintainable , Readable and Reusable

# Single Resposibility Principal

- Every code unit (method, class, interface) should have single responsibility
- Single responsibility means there should be only one reason to change code unit
## How to Identify that your code violating SRP
1) Too many if else conditions
2) Monster method - method which does more than what it name suggest
3) Common/Utils/Helper - Create package like common, utils or helper and put all related Sinle resposibility related java class unit under package like StringUtil.java,DateUtil.java etc. Do not create one Utils.java and put all utils related code of strin and data inside it.

# Open Close Principal (OCP)
1) Our codebase should be extensible to add new features and it should not require to modify existing codebase.
2) Rather than changing existing code,we should be able to add new code units.
- e.g. Taking Bird class as an example, bird class should be only responsible for generic attributes and behaviour that everyone have same and specific attributes and behaviour should go to specific bird type class. To achieve OCP, make bird class abstract and its generic methods as abstract (no implemenation).Coder now free to create specific type of bird class like Pigeon and extend abstract Bird class and implement abstract methods. This way we open for extension of feature and close existing code units.

# Liskov's Substituation Principal
Object of any child class should be as it is substituable in reference/variable of parent type without requiring any code changes.
- e.g. Bird b = new Pigeon() or b = new Eagle()

# Interface Segregation Principal
These are just guidelines and not rules
1) Idelally interface should have single method (functional Interface)
2) Interface should be light as possible
3) This is like SRP of interfaces that every interface should have single responsibility.

# Dependency Inversion Principals
1) No 2 classes should be depend upon each other directly, they should depend on each other via Interface
2) This means rather that using direct implementation of behaviour use it via interfaces


### Design Patterns and its details are provided inside designPatterns folder.