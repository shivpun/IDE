# Lambda Expression
* The `functional interface` also known as `Single Abstract Method` Interface was introduced to facilitate `Lambda functions`
* Different way to implement:
    * Zero parameter:
        `() -> System.out.println("Zero parameter lambda");`
    * One parameter:–
        `(p) -> System.out.println("One parameter: " + p);`
    * Multiple parameters :
        `(p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);`
* Instead of using
    `AN ANONYMOUS CLASS`
    you can use
    `A LAMBDA EXPRESSION`
    And if this just calls one method, you can use
    `A METHOD REFERENCE`
## For Example:
### java.util.function.Consumer
* Integer as Argument
java.util.function.Consumer<Integer> display = a -> System.out.println(a);
* String as Argument
java.util.function.Consumer<String> display = a -> System.out.println(a);
### java.util.function.Supplier
* 
