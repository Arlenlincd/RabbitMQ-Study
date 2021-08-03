# 一、中间件

## 1. 什么是中间件

> 什么是中间件

我国企业从20世纪80年代开始就逐渐进行信息化建设，由于方法和体系的不成熟，以及企业业务的市场需求的不断变化，一个企业可能同时运行着多个不同的业务系统，这些系统可能基于不同的操作系统、不同的数据库、异构的网络环境。现在的问题是，如何把这些信息系统结合成一个有机地协同工作的整体，真正实现企业跨平台、分布式应用。中间件便是解决之道，它用自己的复杂换取了企业应用的简单。

中间件（Middleware）是处于操作系统和应用程序之间的软件，也有人认为它应该属于操作系统中的一部分。人们在使用中间件时，往往是一组中间件集成在一起，构成一个平台（包括开发平台和运行平台），但在这组中间件中必须要有一个通信中间件，即中间件+平台+通信，这个定义也限定了只有用于分布式系统中才能称为中间件，同时还可以把它与支撑软件和使用软件区分开来

> 为什么需要使用消息中间件

具体地说，中间件屏蔽了底层操作系统的复杂性，使程序开发人员面对一个简单而统一的开发环境，减少程序设计的复杂性，将注意力集中在自己的业务上，不必再为程序在不同系统软件上的移植而重复工作，从而大大减少了技术上的负担，中间件带给应用系统的，不只是开发的简便、开发周期的缩短，也减少了系统的维护、运行和管理的工作量，还减少了计算机总体费用的投入。

> 中间件特点

为解决分布异构问题，人们提出了中间件（middleware)的概念。中间件时位于平台（硬件和操作系统）和应用之间的通用服务，如下图所示，这些服务具有标准的程序接口和协议。针对不同的操作系统和硬件平台，它们可以有符合接口的协议规范的多种实现。

![1](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/1.jpg)

也很难给中间件一个严格的定义，但中间件应具有如下的一些特点：

（1）满足大量应用的需要

（2）运行于多种硬件和 OS平台

（3）支持分布计算，提供跨网络、硬件和 OS平台的透明性的应用或服务的交互

（4）支持标准的协议

（5）支持标准的接口

由于标准接口对于可移植性和标准协议对于互操作性的重要性，中间件已成为许多标准化工作的主要部分。对于应用软件开发，中间件远比操作系统和网络服务更为重要，中间件提供的程序接口定义了一个相对稳定的高层应用环境，不管底层的计算机硬件和系统软件怎样更新换代，只要将中间件升级更新，并保持中间件对外的接口定义不变，应用软件几乎不需任何修改，从而保护了企业在应用软件开发和维护中的重大投资。

简单说：中间件有个很大的特点，是脱离于具体设计目标，而具备提供普遍独立功能需求的模块。这使得中间件一定是可替换的。如果一个系统设计中，中间件时不可替代的，不是架构、框架设计有问题，那么就是这个中间件，在别处可能是个中间件，在这个系统内是引擎。

> 在项目中什么时候使用中间件技术

在项目的架构和重构中，使用任何技术和架构的改变我们都需要谨慎斟酌和思考，因为任何技术的融入和变化都可能人员，技术，和成本的增加，中间件的技术一般现在一些互联网公司或者项目中使用比较多，如果你仅仅还只是一个初创公司建议还是使用单体架构，最多加个缓存中间件即可，不要盲目追求新或者所谓的高性能，而追求的背后一定是业务的驱动和项目的驱动，因为一旦追求就意味着你的学习成本，公司的人员结构以及服务器成本，维护和运维的成本都会增加，所以需要谨慎选择和考虑。

但是作为一个开放人员，一定要有学习中间件技术的能力和思维，否则很容易当项目发展到一个阶段在去掌握估计或者在面试中提及，就会给自己带来不小的困扰，在当今这个时代这些技术也并不是什么新鲜的东西，如果去掌握和挖掘最关键的还是自己花时间和经历去探讨和研究。

## 2. 中间件技术及架构的概述

![中间件技术](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/%E4%B8%AD%E9%97%B4%E4%BB%B6%E6%8A%80%E6%9C%AF.png)

> 学习中间件的方式和技巧

1. 理解中间件在项目架构中的作用，以及各中间件的底层实现
2. 可以使用一些类比的生活概念去理解中间件
3. 使用一些流程图或者脑图的方式去梳理各个中间件在架构中的作用
4. 尝试用 java技术去实现中间件的原理
5. 静下来去思考中间件在项目中设计的和使用的原因
6. 如果找到对应的代替总结方案
7. 尝试编写博文总结类同中间件技术的对比和使用场景
8. 学会查看中间件的源码以及开源项目和博文

> 什么是消息中间件

在实际的项目中，大部分的企业项目开发中，在早起都采用的是单体的架构模式

![4](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/4.jpg)

> 单体架构

在企业开发当中，大部分的初期架构都采用的是单体架构的模式进行架构，而这种架构的典型的特点：就是把所有的业务和模块，源代码，静态资源文件等都放在一个工程中，如果其中的一个模块升级或者迭代发生一个很小的变动都会重新编译和重新部署项目。这种这狗存在的问题是：

1. 耦合度太高
2. 不易维护
3. 服务器的成本高
4. 以及升级架构的复杂度也会增大

这样就有后续的分布式架构系统。如下

> 分布式架构

![5](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/5.jpg)

**何谓分布式系统：**

> 通俗一点：就是一个请求由服务器端的多个服务（服务或者系统）协同处理完成

和单体架构不同的是，单体架构是一个请求发起 jvm调度线程（确切的是 tomcat线程池）分配线程 Thread来处理请求直到释放，而分布式系统是：一个请求时由多个系统共同来协同完成，jvm和环境都可能是独立。如果生活中的比喻的话，单体架构就像建设一个小房子很快就能够搞定，如果你要建设一个鸟巢或者大型的建筑，你就必须是各个环节的协同和分布，这样目的也是项目发展到后期的时候要去部署和思考的问题。我们也不难看出来：分布式架构系统存在的特点和问题如下：

**存在问题：**

1. 学习成本高，技术栈过多
2. 运维成本和服务器成本增高
3. 人员的成本也会增高
4. 项目的负载度也会上升
5. 面临的错误和容错性也会成倍增加
6. 占用的服务器端口和通讯的选择的成本高
7. 安全性的考虑和因素逼迫可能选择 RMI/MQ相关的服务器端通讯

**好处：**

1. 服务系统的独立，占用的服务器资源减少和占用的硬件成本减少，确切的说是：可以合理的分配服务资
2. 源，不造成服务器资源的浪费
3. 系统的独立维护和部署，耦合度降低，可插拔性
4. 系统的架构和技术栈的选择可以变的灵活（而不是单纯地选择 java）
5. 弹性的部署，不会造成平台因部署造成的瘫痪和停服的状态

