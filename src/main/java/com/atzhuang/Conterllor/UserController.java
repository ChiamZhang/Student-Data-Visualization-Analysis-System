package com.atzhuang.Conterllor;

import com.atzhuang.datadao.UserRepository;
import com.atzhuang.bean.databean.person;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @RequestMapping("/add")
    public String Addperson(String xuehao, String name, String password, String power, Model model){
        ByteSource salt=ByteSource.Util.bytes(xuehao);
        System.out.println("添加用户时的腌制："+salt);
        Object result=new SimpleHash("MD5",password,salt,1024);
        userRepository.save(new person(name,result.toString(),xuehao,power));
        model.addAttribute("mes","添加用户成功！");
        return "/User/add";
    }
}
