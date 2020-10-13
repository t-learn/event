package indi.huhy.demo.event.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//@Configuration
//@EnableAsync
public class AnnotationAsyncConfig implements AsyncConfigurer {

    /**
     * 线程池维护线程的最小数量
     */
    private static final int corePoolSize = 2;
    /**
     * 线程池维护线程的最大数量
     */
    private static final int maxPoolSize = 2;
    /**
     * 队列最大长度
     */
    private static final int queueCapacity = 100;

    /**
     * 获取异步线程池执行对象
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);

        // 设置线程前缀，用于调试
        taskExecutor.setThreadNamePrefix("AnnotationAsyncExecutor-");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);

        // 拒绝策略 CallerRunsPolicy 由调用线程处理该任务
        // AbortPolicy 直接抛出异常
        // CallerRunsPolicy 会调用当前线程池的所在的线程去执行被拒绝的任务
        // DiscardPolicy 直接丢弃
        // DiscardOldestPolicy 丢弃队列最前面的任务
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