## 3. 基于消息中间件的分布式系统的架构

![image-20210721232346951](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210721232346951.png)

从上图中可以看出来，消息中间件的作用是

1. 利用可靠的消息传递机制进行系统和系统直接的通讯
2. 通过提供消息传递和消息的派对机制，它可以在分布式系统环境下扩展进程间的通讯

> 消息中间件应用的场景

1. 跨系统数据传递
2. 高并发的流量削峰
3. 数据的并发和异步处理
4. 大数据分析与传递
5. 分布式事务比如你有一个数据要进行迁移或者请求并发过多的时候，

比如你有10 W的并发请求下订单，我们可以在这些订单入库之前，我们可以把订单请求堆积到消息队列中，让它稳健可靠的入库和执行

![image-20210721233205286](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210721233205286.png)

> 常见的消息中间件

ActiveMQ、RabbitMQ、Kafka、RocketMQ等

> 消息中间件的本质及设计

它是一种接受数据、接受请求、存储数据、发送数据等功能的技术服务

MQ消息队列：负责数据的传接受，存储和传递，所以性能要高于普通服务和技术

![image-20210721233326368](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210721233326368.png)

谁来生产消息，存储消息和消费消息呢？

![image-20210721233345543](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210721233345543.png)

> 消息中间件的核心组成部分

消息的协议
消息的持久化机制
消息的分发策略
消息的高可用，高可靠
消息的容错机制

> 小结

其实不论选择单体架构还是分布式架构都是项目开发的一个阶段，在什么阶段选择合适的架构方式，而不能盲目追求，最后造成的后果和问题都需要自己买单。但作为一个开发人员学习和探讨新的技术使我们每个程序开发者都应该去保持和思考的问题。当我们没办法去改变社会和世界的时候，我们为了生活和生存那就必须要迎合企业和市场的需求，发挥你的价值和所学的才能，创造价值和实现自我



## 4. 消息队列协议

> 什么是协议

![image-20210721233630089](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210721233630089.png)

所谓协议是指：

1. 计算机底层操作系统和应用程序通讯时共同遵守的一组约定，只有遵循共同的约定和规范，系统和底层操作系统之间才能相互交流
2. 和一般的网络应用程序的不同它主要负责数据的接受和传递，所以性能比较的高
3. 协议对数据格式和计算机之间交换数据都必须严格遵守规范

> 网络协议的三要素

1. 语法：语法是用户数据与控制信息的结构与格式，以及数据出现的顺序
2. 语义：语义是解释控制信息每个部分的意义，它规定了需要发出何种控制信息，以及完成的动作与做出什么样的响应
3. 时序：时序是对事件发生顺序的详细说明

比如我 MQ发送一个信息，是以什么数据格式发送到队列中，然后每个部分的含义是什么，发送完毕以后的执行的动作，以及消费者消费消息的动作，消费完毕的相应结构和反馈是什么，然后按照对应的执行顺序进行处理。如果你还是不理解：大家每天都在接触的 http请求协议：

1. 语法：http规定了请求报文和响应报文的格式
2. 语义：客户端主动发起请求称之为请求（这是一种定义，同时你发起的是 post/get请求）
3. 时序：一个请求对应一个响应（一定先有请求在有响应，这个是时序）

而消息中间件采用的并不是 http协议，而常见的消息中间件协议有有：OpenWire、AMQP、MQTT、Kafka，OpenMessage协议

**面试题：为什么消息中间件不直接使用 http协议**

1. 因为 http请求报文头和响应报文头是比较复杂的，包含了Cookie，数据的加密解密，窗台吗，响应码等附加的功能，但是对于一个消息而言，我们并不需要这么复杂，也没有这个必要性，它其实就是负责数据传递，存储，分发就行，一定要追求的是高性能。尽量简洁，快速。
2. 大部分情况下 http大部分都是短链接，在实际的交互过程中，一个请求到响应都很有可能会中断，中断以后就不会执行持久化，就会造成请求的丢失。这样就不利于消息中间件的业务场景，因为消息中间件可能是一个长期的获取信息的过程，出现问题和故障要对数据或消息执行持久化等，目的是为了保证消息和数据的高可靠和稳健的运行。

> AMQP协议

AMQP：（全称：Advanced Message Queuing Protocol）是高级消息队列协议。由摩根大通集团联合其他公司共同设计。是一个提供统一消息服务的应用层标准高级消息队列协议，是应用层协议的一个开放标准，为面向消息的中间件设计。基于此协议的客户端与消息中间件可传递消息，并不受客户端/中间件不同产品，不同的开发语言等条件的限制。Erlang中的实现由 RabbitMQ等

特性：

1. 分布式事务支持
2. 消息的持久化支持
3. 高性能和高可靠的消息处理优势

![image-20210722001512470](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722001512470.png)

> MQTT协议

MQTT协议（Message Queueing Telemetry Transport）消息队列是 IBM开放的及时通讯协议，物联网系统架构中的重要组成部分

特点：

1. 轻量
2. 结构简单
3. 传输快，不支持事务
4. 没有持久化设计

应用场景：

1. 适用于计算能力有限
2. 低带宽
3. 网络不稳定的场景

支持者（但默认关闭）：

![image-20210722001559614](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722001559614.png)

> OpenMessage协议

![image-20210722001856325](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722001856325.png)

是近几年由阿里、雅虎和滴滴出行、Stremalio等公司共同参与创立的分布式信息中间件、流处理等领域的应用开发标准

特点：

1. 结构简单
2. 解析速度快
3. 支持事务和持久化设计

> Kafka协议

![image-20210722002005918](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722002005918.png)

Kafka协议是基于 TCP/IP的二进制协议。消息内部是 通过长度来分割，由一些基本数据类型组成

特点：

1. 结构简单
2. 解析速度快
3. 无事务支持
4. 有持久化设计

> 小结

协议：实在 tcp/ip协议基础之上构建的一种约定俗称的规范和机制、它的主要目的可以让客户端（应用程序 java，go）进行沟通和通讯。并且这种写一下规范必须具有持久性，高可用，高可靠的性能

## 5. 消息队列持久化

> 持久化

简单来说就是将数据存入磁盘，而不是存在内存中随服务器重启断开而消失，使数据能够永久保存

![image-20210722002155814](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722002155814.png)

> 常见的持久化方式

|          | ActiveMQ | RabbitMQ | Kafka | RocketMQ |
| -------- | -------- | -------- | ----- | -------- |
| 文件存储 | 支持     | 支持     | 支持  | 支持     |
| 数据库   | 支持     | /        | /     | /        |



## 6. 消息的分发策略

> 消息的分发策略

MQ消息 队列有如下几个角色

1. 生产者
2. 存储消息
3. 消费者

