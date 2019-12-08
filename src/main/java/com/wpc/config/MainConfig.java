package com.wpc.config;

import com.wpc.bean.Person;
import com.wpc.dao.BookDao;
import com.wpc.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 配置类
 *
 * @Author: 王鹏程
 * @Date: 2019/6/28 0028
 * @Time: 下午 9:52
 * excludeFilters = Filter[] 排除不需要扫描的包
 * includeFilters = Filter[] 指定需要扫描的包
 * @ComponentScan value:指定要扫描的包
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 */
@Configuration
@ComponentScan(value = {"com.wpc"}, excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class}
//        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
})
public class MainConfig {

    /**
     * 给容器中注入一个bean，id为默认为方法名
     * id也可以指定@Bean的属性value
     */
    @Bean
    public Person person() {
        return new Person("zs", 18);
    }
}
