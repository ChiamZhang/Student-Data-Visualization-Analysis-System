package com.atzhuang.Conterllor;

import com.atzhuang.Service.Impl.userServiceimpl;
import com.atzhuang.bean.databean.person;
import com.atzhuang.datadao.UserRepository;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Hellowcontroller {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private userServiceimpl usre;

    @RequestMapping("/register")
    public String add(){
        return "/User/add";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/User/noAuth";
    }

    @RequestMapping("/updata")
    public String updata(){
        return "/User/updata";
    }

    @RequestMapping({"/toLogin","/"})
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/index")
    public String success(HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
        String Id= session.getAttribute("ID").toString();
        model.addAttribute("ID",Id);
        return "index";
    }

    @RequestMapping("/Login")
    public String login(String username,String password,Model model,HttpServletRequest request){
        Subject subject= SecurityUtils.getSubject();
        ByteSource salt1=ByteSource.Util.bytes(username);
        Object result=new SimpleHash("MD5",password,salt1,1024);
        UsernamePasswordToken Token=new UsernamePasswordToken(username,result.toString());
        try {
            subject.login(Token);
            person person=userRepository.findByXuehao(username);
            System.out.println(person.getName());
            HttpSession session=request.getSession();
            session.setAttribute("ID",person.getName());
            return "redirect:/index";
            //登陆成功
        }catch (UnknownAccountException e){
            //登陆失败，用户名不存在
            model.addAttribute("mes","one");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("mes","error");
            return "login";
        }
    }
}
