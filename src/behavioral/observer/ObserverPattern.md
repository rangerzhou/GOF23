## 什么是观察者模式

观察者模式是一种行为型设计模式，其主要目的是定义对象之间一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都会得到通知并自动更新。

简单来说，想象一下你订阅了一个新闻简报。当有新的新闻发布时（新闻简报的状态改变），所有订阅者（观察者）都会收到通知，然后他们会去阅读这份新闻。你（订阅者）不需要主动去检查是否有新新闻，新闻简报（被观察者）会主动通知你。

## 核心思想

观察者模式将**被观察者（Subject）和观察者（Observer）**
解耦。被观察者只负责维护一个观察者列表，并在状态改变时通知它们。观察者则负责定义当收到通知时要执行的操作。它们之间通过抽象接口进行通信，使得两者可以独立变化。

## 观察者模式的组成部分

观察者模式通常包含以下四个核心角色：

抽象主题 / 被观察者 (Subject / Observable)：

* 定义： 声明一个抽象接口，用于管理观察者（添加、删除、通知）。
* 特点： 维护一个观察者列表，并提供注册（attach()）、注销（detach()）和通知（notifyObservers()）观察者的方法。
* 例子： TencentVideoSubject 类（作为被观察者，因为它存储电视剧数据并通知变化）。

具体主题 / 具体被观察者 (Concrete Subject)：

* 定义： 实现抽象主题接口。它存储自身的状态，并在状态发生改变时通知所有注册的观察者。
* 特点： 当其内部状态改变时，会调用 notifyObservers() 方法。
* 例子： WeatherData 类（因为它实际存储温度、湿度等数据）。

抽象观察者 (Observer Interface)：

* 定义： 声明一个抽象接口，用于定义当被观察者状态改变时，观察者应该如何响应。通常包含一个 update() 方法。
* 特点： 所有具体观察者都必须实现这个接口。
* 例子： Observer 接口，包含 update() 方法。

具体观察者 (Concrete Observer)：

* 定义： 实现抽象观察者接口。它注册到具体主题上，并在收到通知时执行特定的更新逻辑。
* 特点： 维护对具体主题的引用（可选，但常见），以便在收到通知时获取最新状态。
* 例子： CurrentConditionsDisplay（显示当前天气）、ForecastDisplay（显示天气预报）。

## 观察者模式的UML类图

``` mermaid
classDiagram
    class Subject {
        <<interface>>
        +registerObserver(observer: Observer): void
        +removeObserver(observer: Observer): void
        +notifyObservers(): void
    }

    class ConcreteSubject {
        -observers: List<Observer>
        -state: String
        +registerObserver(observer: Observer): void
        +removeObserver(observer: Observer): void
        +notifyObservers(): void
        +setState(state: String): void
        +getState(): String
    }

    class Observer {
        <<interface>>
        +update(data: String): void
    }

    class ConcreteObserverA {
        -subject: Subject
        -observerState: String
        +ConcreteObserverA(subject: Subject)
        +update(data: String): void
        +display(): void
    }

    class ConcreteObserverB {
        -subject: Subject
        -observerState: String
        +ConcreteObserverB(subject: Subject)
        +update(data: String): void
        +display(): void
    }

    ConcreteSubject ..|> Subject
    ConcreteObserverA ..|> Observer
    ConcreteObserverB ..|> Observer
    ConcreteSubject --o Observer
    ConcreteObserverA --o Subject
    ConcreteObserverB --o Subject
    Client --> Subject
    Client --> Observer
```

## 观察者模式的优点

* 松散耦合： 被观察者和观察者之间是松散耦合的。它们之间只通过抽象接口通信，彼此不直接了解对方的具体实现。这意味着你可以独立地修改被观察者或观察者，而不会影响另一方。
* 广播通信： 被观察者可以向所有注册的观察者发送通知，实现一对多的广播。
* 可扩展性： 增加新的观察者非常容易，只需实现观察者接口并注册到被观察者即可，无需修改被观察者代码（符合开闭原则）。
* 支持事件驱动编程： 它是实现事件处理系统和消息队列的基础。

## 观察者模式的缺点

* 通知顺序不确定： 如果没有明确的机制，观察者接收通知的顺序通常是不确定的。
* 性能问题： 如果观察者数量非常庞大，或者 update() 方法的执行开销很大，可能会导致性能问题。
* 循环引用（潜在）： 如果被观察者和观察者之间存在循环引用，可能会导致内存泄漏（但在 Java 中，垃圾回收器通常能处理）。
* 过度通知： 如果被观察者状态频繁变化，可能会导致观察者频繁更新，造成不必要的开销。

## 观察者模式的应用场景

* 事件处理系统： 例如，GUI 编程中按钮点击事件、键盘事件等。
* 消息队列系统： 发布/订阅模型。
* RSS 订阅： 当有新文章发布时，通知所有订阅者。
* 天气预报系统： 天气数据变化时，更新所有显示设备。
* MVC (Model-View-Controller) 架构： 模型（Model）是被观察者，视图（View）是观察者。当模型数据变化时，视图自动更新。
* 股票行情系统： 股票价格变化时，通知所有关注该股票的用户。