那么生产者生成消息以后，MQ进行存储，消费者是如何获取消息的呢？一般获取数据的方式无外乎推（push）或者拉（pull）两种方式，典型的 git就有推拉机制，我们发送的 http请求就是一种典型的拉取数据库数据返回的过程。而消息队列 MQ是一种推送的过程，而这些推机制会使用到很多的业务场景也有很多对应推机制策略

> 场景分析一

![image-20210722215557648](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722215557648.png)

 在发送消息的过程中可能会出现异常，或者网络的抖动，故障等等因为造成消息的无法消费，比如用户在下订单，消费MQ接受，订单系统出现故障，导致用户支付失败，那么这个时候就需要消息中间件就必须支持消息重试机制策略。也就是支持：出现问题或故障的情况下，消息不丢失还可以进行重发。

> 场景分析二

比如我在 APP上下了一个订单，我们的系统和服务很多，我们如何得知这个消息被哪个系统或者哪些服务器或者系统进行消费，那这个时候就需要一个分发的策略。这就需要消费策略。或者称之为消费的方法论

> 消息分发策略的机制和对比

![image-20210722220229070](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210722220229070.png)



## 7. 消息队列高可用和高可靠

> 什么是高可用机制

所谓高可用：是指产品在规定的条件和规定的时刻或时间内处于可执行规定功能状态的能力

当业务量增加时，请求也过大，一台消息中间件服务器的会触及硬件（CPU，内存，磁盘）的极限，一台消息服务器你已经无法满足业务的需求，所以消息中间件必须支持集群部署，来达到高可用的目的

> 集群模式1 - Master-slave主从共享数据的部署方式

![image-20210723003022031](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210723003022031.png)

> 集群模式2 - Master-slave主从同步部署方式

![image-20210723003212812](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210723003212812.png)

解释：这种模式写入消息同样在 Master主节点上，但是主节点会同步数据到 slave节点形成副本，和 zookeeper或者 redis主从机制很雷同。这样可以达到负载均衡的效果，如果消费者有多个这样就可以去不同的节点进行消费，以为消息的拷贝和同步会占用很大的带宽和网络资源。在后去的 rabbitmq中会有使用

> 集群模式3 - 多主集群同步部署模式

![image-20210723003404732](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210723003404732.png)

解释：和上面的区别不是特别的大，但是它的写入可以往任意节点去写入

> 集群模式4 - 多主集群转发部署模式

![image-20210723003446062](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210723003446062.png)

解释：如果你插入的数据是 broker-1中，元数据信息会存储数据的相关描述和记录存放的位置（队列）。它会对描述信息也就是元数据信息进行同步，如果消费者在 broker-2中进行消费，发现自己节点没有对应的信息，可以从对应的元数据信息中去查询，然后返回对应的消息信息，场景：比如买火车票或者黄牛买演唱会门票，比如第一个黄牛有顾客说要买的演唱会门票，但是没有但是他回去联系其他的黄牛询问，如果有就返回

> 集群模式5 Master-slave与 Broker-cluster组合的方案

![image-20210723003745786](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210723003745786.png)

解释：实现多主多从的热备机制来完成消息的高可用以及数据的热备机制，在生产规模达到一定的阶段的时候，这种使用的频率比较高

> 什么是高可靠机制

所谓高可靠是指：系统可以无故障低持续运行，比如一个系统突然崩溃，报错，异常等等并不影响线上业务的正常运行，出错的几率极低，就称之为：高可靠

在高并发的业务场景中，如果不能保证系统的高可靠，那造成的隐患和损失是非常严重的

如何保证中间件消息的可靠性呢，可以从两个方面考虑：

1. 消息的传输：通过协议来保证系统间数据解析的正确性
2. 消息的存储区可靠：通过持久化来保证消息的可靠性

# 二、入门及安装

## 1. RabbitMQ入门及安装

### ubuntu安装

