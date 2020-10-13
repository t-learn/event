package indi.huhy.demo.event.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * 事件：或者称为事件对象，是事件源和事件监听器之间的信息桥梁。是整个事件模型驱动的核心（ApplicationEvent）
 */
@Slf4j
public class SimpleEvent extends ApplicationEvent {

    public SimpleEvent(Object source) {
        super(source);
    }
}
