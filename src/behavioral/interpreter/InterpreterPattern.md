## 什么是解释器模式

解释器模式是一种行为型设计模式，其主要目的是给定一个语言，定义它的文法表示，并提供一个解释器，该解释器使用该表示来解释语言中的句子。

简单来说，当我们需要为一种**特定领域的小型语言（DSL - Domain-Specific Language）**
定义语法，并希望能够解释（执行）用这种语言编写的语句时，解释器模式就非常有用。它将语言的每个规则表示为一个类，然后通过这些类的组合来解释语句。

> 常用于编译器、规则引擎、数学表达式计算器等场景。

## 解释器模式的组成部分

解释器模式通常包含以下四个核心角色：

抽象表达式 (Abstract Expression)：

* 定义： 声明一个抽象的 interpret()（解释）操作，所有具体的表达式类都必须实现这个操作。
* 特点： 是所有表达式类的父接口或抽象类。
* 例子： Expression 接口，包含 interpret(Context context) 方法。

终结符表达式 (Terminal Expression)：

* 定义： 实现抽象表达式接口，并为语言中的每一个终结符（不能再分解的最小语法单元，如数字、变量）定义一个解释操作。
* 特点： 终结符表达式是语法树的叶子节点。
* 例子： NumberExpression（数字表达式）、VariableExpression（变量表达式）。

非终结符表达式 (Nonterminal Expression)：

* 定义： 也实现抽象表达式接口，并为语言中的每一个非终结符（由终结符或其他非终结符组成的复合语法单元，如加法、减法操作）定义一个解释操作。它通常包含对其他表达式对象的引用（作为子节点）。
* 特点： 非终结符表达式是语法树的中间节点。
* 例子： AddExpression（加法表达式）、SubtractExpression（减法表达式）。

环境 (Context)：

* 定义： 包含解释器之外的一些全局信息。它通常存储变量的值、或者解释器在执行过程中需要共享的数据。
* 特点： 供解释器在解释过程中查找或存储信息。
* 例子： Context 类，用于存储变量名及其对应的值。

客户端 (Client)：

* 定义： 构建（或解析）代表特定语句的抽象语法树，并调用解释操作。
* 特点： 客户端负责组装表达式，并启动解释过程。

## 解释器模式的UML类图

``` mermaid
classDiagram
    class AbstractExpression {
        <<interface>>
        +interpret(context: Context): void
    }

    class TerminalExpressionA {
        +interpret(context: Context): void
    }

    class TerminalExpressionB {
        +interpret(context: Context): void
    }

    class NonterminalExpressionA {
        -operand1: AbstractExpression
        -operand2: AbstractExpression
        +NonterminalExpressionA(op1, op2)
        +interpret(context: Context): void
    }

    class Context {
        // 可以存储变量值、配置等
        -map: Map<String, Integer>
        +lookup(variable): int
        +assign(variable, value): void
    }

    class Client {
        +buildAndInterpret(): void
    }

    TerminalExpressionA ..|> AbstractExpression
    TerminalExpressionB ..|> AbstractExpression
    NonterminalExpressionA ..|> AbstractExpression
    NonterminalExpressionA --o AbstractExpression
    AbstractExpression --> Context
    Client --> AbstractExpression
    Client --> Context
```

## 解释器模式的优点

* 易于扩展： 增加新的语法规则或解释方式，只需增加新的具体表达式类，而无需修改现有代码（符合开闭原则）。
* 易于实现文法： 语法规则直接映射到类结构，使得文法的实现和理解变得简单。
* 灵活： 可以通过组合不同的表达式对象来表示复杂的语句。

## 解释器模式的缺点

* 类数量膨胀： 对于复杂的文法，每增加一个规则就需要增加一个类，可能导致类的数量非常庞大，系统变得复杂。
* 适用场景有限： 通常只适用于那些语法规则相对简单、且稳定的小型领域特定语言。对于复杂的、不断变化的文法，可能更适合使用语法分析器生成工具（如
  ANTLR、JavaCC）。
* 性能问题： 构建和遍历抽象语法树可能带来性能开销，尤其是在解释大量语句时。

## 解释器模式的应用场景

* 当需要解释的语言文法相对简单时。
* 当语言的表达式可以被表示为抽象语法树时。
* 当需要为一种特定领域语言定义解释器时。
* 例如： SQL 查询解析、正则表达式匹配、简单的计算器、规则引擎等。

## 解释器模式示例 (Java) - 简单的四则运算解释器

假设我们想解释一个简单的算术表达式，如 "a + b - c"。这个语言的语法规则如下：

* 表达式 (Expression) 可以是数字、变量、加法或减法。
* 数字 (Number) 是一个终结符。
* 变量 (Variable) 是一个终结符。
* 加法 (Add) 是一种非终结符，由两个表达式组成。
* 减法 (Subtract) 是一种非终结符，由两个表达式组成。