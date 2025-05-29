## 什么是命令模式

命令模式是一种行为型设计模式，其主要目的是将一个请求（或操作）封装成一个独立的对象。这样，你就可以用不同的请求参数化客户端，将请求排队或记录请求日志，以及支持可撤销的操作。

简单来说，命令模式就像一个**万能遥控器或者任务清单**
。你按下遥控器上的一个按钮（发出一个命令），遥控器（命令对象）知道该做什么，并最终告诉电视机（接收者）执行相应的动作，而你（客户端）不需要知道电视机是如何工作的。

## 核心思想

命令模式将请求的发送者与请求的接收者解耦。它把一个动作封装在一个命令对象中，这个命令对象包含了执行动作所需的所有信息：动作本身、执行动作的对象（接收者）、以及任何必要的参数。

## 命令模式的组成部分

命令模式通常包含以下四个核心角色：

命令 (Command Interface)：

* 定义： 声明一个执行操作的接口，通常包含一个 execute() 方法。
* 特点： 所有具体命令都必须实现这个接口。
* 例子： Command 接口，包含 execute() 方法。

具体命令 (Concrete Command)：

* 定义： 实现命令接口，将一个接收者对象和一个或多个动作绑定起来。它调用接收者的相应操作来执行请求。
* 特点： 每个具体命令都封装了一个特定的请求。它通常持有接收者的引用，以及执行操作所需的任何参数。
* 例子： LightOnCommand（开灯命令）、LightOffCommand（关灯命令）。

调用者 (Invoker)：

* 定义： 负责调用命令对象的 execute() 方法。它不了解具体命令的实现，也不知道接收者的细节。
* 特点： 调用者只持有命令接口的引用，通过命令来触发操作。它可以用来实现命令的排队、记录、撤销等功能。
* 例子： RemoteControl（遥控器）。

接收者 (Receiver)：

* 定义： 执行与请求相关的实际操作的对象。命令对象知道如何调用接收者的相应方法。
* 特点： 接收者才是真正执行业务逻辑的对象。
* 例子： Light（灯）。

## 命令模式的UML类图

``` mermaid
classDiagram
    class Command {
        <<interface>>
        +execute(): void
    }

    class ConcreteCommandA {
        -receiver: Receiver
        -param: Type
        +ConcreteCommandA(receiver, param)
        +execute(): void
    }

    class ConcreteCommandB {
        -receiver: Receiver
        +ConcreteCommandB(receiver)
        +execute(): void
    }

    class Invoker {
        -command: Command
        +setCommand(command: Command): void
        +pressButton(): void
    }

    class Receiver {
        +action1(): void
        +action2(): void
    }

    ConcreteCommandA ..|> Command
    ConcreteCommandB ..|> Command
    ConcreteCommandA --o Receiver
    ConcreteCommandB --o Receiver
    Invoker --> Command
    Client --> Invoker
    Client --> Command
    Client --> Receiver
```

## 命令模式的优点

* 解耦发送者和接收者： 调用者（请求的发送者）与接收者（请求的实际执行者）完全解耦。调用者只需要知道如何执行
  Command 接口的 execute() 方法，而无需知道具体是哪个对象在执行什么操作。
* 更容易扩展： 增加新的命令类，而无需修改现有的调用者和接收者类。
* 支持撤销/重做： 命令对象可以存储执行操作前的状态，以便在需要时进行回滚（撤销）。
* 支持队列化请求： 可以将命令对象放入队列中，按顺序执行。
* 支持宏命令 (Macro Command)： 可以将多个命令组合成一个复合命令。
* 日志和事务： 可以轻松实现命令的日志记录和事务操作。

## 命令模式的缺点

* 增加类数量： 每增加一个操作，就需要增加一个具体的命令类，这可能导致类的数量膨胀。
* 复杂性增加： 对于简单的操作，引入命令模式可能显得过于复杂。

## 命令模式的应用场景

* 图形用户界面 (GUI) 系统： 菜单项、按钮点击等都可以被封装为命令。
* 事务处理： 将一系列操作封装为命令，可以方便地实现事务的提交和回滚。
* 宏操作和脚本： 记录用户操作序列，以便重复执行。
* 任务调度器/队列： 将任务封装为命令对象，放入队列中，由调度器按需执行。
* 可撤销/重做功能： 实现文本编辑器的撤销功能等。
* 命令行操作。

## 总结
在这个智能家居遥控器的例子中：

* Command 接口：定义了所有命令的通用方法 execute()。
* Light 是接收者：它们知道如何执行具体的开/关操作。
* LightOnCommand, LightOffCommand 是具体命令：它们分别封装了“打开灯”、“关闭灯”这些请求。每个命令都持有其对应的接收者对象，并在
  execute() 方法中调用接收者的相应方法。
* RemoteControl 是调用者：它有多个插槽来存放命令。当用户按下按钮时，它只是简单地调用相应插槽中命令的
  execute() 方法，而不需要知道这个命令到底会操作哪个设备或执行什么具体的逻辑。
  通过命令模式，我们实现了：

* 解耦： 遥控器（调用者）只知道它在执行一个命令。灯（接收者）也不知道有遥控器在控制它们，只知道它们在被调用执行操作。
* 可扩展性： 如果要增加一个“音响播放音乐”的功能，只需创建 SoundSystem 接收者和 PlayMusicCommand
  命令，然后将它设置到遥控器插槽即可，无需修改现有代码。

同样 Android 中的 Button 点击事件也是一个典型的 Command 模式：
button 就是调用者，OnClickListerner 就是 Command 接口，new View.OnClickListener(){} 就是接口的具体实现，onClick() 中调用接收者的相应方法，
``` java
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        System.out.println("Hello World!");
    }
});
```