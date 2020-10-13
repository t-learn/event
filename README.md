#### Spring 事件驱动编程
##### 核心构件
1. 事件源：负责产生事件的对象。比如我们常见的按钮，按钮就是一个事件源，能够产生“点击”这个事件（ApplicationContext）
2. 事件监听器（事件处理器）：负责处理事件的对象（ApplicationListener<E>， SmartApplicationListener）
3. 事件：或者称为事件对象，是事件源和事件监听器之间的信息桥梁。是整个事件模型驱动的核心（ApplicationEvent）

##### 全局异步的操作步骤
1. 定义并配置Executor Bean
2. 配置名为applicationEventMulticaster 的 SimpleApplicationEventMulticaster Bean
3. 设置applicationEventMulticaster 执行器为第一步的 Executor

##### @Async注解的使用操作执行步骤
1. 开启异步执行：@EnableAsync
2. 配置线程池，非必须，没有则用默认线程池
3. Bean方法指定为异步：@Async