package com.atzhuang.config.Shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /*创建shiroFilterFactoryBean*/
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager securityManager){
        System.out.println("权限拦截");
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置过滤器
        /*
        anon：无需认证
        authc:必须认证
        user：如果使用rememberme功能可以直接访问
        perms：该资源必须得到资源权限才可以访问
        role:该资源必须得到角色权限才可以访问
        */
        Map<String,String> filtermap=new LinkedHashMap<>();
        //分配权限
        filtermap.put("/add","perms[add]");
        filtermap.put("/updata","perms[updata]");
        //设置拦截
        filtermap.put("/toLogin","anon");
        filtermap.put("/textjsp","anon");
        filtermap.put("/register","anon");// 这个必须在前面
        filtermap.put("/Login","anon");// 这个必须在前面
        filtermap.put("/*","authc");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
//        修改默认的跳转登陆页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        return  shiroFilterFactoryBean;
    }
    /*创建DefaultWebSecurityManager*/
    @Bean(name = "getDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("UserRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setCacheManager(EhCacheManager());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
    /*创建Realm*/
    @Bean(name = "UserRealm")
    public UserRealm getRealm(@Qualifier("credentialsMatcher")HashedCredentialsMatcher credentialsMatcher){
        UserRealm userRealm=new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return new UserRealm();
    }

    /*配置shiroDialect,用于thymeleaf和shiro配合使用*/
    @Bean
    public ShiroDialect getshiroDialect(){
        return new ShiroDialect();
    }
    //设置加密方式
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
    //设置缓存
    @Bean
    public EhCacheManager EhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return em;
    }
    //设置cookie对象，记住我功能
    public SimpleCookie rememberMeCookie(){
        //对应前端的checkbox的name=rememberMe
        SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
        //设置cookie的生效时间，两天
        simpleCookie.setMaxAge(172800);
        return simpleCookie;
    }
    //cookie管理对象
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager manager=new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie());
        manager.setCipherKey("LIZHUANGZHUANG_Y".getBytes());
        return manager;
    }
}
