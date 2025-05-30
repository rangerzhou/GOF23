## 什么是桥接模式

桥接模式（Bridge Pattern）是一种结构型设计模式，用于将抽象部分与实现部分分离，使它们可以独立变化。它通过组合而非继承
来实现灵活的扩展。本例通过一个简单的 Java 示例来解释桥接模式的实现和使用场景。

## 桥接模式的关键组成部分

- 实现部分接口（Implementor）：Color 接口，定义实现部分的接口（如颜色应用）。
- 具体实现（Concrete Implementor）：RedColor 和 BlueColor，实现具体的颜色逻辑。
- 抽象部分（Abstraction）：Shape 抽象类，持有实现部分的引用（Color），定义抽象行为。
- 具体抽象（Refined Abstraction）：Circle 和 Rectangle，扩展抽象部分，定义具体的形状行为。
- 客户端：通过组合不同的 Shape 和 Color 创建对象，调用 draw 方法。

## 桥接模式的优点

- 分离抽象与实现：形状（Shape）和颜色（Color）可以独立扩展。例如，添加新形状（如三角形）或新颜色（如绿色）无需修改现有代码。
- 符合开闭原则：新增形状或颜色只需添加新类，不影响现有类。
- 灵活组合：通过组合，可以灵活创建任意形状与颜色的组合（如红色圆形、蓝色矩形）。
- 降低耦合：抽象部分通过接口引用实现部分，减少直接依赖。

## 使用场景

* 当需要将抽象与实现分离，使两者可以独立变化时。
* 当一个类有多个独立变化的维度（如形状和颜色）时。
* 需要在运行时动态切换实现（如切换颜色）时。
