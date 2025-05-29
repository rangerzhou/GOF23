## 什么是责任链模式

责任链模式是一种行为型设计模式，其主要目的是将请求的发送者和接收者解耦，并允许将多个对象组织成一条链，然后将请求沿着这条链传递，直到有一个对象能够处理它为止。

简单来说，想象一个任务或请求，它需要被处理，但具体由谁来处理并不确定，或者需要经过一系列的审批。责任链模式就像一个审批流程或任务分发系统：当一个请求到来时，它会沿着预设的链条（由一系列处理者组成）依次传递，每个处理者都有机会处理这个请求。如果一个处理者能够处理，它就处理并结束；如果不能，它就把请求传递给链中的下一个处理者，直到找到一个能处理的处理器为止，或者到达链的末端。

## 责任链模式的组成部分

责任链模式通常包含以下三个核心角色：

抽象处理者 (Handler Interface)：

* 定义： 声明一个处理请求的接口，并定义一个方法来设置链中的下一个处理者。
* 特点： 所有具体处理者都必须实现这个接口。它通常包含一个指向下一个处理者的引用。
* 例子： Approver 接口，包含 setNextApprover() 和 processRequest() 方法。

具体处理者 (Concrete Handler)：

* 定义： 实现抽象处理者接口。它负责处理它能处理的请求，如果不能处理，则将请求转发给链中的下一个处理者。
* 特点： 每个具体处理者都包含处理请求的逻辑。
* 例子： TeamLeader（组长）、Manager（经理）、Director（总监）。

客户端 (Client)：

* 定义： 创建处理者链，并向链中的第一个处理者发送请求。
* 特点： 客户端无需知道哪个具体处理者会处理请求，也无需知道请求是如何沿着链传递的，它只与链的起始点交互。
* 例子： 提交请假申请的员工。

## UML类图

``` mermaid
classDiagram
    class Handler {
        <<interface>>
        +setNext(handler: Handler): Handler
        +handleRequest(request): void
    }

    class ConcreteHandlerA {
        -nextHandler: Handler
        +setNext(handler: Handler): Handler
        +handleRequest(request): void
    }

    class ConcreteHandlerB {
        -nextHandler: Handler
        +setNext(handler: Handler): Handler
        +handleRequest(request): void
    }

    class Client {
        +sendRequest(): void
    }

    ConcreteHandlerA ..|> Handler
    ConcreteHandlerB ..|> Handler
    ConcreteHandlerA --o Handler : nextHandler
    ConcreteHandlerB --o Handler : nextHandler
    Client --> Handler
```

## 责任链模式的优点

* 降低耦合度： 将请求的发送者和接收者解耦。发送者无需知道哪个对象会处理请求，也不知道请求是如何被处理的。
* 增加灵活性： 可以动态地修改或重组责任链，增加或删除处理者，而无需修改客户端代码或现有处理者。
* 职责分离： 每个处理者只负责处理它自己的特定范围内的请求，职责明确。
* 可扩展性： 增加新的处理者非常容易，只需实现抽象处理者接口并将其插入到链中即可。

## 责任链模式的缺点

* 请求不一定被处理： 如果链中没有任何处理者能够处理请求，那么请求可能会到达链的末端而未被处理。
* 链的长度和性能： 如果链太长，或者链中有很多处理者需要遍历，可能会导致请求处理的性能下降。
* 调试困难： 调试时可能难以跟踪请求的处理路径，因为请求是动态传递的。
* 可能导致循环调用： 如果链的设置不当，可能会导致循环调用。

## 责任链模式的应用场景

* 工作流和审批系统： 例如，请假申请、报销流程等，需要不同级别的人员依次审批。
* 事件处理系统： 例如，GUI 框架中的事件冒泡或捕获机制，事件沿着组件层次结构传递。
* 过滤器和拦截器： 例如，Web 框架中的过滤器链（如 Servlet Filter、Spring
  Interceptors），请求在到达最终处理程序前经过一系列过滤处理。
* 日志处理： 根据日志级别将日志消息发送给不同的处理器（如写入文件、发送到控制台、发送邮件）。
* 异常处理： 不同的异常类型由不同的处理器捕获和处理。