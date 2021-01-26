package com.atzhuang.config.Shiro;

import com.atzhuang.Service.Impl.userServiceimpl;
import com.atzhuang.bean.databean.person;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    userServiceimpl uer=new userServiceimpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        person person=(person) subject.getPrincipal();
        String s=person.getPower();
        String[] power=s.split(",");
        for(String a:power) {
            info.addStringPermission(a);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //假设数据库密码
        UsernamePasswordToken token= (UsernamePasswordToken)authenticationToken;
        person person=uer.findByXuehao(token.getUsername());
        if(person==null){
            //判断是否有该用户
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo(person,person.getPassword(),getName());
    }
}
