package com.springboot.demo18;

import com.springboot.springbootstarterredis.RedisAutoCongfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisAutoCongfiguration.class)
public @interface EnableRedis {
}