[ Ubuntu20.04上安装RabbitMQ](https://blog.csdn.net/qq_37296487/article/details/108311148)

可以使用Shell脚本安装：

> ①创建install.sh脚本文件

```shell
#!/bin/sh

## If sudo is not available on the system,
## uncomment the line below to install it
# apt-get install -y sudo

sudo apt-get update -y

## Install prerequisites
sudo apt-get install curl gnupg -y

## Install RabbitMQ signing key
curl -fsSL https://github.com/rabbitmq/signing-keys/releases/download/2.0/rabbitmq-release-signing-key.asc | sudo apt-key add -

## Install apt HTTPS transport
sudo apt-get install apt-transport-https

## Add Bintray repositories that provision latest RabbitMQ and Erlang 23.x releases
## 这里是Ubuntu18.04系统
sudo tee /etc/apt/sources.list.d/bintray.rabbitmq.list <<EOF
## Installs the latest Erlang 23.x release.
## Change component to "erlang-22.x" to install the latest 22.x version.
## "bionic" as distribution name should work for any later Ubuntu or Debian release.
## See the release to distribution mapping table in RabbitMQ doc guides to learn more.
deb https://dl.bintray.com/rabbitmq-erlang/debian bionic erlang
## Installs latest RabbitMQ release
deb https://dl.bintray.com/rabbitmq/debian bionic main
EOF

## Update package indices
sudo apt-get update -y

## Install rabbitmq-server and its dependencies
sudo apt-get install rabbitmq-server -y --fix-missing
```

> ②授予权限

```shell
chmod +x install.sh
```

> ③运行脚本

```shell
./install.sh
```

![image-20210725223017203](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725223017203.png)

> ④验证erlang下载成功

```bash
erl -v
```

![image-20210725223136775](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725223136775.png)

> ⑤启动

```shell
# 启动管理界面和外部监控系统
sudo rabbitmq-plugins enable rabbitmq_management
# 启动RabbitMQ
sudo service rabbitmq-server start
# 查看状态
sudo service rabbitmq-server status
```

![image-20210725223109212](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725223109212.png)

![image-20210725223047230](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725223047230.png)

> ⑥开放端口

```shell
# 查看已经开启的端口
sudo ufw status
# 打开端口
sudo ufw allow 15672	# 图形界面使用
sudo ufw allow 5672		# 之后写代码连接服务使用
# 开启防火墙
sudo ufw enable
# 重启防火墙
sudo ufw reload
```

![image-20210725223527049](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725223527049.png)

> ⑦ 授权账号

```shell
# 增加账号密码
sudo rabbitmqctl add_user admin admin
# 设置用户分配操作权限
sudo rabbitmqctl set_user_tags admin administrator
# 为用户添加资源权限，上面已经授予administrator所有权限，可以不执行下面的命令
sudo rabbitmqctl set_permissions -p / admin ".*"".*"".*"
# 其他命令
sudo rabbitmqctl change_password [账号] [新密码]	# 修改密码
sudo rabbitmqctl delete_user [账号]	# 删除用户
sudo rabbitmqctl list_users	# 查看用户清单
```

![image-20210725224030037](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725224030037.png)

用户级别：

1. administrator：可以登录控制台、查看所有信息、可以对 rabbitmq进行管理
2. monitoring：监控者 登录控制台，查看所有信息
3. policymaker：策略制定者 登录控制台，指定策略
4. managment 普通管理员 登录控制台

> ⑧登录网站

![image-20210725224339783](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725224339783.png)

## 2. RabbitMQ的角色分类

1. none
   + 不能访问management plugin
2. management：查看自己相关节点信息
   + 列出自己可以通过AMQP登入的虚拟机
   + 查看自己的虚拟机节点virtual hosts的queues、exchanges和bindings信息
   + 查看和关闭自己的channels和connections
   + 查看有关自己的虚拟机节点virtual hosts的统计信息。包括其他用户在这个节点virtual hosts中的活动信息。
3. Policymaker
   + 包含management的所有权限
   + 查看、创建和删除自己的virtual hosts所属的policies和parameters信息。
4. Monitoring
   + 包含management的所有权限
   + 罗列出所有的virtual hosts，包括不能登录的virtual hosts。
   + 查看其他用户的connections和channels信息
   + 查看节点级别的数据如clustering和memory使用情况
   + 查看所有的virtual hosts的全局统计信息
5. Administor
   + 最高权限
   + 可以创建和删除virtual hosts
   + 可以查看、创建和删除users
   + 查看创建permissions
   + 关闭所有用户的connections



# 三、入门案例

## 1. RabbitMQ入门案例 - Simple 简单模式

1. jdk1.8
2. 构建一个 maven工程
3. 导入 rabbitmq的 maven依赖
4. 启动 rabbitmq-server服务
5. 定义生产者
6. 定义消费者
7. 观察消息的在 rabbitmq-server服务中的进程

### 01 构建一个maven工程

![image-20210725231848886](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210725231848886.png)

### 02 导入依赖

> java原生依赖

```xml
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>5.10.0</version>
</dependency>
```

### 03 第一种模型

![image-20210727223327613](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727223327613.png)

在上图的模型中，有以下概念：

1. 生产者，也就是要发送消息的程序
2. 消费者：消息的接受者，会一直等待消息到来。
3. 消息队列：图中红色部分。类似一个邮箱，可以缓存消息；生产者向其中投递消息，消费者从其中取出消息。

> 生产者

```java
package com.arlin.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Producer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/25
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.102");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection("生产者");
        //2.创建通道
        Channel channel = connection.createChannel();
        //3.通过创建交换机，声明队列，绑定关系，路由key，发送消息和接受消息
        /*
         * @params1：队列名称
         * @params2：是否持久化，非持久化消息会存盘吗？会存盘，但是会随着重启服务器而丢失
         * @params3：是否独占队列
         * @params4：是否自动删除，随着最后一个消费者消息完毕消息以后是否把队列自动删除
         * @params5：携带附属属性
         */
        String queueName = "queue1";
        channel.queueDeclare(queueName,false,false,false,null);
        //4.发送消息给队列queue
        /*
         * @params1：交换机
         * @params2：队列、路由key
         * @params3：消息的状态控制
         * @params4：消息主题
         */
        //面试题：可以存在没有交换机的队列吗？不可能，虽然没有指定交换机但是一定会存在一个默认的交换机
        String message = "Hello";
        channel.basicPublish("",message, null,message.getBytes());
        //5.关闭
        channel.close();
        connection.close();
    }
}

```

> 消费者

```java
package com.arlin.rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/25
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.15.0.9");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection("生产者");
        //2.创建通道
        Channel channel = connection.createChannel();
        //3.接受内容
        channel.basicConsume("queue1", true, new DeliverCallback() {
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("收到消息是" + new String(message.getBody(), "UTF-8"));
            }
        }, new CancelCallback() {
            public void handle(String consumerTag) throws IOException {
                System.out.println("接受失败了");
            }
        });
        //4.关闭
        channel.close();
        connection.close();
    }
}
```



## 2. 什么是AMQP

### 01 什么是AMQP

AMQP全称：Advanced Message Queuing Protocol（高级消息队列协议）。是应用层协议的一个开发标准，为面向消息的中间件设计

### 02 AMQP生产者流转过程

![image-20210726232717970](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726232717970.png)

### 03 AMQP消费者流转过程

![image-20210726232818628](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726232818628.png)



## 3. RabbitMQ的核心组成部分

### 01 RabbitMQ的核心组成部分

![image-20210726233115147](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726233115147.png)

核心概念：

**Server**：又称Broker，接受客户端的连接，实现AMQP实体服务。安装rabbitmq-server。

**Connection**：连接，应用程序与Broker的网络连接TCP/IP/三次握手和四次挥手。

**Channel**：网络信道，几乎所有的操作都在Channel中进行，Channel是进行消息读写的通道，客户端可以建立Channel，每个channel代表一个会话任务。

**Message**：消息，服务与应用程序之间传达的数据，由Properties和body组成，Properties可以对消息进行修饰，比如消息的优先级，延迟等高级特性，Body则就是消息体的内容。

**Virtual Host**：虚拟地址，用于进行逻辑隔离。最上层的消息路由，一个虚拟主机可以有若干个Exchange和Queue，同一个虚拟主机里面不能有相同名字的Exchange。

**Exchange**：交换机，接受消息，根据路由键发送消息到绑定的队列（不具备消息存储的能力）。

**Bindings**：Exchange和Queue之间的虚拟连接，binding中可以保护多个routing key。

**Routing Key**：是一个路由规则，虚拟机可以用它来确定如何路由一个特定消息。

**Queue**：队列，也称为Message Queue消息队列，保存消息并将它们转发给消费者。

### 02 RabbitMQ整体架构是什么样子的？

![image-20210726235145923](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726235145923.png)

### 03 RabbitMQ的运行流程

![image-20210726235315429](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726235315429.png)

### 04 RabbitMQ支持的消息模型

参考官网：[RabbitMQ Tutorials — RabbitMQ](https://www.rabbitmq.com/getstarted.html)

![image-20210726235603265](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726235603265.png)

![image-20210726235614839](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210726235614839.png)

1. 简单模式 Simple
2. 工作模式 Work
3. 发布订阅模式
4. 路由模式
5. 主题 Topic模式
6. RPC模式
7. 发布确认

## 4. RabbitMQ入门案例 - fanout 模式

### 01 RabbitMQ的模式之发布订阅模式

> 图解

![image-20210727223248488](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727223248488.png)

**发布订阅模式的具体实现**

1. web操作查看视频
2. 类型：fanout
3. 特点：Fanout - 发布与订阅模式，是一种广播机制，它是没有路由 key的模式



TODO



## 8. RabbitMQ使用场景

### 01 解耦、削峰、异步

> 同步异步的问题（串行）

串行方式：将订单信息写入数据库成功后，发送注册邮件，再发送注册短信。以上三个任务全部完成后，返回给客户端

![image-20210727232757863](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727232757863.png)

```java
public void makeOrder(){
    //1.发送订单
    //2.发送短信服务
    //3.发送email服务
    //4.发送app服务
}
```

> 并行方式 异步线程池

并行方式：将订单信息写入数据库成功后，发送注册邮件的同时，发送注册短信。以上三个任务完成后，返回给客户端。与串行的差别是，并行的方式可以提高处理的时间

![image-20210727232912037](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727232912037.png)

```java
public void test(){
    //异步
    //1.发送订单
    theadpool.submit(new Callable<Object>{
        //2.发送短信服务
    })
    //异步
    theadpool.submit(new Callable<Object>{
        //3.发送email服务
    })
    //异步
    theadpool.submit(new Callable<Object>{
        //4.发送app服务
    })
}
```

存在问题

1. 耦合度高
2. 需要自己写线程池自己维护成本太高
3. 出现了消息可能会丢失，需要你自己做消息补偿
4. 如何保证消息的可靠性你自己写
5. 如果服务器承载不了，你需要自己去写高可用

> 异步消息队列的方式

![image-20210727233258168](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727233258168.png)

好处：

1. 完全解耦，用 MQ建立桥接
2. 有独立的线程池和运行模型
3. 出现了消息可能会丢失，MQ有持久化功能
4. 如何保证消息的可靠性，死信队列和消息转移等
5. 如果服务器承载不了，你需要自己去写高可用，HA镜像模型高可用

按照以上约定，用户的响应时间相当于是订单信息写入数据库的时间，也就是50毫秒。注册邮件，发送短信写入消息队列后，直接返回，因此写入消息队列的速度很快，基本可以忽略，因此用户的响应时间可能是50毫秒。因此架构改变后，系统的吞吐量提高到每秒20QPS。比串行提高了3倍，比并行提高了两倍

### 02 高内聚，低耦合

![image-20210727233348590](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727233348590.png)

### 03 流量的削峰

![image-20210727233446089](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727233446089.png)

好处：

1. 完全解耦，用 MQ建立桥接
2. 有独立的线程池和运行模型
3. 出现了消息可能会丢失，MQ有持久化功能
4. 如何保证消息的可靠性，死信队列和消息转移等
5. 如果服务器承载不了，你需要自己去写高可用，HA镜像模型高可用

按照以上约定，用户的响应时间相当于是订单信息写入数据库的时间，也就是50毫秒。注册邮件，发送短信写入消息队列后，直接返回，因此写入消息队列的速度很快，基本可以忽略，因此用户的响应时间可能是50毫秒。因此架构改变后，系统的吞吐量提高到每秒20QPS。比串行提高了3倍，比并行提高了两倍

# 四、Springboot案例

## 1. Fanout 模式

![image-20210727235135070](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210727235135070.png)

> 生产者

**application.yaml**

```yaml
server:
  port: 8080

spring:
  rabbitmq:
    username: admin
    password: admin
    virtual-host: /
    host: 192.168.1.102
    port: 5672
```

**FanoutConfig**配置类

```java
package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FanoutConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/27
 */
@Configuration
public class FanoutConfig {

    /**
     * 声明注册fanout模式的交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    /**
     * 声明队列 sms.fanout.queue email.fanout.queue note.fanout.queue
     */
    @Bean
    public Queue smsQueueFanout() {
        return new Queue("sms.fanout.queue");
    }
    @Bean
    public Queue emailQueueFanout() {
        return new Queue("email.fanout.queue");
    }
    @Bean
    public Queue noteQueueFanout() {
        return new Queue("note.fanout.queue");
    }

    /**
     * 完成绑定关系
     */
    @Bean
    public Binding smsBindingFanout() {
        return BindingBuilder.bind(smsQueueFanout()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBindingFanout() {
        return BindingBuilder.bind(emailQueueFanout()).to(fanoutExchange());
    }
    @Bean
    public Binding noteBindingFanout() {
        return BindingBuilder.bind(noteQueueFanout()).to(fanoutExchange());
    }
}

```

**OrderService**订单服务

```java
package com.arlin.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/27
 */
@Service
public class OrderService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 模拟用户下单
     *
     * @param userId
     * @param productId
     * @param num
     */
    public void makeOrder(String exchangeName, String routingKey, String userId, String productId, int num) {
        //1.根据商品id查询库存是否足够
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功：" + orderId);
        //3.通过MQ来完成消息的分发
        //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

}

```

测试：

```java
@SpringBootTest
class ProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("fanout_order_exchange", "", "user", "product", 12);
    }
}
```

成功发送消息

> 消费者

相同的配置

**FanoutEmailConsumer**

```java
package com.arlin.servcice.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FanoutEmailConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"email.fanout.queue"})
@Service
public class FanoutEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email.fanout.queue---接收到订单消息-->" + message);
    }
}
```

**FanoutNoteConsumer**

```java
package com.arlin.servcice.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FanoutNoteConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"note.fanout.queue"})
@Service
public class FanoutNoteConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("note.fanout.queue---接收到订单消息-->" + message);
    }
}
```

**FanoutSMSConsumer**

```java
package com.arlin.servcice.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FanoutSMSConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"sms.fanout.queue"})
@Service
public class FanoutSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms.fanout.queue---接收到订单消息-->" + message);
    }
}
```

> 所有队列都能收到消息

## 2. Direct 模式

> 生产者

**DirectConfig**配置类

```java
package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitMqConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/27
 */
@Configuration
public class DirectConfig {

    /**
     * 声明注册direct模式的交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    /**
     * 声明队列 sms.direct.queue email.direct.queue note.direct.queue
     */
    @Bean
    public Queue smsQueueDirect() {
        return new Queue("sms.direct.queue");
    }
    @Bean
    public Queue emailQueueDirect() {
        return new Queue("email.direct.queue");
    }
    @Bean
    public Queue noteQueueDirect() {
        return new Queue("note.direct.queue");
    }

    /**
     * 完成绑定关系
     */
    @Bean
    public Binding smsBindingDirect() {
        return BindingBuilder.bind(smsQueueDirect()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding emailBindingDirect() {
        return BindingBuilder.bind(emailQueueDirect()).to(directExchange()).with("email");
    }
    @Bean
    public Binding noteBindingDirect() {
        return BindingBuilder.bind(noteQueueDirect()).to(directExchange()).with("note");
    }
}
```

测试：

```java
package com.arlin;

import com.arlin.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("direct_order_exchange", "sms", "user", "product", 12);
    }

}
```



> 消费者

**DirectEmailConsumer**

```java
package com.arlin.servcice.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DirectEmailConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"email.direct.queue"})
@Service
public class DirectEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email.direct.queue---接收到订单消息-->" + message);
    }
}
```

**DirectNoteConsumer**

```java
package com.arlin.servcice.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DirectNoteConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"note.direct.queue"})
@Service
public class DirectNoteConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("note.direct.queue---接收到订单消息-->" + message);
    }
}
```

**DirectSMSConsumer**

```java
package com.arlin.servcice.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DirectSMSConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@RabbitListener(queues = {"sms.direct.queue"})
@Service
public class DirectSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms.direct.queue---接收到订单消息-->" + message);
    }
}
```

> 消息发送到sms

## 3. Topic 模式

> 消费者

用注解的方式绑定交换机和队列以及key

**TopicEmailConsumer**

```java
package com.arlin.servcice.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TopicEmailConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "*.email.#"
))
public class TopicEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email.topic.queue---接收到订单消息-->" + message);
    }
}
```

**TopicNoteConsumer**

```java
package com.arlin.servcice.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TopicNoteConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "note.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "#.note.#"
))
public class TopicNoteConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("note.topic.queue---接收到订单消息-->" + message);
    }
}
```

**TopicSMSConsumer**

```java
package com.arlin.servcice.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TopicSMSConsumer
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/28
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "com.#"
))
public class TopicSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms.topic.queue---接收到订单消息-->" + message);
    }
}
```

> 生产者

测试：

```
package com.arlin;

import com.arlin.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("topic_order_exchange", "com.email", "user", "product", 12);
    }

}
```

> 消息发送到sms和email



# 五、RabbitMQ高级

## 1.  过期时间TTL

> 概述

过期时间 TTl表示可以对消息设置预期的时间，在这个时间内都可以被消费者接收获取；过了之后消息将自动被删除。RabbitMQ可以对消息和队列设置 TTL，目前有两种方法可以设置

1. 第一种方法是通过队列属性设置，队列中所有消息都有相同的过期时间
2. 第二种方法是对消息进行单独设置，每条消息 TTL可以不同

如果上述两种方法同时使用，则消息的过期时间以两者 TTL较小的那个数值为准。消息在队列的生存时间一旦超过设置的 TTL值，就称为 dead message被投递到死信队列，消费者将无法再收到该消息

> 设置队列TTL

**TTLConfig**配置类

```java
package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TTLConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/7/29
 */
@Configuration
public class TTLConfig {

    /**
     * 声明注册direct模式的交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directTTLExchange() {
        return new DirectExchange("ttl_order_exchange", true, false);
    }

    // 队列的过期时间
    @Bean
    public Queue directTTLQueue() {
        //设置过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        return new Queue("ttl.direct.queue", true, false, false, args);
    }

    @Bean
    public Binding ttlBingding() {
        return BindingBuilder.bind(directTTLQueue()).to(directTTLExchange()).with("ttl");
    }
}
```

测试：

```java
@Test
void contextLoads() {
    orderService.makeOrder("ttl_order_exchange", "ttl", "user", "product", 12);
}
```

产生交换机和队列，并且有TTL标识，消息5秒后自动消失

![image-20210729233219583](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210729233219583.png)

![image-20210729233205975](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210729233205975.png)



> 设置消息TTL

TTLConfig配置文件中添加

```java
@Bean
public Queue directTTLMessageQueue() {
    return new Queue("ttl.direct.message.queue", true);
}

@Bean
    public Binding ttlMessageBingding() {
        return BindingBuilder.bind(directTTLMessageQueue()).to(directTTLExchange()).with("ttl_message");
    }
```

测试：

```java
public void makeTTLMessageOrder(String exchangeName, String routingKey, String userId, String productId, int num) {
    //1.根据商品id查询库存是否足够
    //2.保存订单
    String orderId = UUID.randomUUID().toString();
    System.out.println("订单生产成功：" + orderId);

    MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
        @Override
        public Message postProcessMessage(Message message) throws AmqpException {
            message.getMessageProperties().setExpiration("5000");   //设置消息过期时间
            message.getMessageProperties().setContentEncoding("UTF-8"); //设置编码
            return message;
        }
    };

    //3.通过MQ来完成消息的分发
    //参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
    rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId, messagePostProcessor);
}
```

```java
@Test
void contextLoads() {
    orderService.makeTTLMessageOrder("ttl_order_exchange", "ttl_message", "user", "product", 12);
}
```

消息生成5秒后消失，队列没有TTL标识

![image-20210729234657295](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210729234657295.png)



## 2. 死信队列

> 概述

DLX，全称 `Dead-Letter-Exchange`，可以称之为死信交换机，也有人称之为死信邮箱。当消息再一个队列中变成死信之后，它能被重新发送到另一个交换机中，这个交换机就是 DLX，绑定 DLX的队列就称之为死信队列。消息变成死信，可能是由于以下原因：

1. 消息被拒绝
2. 消息过期
3. 队列达到最大长度

DLX也是一个正常的交换机，和一般的交换机没有区别，它能在任何的队列上被指定，实际上就是设置某一个队列的属性，当这个队列中存在死信时，Rabbitmq就会自动地将这个消息重新发布到设置的 DLX上去，进而被路由到另一个队列，即死信队列。

要想使用死信队列，只需要在定义队列的时候设置队列参数`x-dead-letter-exchange`指定交换机即可

![image-20210801230025471](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210801230025471.png)

> 以消息过期为例，代码：

**DeadConfig**：死信队列配置类

```java
package com.arlin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: DeadConfig
 * @Description: TODO
 * @Author: arlin
 * @Date: 2021/8/1
 */
@Configuration
public class DeadConfig {

    /**
     * 声明注册direct模式的死信队列的交换机
     * @return
     */
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange("dead_order_exchange", true, false);
    }

    /**
     * 声明队列 dead.direct.queue
     */
    @Bean
    public Queue deadQueue() {
        return new Queue("dead.direct.queue", true);
    }

    /**
     * 完成绑定关系
     */
    @Bean
    public Binding deadBindingDirect() {
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("dead");
    }

}
```

将过期队列也重新设置下，这时需要删除之前的过期队列才能成功运行，因为队列重新设置并不能实时变更。注意正式开发应该新建一个过期队列而不是删除队列。

```java
@Bean
public Queue directTTLQueue() {
    //设置过期时间
    Map<String, Object> args = new HashMap<>();
    args.put("x-message-ttl", 5000);
    args.put("x-dead-letter-exchange", "dead_order_exchange");
    args.put("x-dead-letter-routing-key", "dead");  //fanout模式不需要配置
    return new Queue("ttl.direct.queue", true, false, false, args);
}
```

测试：

```java
@Test
void contextLoads() {
	orderService.makeOrder("ttl_order_exchange", "ttl", "user", "product", 12); 
}
```

将消息发送到过期队列中，当5秒后消息自动转发到死信队列中。

![image-20210801225912864](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210801225912864.png)

![image-20210801230438686](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210801230438686.png)

## 3. 内存磁盘的监控

###  01 RabbitMQ内存警告 

当出现blocking或blocked时说明到达了阈值以及高负荷运行了

### 02 RabbitMQ的内存控制

参考帮助文档：`http://www.rabbbitmq.com/configure.html`

当出现警告的时候，可以通过配置去修改和调整

> 命令的方式，相对值与绝对值二选一

```shell
rabbitmqctl set_vm_memory_high_watermark <fraction>
rabbitmqctl set_vm_memory_high_watermark absolute 50MB
```

fraction/value 为内存阈值。默认情况是：0.4/2GB，代表的含义是：当 RabbitMQ的内存超过40%时，就会产生警告并且会阻塞所有生产者的连接。通过此命令修改阈值在 Broker重启以后将会失效，通过修改配置文件设置的阈值则不会随着重启而消失，但修改了配置文件一样要重启 Broker才会生效

> 配置文件方式 rabbitmq.conf

![image-20210801233755498](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210801233755498.png)



### 03 RabbitMQ的内存换页

在某个Broken节点及内存阻塞生产者之前，他会尝试将队列中的消息换页到磁盘以释放空间，持久化和非持久化的消息都会写入磁盘中，其中持久化的消息本身就在磁盘中有一个副本，所以在转换的过程中持久化的消息会先从内存中消除掉。

> 默认情况下，内存到达的阈值是50%就会换页处理。也就是说，在默认情况下改内存的阈值时0.4的情况下，当内存超过了0.4*0.5=0.2时，就会进行换页动作。

比如有1000MB内存，当内存的使用率达到了400MB，已经达到了极限，但是因为配置的换页内存0.5，这个时候会在达到极限400MB之前把内存的200MB进行转换到磁盘中。从而达到稳健的运行。

可以通过设置`vm_memory_high_watemark_paging_ratio`来进行调整

```shell
vm_memory_high_watermark.relative = 0.4
vm_memory_high_watermark_paging_ratio = 0.7 (设置小于1的值)
```

> 为什么设置小于1，因为如果设置为1的阈值，内存已经达到极限再换页的意义不大了。

### 04 RabbitMQ的磁盘预警

当磁盘的剩余空间低于确定的阈值时，RabbitMQ同样会阻塞生产者，这样可以避免因非持久化的消息持续换页而耗尽磁盘空间导致服务器奔溃。

> 默认情况下：磁盘预警为50MB的时候会进行预警。表示当前磁盘空间第50MB的时候会阻塞生产者并且停止内存消息换页到磁盘的过程。
>
> 这个阈值可以减少，但是不能完全的消除因磁盘耗尽而导致的奔溃的可能性。比如在两次磁盘空间的检查空隙内，第一次检查是50MB，第二次检查可能就是1MB，就会出现警告。

通过命令的方式修改如下：

```shell
rabbitmqctl set_disk_free_limit <disk_limit>
rabbitmqctl set_disk_free_limit memory_limit <fraction>
```

通过配置文件配置如下：

```shell
disk_free_limit.relative = 3.0
disk_free_limit.absolute = 50mb
```



## 4.  集群

RabbitMO这款消息队列中间件产品本身是基于 Erlang编写，Erlang语言天生具备分布式特性（通过同步 Erlang集群各节点的 magic cookie来实现）。因此，RabbitMQ天然支持 Clustering。这使得 RabbitMQ本身不需要像 ActiveMQ、Kafka那样通过 ZooKeeper分别来实现HA方案和保存集群的元数据。集群是保证可靠性的一种方式，同时可以通过水平扩展以达到增加消息吞吐量能力的目的。

### 01 集群搭建

配置的前提是你的 rabbitmq可以运行起来，比如`ps aix|grep rabbitmq`你能看到相关进程，又比如运行`rabbitmqct status`你可以看到类似如下信息而不报错：

执行下面命令查看：

```shell
ps aix|grep rabbitmq
```

![image-20210802001946222](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802001946222.png)

或者

```shell
systemctl status rabbitmq-server
```

> 注意：确保RabbitMQ可以运行，确认完毕后把单机版的RabbitMQ服务关闭，以集群的方式来运行

### 02 单机多实例搭建

场景：假设有两个RabbitMQ节点，分别是rabbit-1，rabbit-2，rabbit-1作为主节点，rabbit-2作为从节点。

启动命令：RABBITMQ_NODE_PORT=5672 RABBITMQ_NODENAME=rabbit-1 rabbitmq-server -detached

结束命令：rabbitmqctl -n rabbit-1 stop_app

#### 启动第一个节点

![image-20210802002520890](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802002520890.png)

#### 启动第二个节点

![image-20210802002922523](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802002922523.png)

#### 验证启动

```shell
ps aux|grep rabbitmq
```

#### rabbit-1操作作为主节点

![image-20210802003022232](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802003022232.png)

#### rabbit-2操作作为从节点

![image-20210802003033615](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802003033615.png)

#### 验证集群状态

![image-20210802003108999](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802003108999.png)

#### Web监控

```shell
rabbitmq-plugins enable rabbitmq_management
```

![image-20210802004001812](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802004001812.png)

![image-20210802004502683](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802004502683.png)

#### 小结

![image-20210802004537250](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802004537250.png)



## 5. 分布式事务

分布式事务指事务的操作位于不同的节点上，需要保证事务的ACID特性。

例如在下单场景下，库存和订单如果不在同一个节点上，就涉及分布式事务

### 01 分布式事务方式

在分布式系统中，要实现分布式事务，无外乎哪几种解决方案。

#### 一、两阶段提交（2PC）

> 需要数据库厂商的支持，java组件有atomikos等。

两阶段提交（Two-phase Commit，2PC），通过引协调者（coordinator）来协调参与者的行为，并最终决定这些参与者是否真正要执行事务。

##### 准备阶段

协调者询问参与事务是否执行成功，参与者发回事务执行结果

![image-20210802232652866](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802232652866.png)

##### 提交阶段

如果事务在每个参与者上都执行成功，事务协调者发送通知让参与者提交事务；否则，协调者发送通知让参与者回滚事务。
需要注意的是，在准备阶段，参与者执行了事务，但是还未提交。只有在提交阶段接收到协调者发来的通知后，才进行提交或者回滚。

![image-20210802234717745](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802234717745.png)

##### 存在的问题

1. 同步阻塞所有事务参与者在等待其它参与者响应的时候都处于同步阻塞状态，无法进行其它操作。
2. 单点问题协调者在2PC中起到  非常大的作用，发生故障将会造成很大影响。特别是在阶段二发生故障，所有参与者会—直等待状态，无法完成其它操作。
3. 数据不一致在阶段二，如果协调者只发送了部分Commit 消息，此时网络发生异常，那么只有部分参与者接收到Commit消息，也就是说只有部分参与者提交了事务，使得系统数据不一致。
4. 太过保守任意一个节点失败就会导致整个事务失败，没有完善的容错机制。



#### 二、补偿事务（TCC）

TCC 其实就是采用的补偿机制，其核心思想是：针对每个操作，都要注册一个与其对应的确认和补偿（撒销）操作。它分为三个阶段:

- Try阶段主要是对业务系统做检测及资源预留
- Confirm阶段主要是对业务系统做确认提交，Try阶段执行成功并开始执行Confirm阶段时，默认---Confirm阶段是不会出错的。即:只要Try成功,Confirm一定成功。
- Cancel阶段主要是在业务执行错误，需要回滚的状态下执行的业务取消，预留资源释放。

> 举个例子，假入Bob要向Smith转账，思路大概是:我们有一个本地方法，里面依次调用
>
> 1. 首先在Try阶段，要先调用远程接口把Smith 和 Bob 的钱给冻结起来。
> 2. 在 Confirm阶段，执行远程调用的转账的操作，转账成功进行解冻。
> 3. 如果第2步执行成功，那么转账成功，如果第二步执行失败，则调用远程冻结接口对应的解冻方法(Cancel)。

优点：跟2PC比起来，实现以及流程相对简单了一些，但数据的一致性比2PC也要差一些
缺点：缺点还是比较明显的，在2,3步中都有可能失败。TCC属于应用层的一种补偿方式，所以需要程序员在实现的时候多写很多补偿的代码，在一些场景中，一些业务流程可能用TCC不太好定义及处理。

#### 三、本地消息（异步确保）

> 比如：支付宝、微信支付主动查询支付状态，对账单的形式

本地消息表与业务数据表处于同一个数据库中，这样就能利用本地事务来保证在对这两个表的操作满足事务特性，并且使用了消息队列来保证最终—致性。

- 在分布式事务操作的一方完成写业务数据的操作之后向本地消息表发送一个消息，本地事务能保证这个消息一定会被写入本地消息表中。
- 之后将本地消息表中的消息转发到Kafka等消息队列中，如果转发成功则将消息从本地消息表中删除，否则继续重新转发。
- 在分布式事务操作的另一方从消息队列中读取一个消息，并执行消息中的操作。

![image-20210802235201543](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210802235201543.png)

> 优点：一种非常经典的实现，避免了分布式事务，实现了最终—致性。
> 缺点：消息表会耦合到业务系统中，如果没有封装好的解决方案，会有很多杂活需要处理。

#### 四、MQ事务消息

>  异步场景，通用性较强，拓展性较高

有一些第三方的MQ是支持事务消息的，比如RocketMQ，他们支持事务消息的方式也是类似于采用的二阶段提交，但是市面上一些主流的MQ都是不支持事务消息的，比如Kafka不支持。
以阿里的RabbitMQ中间件为例，其思路大致为：

- 第一阶段Prepared消息，会拿到消息的地址。第二阶段执行本地事务，第三阶段通过第一阶段拿到的地址去访问消息，并修改状态。
  也就是说在业务方法内要想消息队列提交两次请求，一次发送消息和一次确认消息。如果确认消息发送失败了，RabbitMQ会定期扫描消息集群中的事务消息，这时候发现了Prepared消息，它会向消息发送者确认，所以生产方需要实现一个check接口，RabbitMQ会根据发送端设置的第略来决定是回滚还是继续发送确认消息。这样就保证了消息发送与本地事务同时成功或同时失败。

![image-20210803001222111](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803001222111.png)

优点：实现了最终一致性，不需要依赖本地数据库事务。
缺点：实现难度大，主流MQ不支持，RocketMQ事务消息部分代码也未开源。

#### 五、总结

通过本文我们总结并对比了几种分布式分解方案的优缺点，分布式事务本身是一个技术难题，是没有一种完美的方案应对所有场景的，具体还是要根据业务场景去抉择吧。阿里RocketMQ去实现的分布式事务，现在也有除了很多分布式事务的协调器，比如LCN等，大家可以多去尝试。



### 02 具体实现

分布式事务的完整架构图

![](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803005828482.png)

![image-20210803003630327](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803003630327.png)



#### 系统与系统之间的分布式事问题

![image-20210803003815307](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803003815307.png)



#### 系统间调用过程中事务回滚问题

```java
public class OrderService {
	@Autowired
	private OrderDataBaseService orderDataBaseservice;
	//创建订单
	@Transactional(rollbackFor = Exception.class)//订单创建整个方法添加事务
	public void createOrder(Order orderInfo) throws Exception {
		// 1:订单信息--插入丁订单系统，订单数据库事务orderDataBaseService.saveOrder(orderInfo);
		//2∶通通Http接口发途订单信息到运单系统
		String result = dispatchHttpApi(orderInfo.getorderId());
        	if( !"success".equals(result)) {
			throw new Exception("订单创建失败,原因是运单接口调用失败!");
		}
	}
	/**
	* 模拟http请求接口发途，运单系统，将订单号传过去 springcloud
	*/
	private String dispatchHttpApi(String orderId){
		SimpleclientHttpRehyuestFactory factory - new SimpleClientHttpRequestFactory();
                //链接超时>3秒
		factory .setConnectTimeout ( 300e) ;
		//处理超时>2秒
		 factory .setReadTimeout ( 2000) ;
                //发送http请求
		String url = "http: / /localhost:9000/dispatch/order?orderId="+orderId;
                RestTemplate restTemplate = new RestTemplate(factory);//异常
		String result = restTemplate.getForobject(url，string.class);
                return result;
    }
}
```



#### 基于MQ的分布式事务整体设计思路

![image-20210803005503442](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803005503442.png)

#### 基于MQ的分布式事务消息的可靠生产问题

![image-20210803005617505](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803005617505.png)

#### 基于MQ的分布式事务消息的可靠生产问题-定时重发

![image-20210803215741171](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803215741171.png)

#### 基于MQ的分布式事务消息的可靠消费

![image-20210803011150063](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803011150063.png)

#### 基于MQ的分布式事务消息的消息重发

![image-20210803220233499](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803220233499.png)

解决消息重试的集中方案

1. 控制重发的次数
2. try+catch+手动ack
3. try+catch+手动ack +死信队列处理

#### 基于MQ的分布式事务消息的死信队列消息转移+人工处理

![image-20210803220332789](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803220332789.png)

如果死信队列报错就进行人工处理

![image-20210803220158797](https://gitee.com/arlenlincd/picgomd/raw/master/images/2021/07/image-20210803220158797.png)

#### 基于MQ的分布式事务消息的死信队列消息重试注意事项

#### 基于MQ的分布式事务消息的定式重发



### 03 总结

#### 基于MQ的分布式事务解决方案优点：

1. 通用性强
2. 拓展方便
3. 耦合度低，方案也比较成熟

#### 基于MQ的分布式事务解决方案缺点：

1. 基于消息中间件，只适合异步场景
2. 消息会延迟处理，需要业务上能够容忍

#### 建议

1. 尽量去避免分布式事务
2. 尽量将非核心业务做成异步