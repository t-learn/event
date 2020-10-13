package indi.huhy.demo.event.listener;

import com.google.gson.Gson;
import indi.huhy.demo.event.event.SimpleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 事件监听器（事件处理器）：负责处理事件的对象（ApplicationListener<E>， SmartApplicationListener）
 */
@Slf4j
@Service
public class SimpleSmartApplicationListener1 implements SmartApplicationListener {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> clazz) {
        return clazz == SimpleEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        log.info(new Gson().toJson(applicationEvent.getSource()));
    }
}
