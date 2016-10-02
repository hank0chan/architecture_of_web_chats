# test_architecture_of_web_chats
## web_chats项目的模块化、分层化的架构设计模型测试

### 1. chats-test项目是整个web_chats项目没有模块化之前的整体测试。
### 2. chats-parent是项目的父pom项目，主要是一些引用库的版本控制和子项目的配置等。
### 3. chats-util是工具类。
### 4. chats-data主要用于存放各个子模块的实体类及相应的Mapper接口类和对应的Mapper配置文件。
### 5. chats-dao-mybatis封装了使用Mybatis框架执行数据库操作的抽象类及其实现类，以供服务层调用。
### 6. chats-user和chats-account都是子模块，主要是模块相关的业务代码（就是Service业务层）的实现。
### 7. chats是业务层接口类，主要存放各个业务层的接口类。
### 8. chats-web项目是web应用项目，对外提供API接口，响应请求等。

#### 这个项目目前完成了一个架构模型范式，主要是以User为示例，开发了一套自己设计的架构模型。更多内容还需要进一步完善，目前的模型基本可以作为一个架构的设计参考。
## 本人的所有项目旨在学习，交流，合作，分享。
## 能力有限，如果哪位geek看到了能给出宝贵提升的意见，不胜感激。
