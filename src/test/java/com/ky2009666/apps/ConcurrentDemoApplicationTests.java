package com.ky2009666.apps;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
@Slf4j(topic = "并发编程:ConcurrentDemoApplicationTests")
class ConcurrentDemoApplicationTests {
    /**
     * 定义常量文件名称.
     */
    public static final String POM_XML = "F:\\workspace-source\\selfServiceManage\\concurrent_demo\\pom.xml";

    @Test
    void contextLoads() {
        log.info("开始了------------------------");
        List<String> strings = FileUtil.readLines(POM_XML, StandardCharsets.UTF_8);
        Assert.notNull(strings);
        log.info("{}",strings);
    }
    @Test
    void asynReadFile(){
        log.info("异步执行开始-------");
        new Thread(
                ()->{
                    List<String> strings = FileUtil.readLines(POM_XML,StandardCharsets.UTF_8);
                    log.info("{}",strings);
                }).start();
        log.info("异步执行结束-------");
    }

}
