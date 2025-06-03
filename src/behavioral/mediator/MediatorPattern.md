## 什么是中介者模式

中介者模式是一种行为型设计模式，其主要目的是用一个中介者对象来封装一系列对象之间的交互。中介者使得各对象之间不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

简单来说，想象一下你在一个大型开放式办公室里工作。如果每个人都要直接和另外几百人沟通，那会非常混乱。如果有一个“总务”或“协调员”的角色，所有的沟通都通过他来完成，那会更有序。这个“总务”就是中介者。它负责处理所有同事（具体同事）之间的请求和协调。

## 核心思想

中介者模式将复杂的多对多（网状）交互关系，转换为一对多（星形）交互关系。所有同事（Colleague）都不直接相互通信，而是通过一个中心化的中介者（Mediator）进行通信。中介者知道如何协调不同的同事，从而避免了同事之间紧密的耦合。

## 中介者模式的组成部分

中介者模式通常包含以下四个核心角色：

抽象中介者 (Mediator Interface)：

* 定义： 声明一个抽象接口，用于定义中介者对象与各同事对象之间通信的方法。
* 特点： 所有具体中介者都必须实现这个接口。
* 例子： ChatRoom 接口，包含 sendMessage(User user, String message) 方法。

具体中介者 (Concrete Mediator)：

* 定义： 实现抽象中介者接口。它负责协调和管理各个同事对象之间的交互。它知道每个同事的功能，并能根据需要进行通信。
* 特点： 维护所有同事对象的引用，并实现它们之间的协调逻辑。
* 例子： ChatRoomImpl 类，负责管理聊天室中的用户消息转发。

抽象同事 (Colleague Class)：

* 定义： 声明一个抽象接口或抽象类，用于定义同事对象与中介者通信的方法。它通常会包含一个中介者对象的引用。
* 特点： 所有具体同事都必须实现这个接口/抽象类。
* 例子： User 抽象类，包含 Mediator 引用和 sendMessage()、receiveMessage() 方法。

具体同事 (Concrete Colleague)：

* 定义： 实现抽象同事类。每个具体同事只知道自己的业务逻辑，并知道如何与中介者通信，而不知道其他具体同事的存在或交互方式。
* 特点： 当需要与其他同事交互时，它会通过中介者发送请求。
* 例子： ChatUser 类，代表聊天室中的具体用户。

## 中介者模式的UML类图

``` mermaid
classDiagram
    class Mediator {
        <<interface>>
        +mediate(colleague: Colleague, message: String): void
    }

    class ConcreteMediator {
        -colleagues: List<Colleague>
        +addColleague(colleague: Colleague): void
        +mediate(colleague: Colleague, message: String): void
    }

    class Colleague {
        <<abstract>>
        -mediator: Mediator
        +Colleague(mediator: Mediator)
        +send(message: String): void
        +receive(message: String): void
    }

    class ConcreteColleagueA {
        +ConcreteColleagueA(mediator: Mediator)
        +send(message: String): void
        +receive(message: String): void
    }

    class ConcreteColleagueB {
        +ConcreteColleagueB(mediator: Mediator)
        +send(message: String): void
        +receive(message: String): void
    }

    ConcreteMediator ..|> Mediator
    ConcreteColleagueA ..|> Colleague
    ConcreteColleagueB ..|> Colleague
    Colleague --o Mediator
    ConcreteMediator --o Colleague
    Client --> Mediator
    Client --> Colleague
```

## 中介者模式的优点

* 减少耦合： 将对象之间网状的复杂交互关系，转换为星形的简单交互关系。对象不再直接相互引用，而是通过中介者通信，大大降低了它们之间的耦合度。
* 集中控制： 交互逻辑集中在中介者中，更易于理解、维护和修改。
* 提高可复用性： 各个同事对象变得更加独立和通用，因为它们不再包含其他同事的引用和交互逻辑，从而更容易被复用。
* 简化对象接口： 各个同事对象的接口变得更简单，因为它们只需要与中介者通信。
* 符合开闭原则： 增加新的交互逻辑，通常只需修改中介者或添加新的中介者，而无需修改同事类。

## 中介者模式的缺点

* 中介者臃肿 (Centralization of Control)： 如果交互逻辑非常复杂，中介者可能会变得非常庞大和复杂，难以维护，被称为“上帝对象”。
* 单点故障： 中介者是所有交互的中心，如果中介者出现问题，整个系统可能受影响。

## 中介者模式的应用场景

* 当对象之间存在复杂的，多对多的交互关系，并且这些交互难以管理和理解时。
* 当需要将对象之间交互的逻辑从对象本身中分离出来时。
* 当需要在不改变现有对象的情况下，增加新的交互行为时。
* 图形用户界面 (GUI) 开发： 对话框中的控件（按钮、文本框、列表框）之间往往存在复杂的交互，可以使用中介者来协调。
* 聊天室： 用户之间不直接发送消息，而是通过聊天室服务器（中介者）进行转发。
* 机场交通管制： 飞机之间不直接通信，而是通过塔台（中介者）进行指令和信息交换。
* 工作流引擎： 不同的任务节点之间通过工作流引擎（中介者）进行状态流转和任务分配。

## 总结

在这个聊天室系统的例子中：

* ChatRoom 接口 是抽象中介者。
* ChatRoomImpl 类 是具体中介者。它知道所有的用户，并负责接收来自一个用户的消息，然后将其转发给其他所有相关用户。所有用户之间的通信都由它来协调。
* User 抽象类 是抽象同事。它包含对 ChatRoom 的引用，并定义了发送和接收消息的方法。
* ChatUser 类 是具体同事。它只知道自己的名字和它所属的聊天室。当一个 ChatUser 想要发送消息时，它会将消息发送给它的
  chatRoom（中介者），而不是直接发送给其他用户。当它接收到消息时，也是由 chatRoom 调用其 receiveMessage()
  方法。

通过这种方式，ChatUser 对象之间不再直接相互引用或通信。它们所有复杂的交互逻辑都集中到了 ChatRoomImpl
这个中介者中。这使得添加新用户变得容易，同时如果改变消息转发逻辑（例如，改为只发送给特定用户而不是广播），也只需要修改
ChatRoomImpl，而无需修改任何 ChatUser 的代码，从而大大降低了系统的耦合度。