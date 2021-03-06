package com.sh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Subject：用户
 * SecurityManager：管理所有的Subject，负责认证、授权、会话及缓存的管理。
 * Authenticator：负责Subject的认证。
 * Authorizer：授权器。
 * Realm：数据源。
 * SessionManager：管理Session生命周期的组件。
 * CacheManager：缓存控制器。管理用户、角色、权限等的缓存。
 * Cryptography：密码模块。
 *
 * 添加依赖
 * compile 'org.apache.shiro:shiro-spring-boot-starter:1.4.0'
 */
@SpringBootApplication
public class ShApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShApplication.class, args);
    }
}
