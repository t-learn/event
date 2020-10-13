package indi.huhy.demo.event;

import indi.huhy.demo.event.event.SimpleEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringEventTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void test() {
        applicationContext.publishEvent(new SimpleEvent("Simple Event！"));
    }
}
