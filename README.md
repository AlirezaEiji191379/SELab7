# MiniJava
Mini-Java is a subset of Java. MiniJava compiler implement a compiler for the Mini-java
programming language.

# Rules
```
Goal --> Source EOF
Source --> ClassDeclarations MainClass
MainClass --> class Identifier { public static void main() { VarDeclarations Statements}}
ClassDeclarations --> ClassDeclaration ClassDeclarations | lambda
ClassDeclaration --> class Identifier Extension { FieldDeclarations MethodDeclarations }
Extension --> extends Identifier | lambda
FieldDeclarations --> FieldDeclaration FieldDeclarations | lambda
FieldDeclaration --> static Type Identifier ;
VarDeclarations --> VarDeclaration VarDeclarations | lambda
VarDeclaration --> Type Identifier ;
MethodDeclarations --> MethodDeclaration MethodDeclarations | lambda
MethodDeclaration --> public static Type Identifier ( Parameters ) { VarDeclarations Statements return GenExpression ; }
Parameters --> Type Identifier Parameter | lambda
Parameter --> , Type Identifier Parameter | lambda
Type --> boolean | int
Statements --> Statements Statement | lambda
Statement --> { Statements } | if ( GenExpression ) Statement else Statement | while ( GenExpression ) Statement | System.out.println ( GenExpression ) ; | Identifier = GenExpression ;
GenExpression --> Expression | RelExpression
Expression --> Expression + Term | Expression - Term | Term
Term --> Term * Factor | Factor
Factor --> ( Expression ) | Identifier | Identifier . Identifier | Identifier . Identifier ( Arguments ) | true | false | Integer
RelExpression --> RelExpression && RelTerm | RelTerm
RelTerm --> Expression == Expression | Expression < Expression
Arguments --> GenExpression Argument | lambda
Argument --> , GenExpression Argument | lambda
Identifier --> <IDENTIFIER_LITERAL>
Integer --> <INTEGER_LITERAL>
```

# Questions

## Q1.
- Clean code: A clean code is easily readable and understandable for other programmers. All the variables are well named and there is no duplication in the code. It has the minimal number of classes and it is easily maintainable. A clean code should pass all the tests.

- Technical debt: In some situations programmers rather to write an unclean code for example a code without the required tests due to the business pressure. This may bring them a temporarily speed up. However, it will turn into a technical debt which not only slows down their pace but also they have to pay off it by writing the tests.

- Code smell: A code smell is any characteristic in the source code of a program that possibly indicates a deeper problem. It is a result of poor or misguided programming.

## Q2. 
- **Bloaters:** Bloaters are code, methods and classes that have increased to such gargantuan proportions that they are hard to work with. Usually these smells do not crop up right away, rather they accumulate over time as the program evolves (and especially when nobody makes an effort to eradicate them).

	Examples: Long method, Primitive obsession, Data clumps, Large class, Long parameter list

- **Object-Oriented Abusers**: All these smells are incomplete or incorrect application of object-oriented programming principles.

	Examlpes: Alternative classes with different interfaces, Refused Bequest, Switch statements, Temporary field
	
- **Change Preventers:** These smells mean that if you need to change something in one place in your code, you have to make many changes in other places too. Program development becomes much more complicated and expensive as a result.

	Examples: Divergent change, Parallel inheritence hierarchies, Shotgun surgery
	
- **Dispensables:** A dispensable is something pointless and unneeded whose absence would make the code cleaner, more efficient and easier to understand.

	Examples: Comments, Data class, Lazy class, Duplicate code, Dead code, Speculative generailty
	
- **Couplers:** All the smells in this group contribute to excessive coupling between classes or show what happens if coupling is replaced by excessive delegation.

	Examples: Feature envy, Incomplete library class, Middle man, inappropriat intimacy, Message chains
	
## Q3.
- Dispensables

- To treat the lazy classes, we can use the following refactorings. 
	Inline class refactoring: Move all features from the class to another one.
	Collapse Hierarchy: Merge the subclass and superclass.
	
- Sometimes a Lazy Class is created in order to delineate intentions for future development, In this case, try to maintain a balance between clarity and simplicity in your code.
	
