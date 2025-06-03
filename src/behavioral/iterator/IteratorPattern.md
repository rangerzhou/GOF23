## 什么是迭代器模式

迭代器模式是一种行为型设计模式，其主要目的是提供一种顺序访问聚合对象中各个元素的方法，而又不暴露该对象的内部表示。

简单来说，想象你有一堆东西（一个集合，比如一盒扑克牌、一个书架上的书），你想一个一个地去查看它们，但又不想知道这些东西具体是怎么摆放的（比如它们是堆叠的、还是按顺序排列的、还是散落在各处的）。迭代器模式就是为你提供了这样一个**
“查看器”或“遍历器”**，它知道如何一个接一个地把元素给你，而你（客户端）只需要关心“下一个是什么？”和“还有下一个吗？”这两个问题。

## 核心思想

迭代器模式将遍历聚合对象的责任从聚合对象本身分离出来，放入一个独立的迭代器对象中。这样，聚合对象可以专注于存储数据，而迭代器对象则专注于遍历数据。这种分离使得聚合对象和遍历算法都可以独立变化，并且可以在不暴露聚合内部结构的情况下提供多种遍历方式。

## 迭代器模式的组成部分

迭代器模式通常包含以下四个核心角色：

抽象聚合 (Aggregate Interface)：

* 定义： 声明一个创建迭代器对象的接口方法，通常是 createIterator() 或 iterator()。
* 特点： 所有具体聚合都必须实现这个接口。
* 例子： BookCollection 接口，包含 createIterator() 方法。
  具体聚合 (Concrete Aggregate)：

* 定义： 实现抽象聚合接口，负责存储对象的集合，并返回一个具体迭代器的实例。
* 特点： 维护它所包含的对象的集合。
* 例子： Library 类，存储 Book 对象的列表。
  抽象迭代器 (Iterator Interface)：

* 定义： 声明一个访问和遍历聚合中元素的接口，通常包括 hasNext()（判断是否还有下一个元素）和 next()
  （返回下一个元素）等方法。
* 特点： 所有具体迭代器都必须实现这个接口。
* 例子： BookIterator 接口，包含 hasNext() 和 next() 方法。
  具体迭代器 (Concrete Iterator)：

* 定义： 实现抽象迭代器接口，负责实现遍历聚合的具体算法，并跟踪当前遍历的位置。
* 特点： 知道如何遍历其对应的具体聚合对象。
* 例子： LibraryIterator 类，负责遍历 Library 中的书籍。
  迭代器模式的UML类图

``` mermaid
classDiagram
    class Iterator {
        <<interface>>
        +hasNext(): boolean
        +next(): Object
    }

    class Aggregate {
        <<interface>>
        +createIterator(): Iterator
    }

    class ConcreteIterator {
        -aggregate: ConcreteAggregate
        -currentIndex: int
        +ConcreteIterator(aggregate)
        +hasNext(): boolean
        +next(): Object
    }

    class ConcreteAggregate {
        -items: List<Object>
        +addItem(item): void
        +createIterator(): Iterator
    }

    ConcreteIterator ..|> Iterator
    ConcreteAggregate ..|> Aggregate
    ConcreteIterator --o ConcreteAggregate
    Client --> Aggregate
    Client --> Iterator
```

## 迭代器模式的优点

* 分离遍历逻辑与聚合对象： 聚合对象（如 List、Array）不再需要包含遍历自身的逻辑。它只负责存储数据，而遍历的职责交给迭代器。这使得聚合对象更加简洁。
* 支持多种遍历方式： 对于同一个聚合对象，可以有多个不同的迭代器，提供不同的遍历方式（例如，正向遍历、反向遍历、跳过特定元素等），而无需修改聚合对象本身。
* 简化客户端代码： 客户端代码无需了解聚合对象的内部结构，只需通过迭代器接口访问元素。这使得代码更易于编写和维护。
* 开闭原则支持： 增加新的遍历方式或修改聚合对象的内部结构时，通常只需创建新的迭代器或修改具体迭代器，而无需修改聚合对象或客户端代码。
* 提供统一的接口： 允许客户端以统一的方式遍历不同类型的聚合对象（例如，无论是 ArrayList 还是
  LinkedList，都可以通过 Iterator 接口遍历）。

## 迭代器模式的缺点

* 增加了类的数量： 每增加一个聚合，通常就需要增加一个抽象迭代器和一个具体迭代器（如果Java提供了默认实现则会少一些）。
* 不适用于复杂遍历： 对于非常复杂的遍历算法，迭代器模式可能不是最合适的，因为它可能会导致迭代器本身变得复杂。
* 外部迭代器可能维护状态： 外部迭代器（客户端控制遍历）需要客户端来驱动遍历，如果客户端管理不当可能导致问题。

## 迭代器模式的应用场景

* 当需要访问一个聚合对象的内容，而又不暴露其内部表示时。
* 当需要为聚合对象提供多种不同的遍历方式时。
* 当需要在不同的聚合对象上提供统一的遍历接口时（例如，Java 的 java.util.Iterator 和
  java.util.Iterable）。
* 任何需要遍历集合或列表的场景。