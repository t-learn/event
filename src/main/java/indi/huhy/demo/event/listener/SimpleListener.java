package indi.huhy.demo.event.listener;

import com.google.gson.Gson;
import indi.huhy.demo.event.event.SimpleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 事件监听器（事件处理器）：负责处理事件的对象（ApplicationListener<E>， SmartApplicationListener）
 */
@Slf4j
@Service
public class SimpleListener implements ApplicationListener<SimpleEvent> {

    @Override
    public void onApplicationEvent(SimpleEvent simpleEvent) {
        log.info(new Gson().toJson(simpleEvent.getSource()));
    }
}
