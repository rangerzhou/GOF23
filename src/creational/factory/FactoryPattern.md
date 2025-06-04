## 什么是工厂模式？

工厂模式是一种创建型设计模式，其主要目的是将对象的创建过程封装起来，使客户端代码无需知道具体创建哪个类的实例，只需通过工厂来获取所需的对象。它将对象的创建与使用分离。

简单来说，想象你是一个顾客，想买一台车。你不会自己去组装车辆（创建对象），而是去一家4S店（工厂）。你告诉店员（工厂）你想要什么类型的汽车（比如“保时捷911”或者“仰望U8”），店员就会给你一部组装好的汽车。你不需要知道汽车是如何生产出来的，也不需要关心生产汽车的具体流水线。

## 工厂模式的分类

工厂模式通常分为几种，最常见的是：

### 简单工厂模式 (Simple Factory Pattern)：

* 特点： 由一个工厂类负责创建所有产品。它通常包含一个静态方法，根据传入的参数创建并返回不同类型的产品。
* 优点： 简单易用。
* 缺点： 违反开闭原则（Open/Closed Principle）。当增加新产品时，需要修改工厂类的代码。工厂类职责过重。
* 不属于 GoF（Gang of Four）设计模式，但常作为工厂模式的入门。

UML 类图

``` mermaid
classDiagram
    class Client

    class SimpleFactory {
        +static getCar(type: String): ICar
    }

    class ICar {
        <<interface>>
        +createCar(): void
    }

    class TeslaCar {
        +createCar(): void
    }

    class XiaomiCar {
        +createCar(): void
    }

    Client --> SimpleFactory
    SimpleFactory ..> ICar : creates
    ICar <|.. TeslaCar
    ICar <|.. XiaomiCar
```

### 工厂方法模式 (Factory Method Pattern)：

* 特点： 定义一个用于创建对象的接口，但让子类决定实例化哪一个类。工厂方法让类的实例化延迟到子类。
* 优点： 符合开闭原则。增加新产品时，只需增加新的具体工厂和具体产品，无需修改现有代码。
* 缺点： 类的数量会增加，系统复杂度提高。
* 属于 GoF 设计模式。

UML 类图

``` mermaid
classDiagram
    class ICar {
        <<interface>>
        +createCar(): void
    }

    class TeslaCar {
        +createCar(): void
    }

    class XiaomiCar {
        +createCar(): void
    }

    class ICarFactory {
        <<interface>>
        +getCar(): ICar
    }

    class TeslaFactory {
        +getCar(): ICar
    }

    class XiaomiFactory {
        +getCar(): ICar
    }

    TeslaCar ..|> ICar
    XiaomiCar ..|> ICar
    TeslaFactory ..|> ICarFactory
    XiaomiFactory ..|> ICarFactory
    ICarFactory <|.. TeslaFactory
    ICarFactory <|.. XiaomiFactory
    TeslaFactory ..> TeslaCar : creates
    XiaomiFactory ..> XiaomiCar : creates
    Client --> ICarFactory
    Client --> ICar
```

### 抽象工厂模式 (Abstract Factory Pattern)：

* 特点： 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
* 优点： 隔离了具体类的创建，使得客户端与具体产品系列解耦。
* 缺点： 增加新产品系列时，需要修改抽象工厂及其所有具体工厂。
* 属于 GoF 设计模式。
* 和工厂方法相比，工厂方法关注**一个产品**的创建，抽象工厂关注**一组相关产品**的创建。

UML 类图



``` mermaid
classDiagram
    class Client

    class AbstractFactory {
        <<interface>>
        +createProductA(): AbstractProductA
        +createProductB(): AbstractProductB
    }

    class ConcreteFactory1 {
        +createProductA(): AbstractProductA
        +createProductB(): AbstractProductB
    }

    class ConcreteFactory2 {
        +createProductA(): AbstractProductA
        +createProductB(): AbstractProductB
    }

    class AbstractProductA {
        <<interface>>
        +operationA(): void
    }

    class ConcreteProductA1 {
        +operationA(): void
    }

    class ConcreteProductA2 {
        +operationA(): void
    }

    class AbstractProductB {
        <<interface>>
        +operationB(): void
    }

    class ConcreteProductB1 {
        +operationB(): void
    }

    class ConcreteProductB2 {
        +operationB(): void
    }

    Client --> AbstractFactory
    AbstractFactory <|.. ConcreteFactory1
    AbstractFactory <|.. ConcreteFactory2

    AbstractProductA <|.. ConcreteProductA1
    AbstractProductA <|.. ConcreteProductA2
    AbstractProductB <|.. ConcreteProductB1
    AbstractProductB <|.. ConcreteProductB2

    ConcreteFactory1 ..> AbstractProductA : creates
    ConcreteFactory1 ..> AbstractProductB : creates
    ConcreteFactory2 ..> AbstractProductA : creates
    ConcreteFactory2 ..> AbstractProductB : creates
```

类比：

- AbstractFactory：工厂
  - ConcreteFactory1：小米工厂
  - ConcreteFactory2：华为工厂
- AbstractProductA：手机
  - ConcreteProductA1：小米手机
  - ConcreteProductA2：华为手机
- AbstractProductB：汽车
  - ConcreteProductB1：小米汽车
  - ConcreteProductB2：华为汽车
