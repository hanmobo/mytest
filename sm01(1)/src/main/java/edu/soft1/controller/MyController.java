package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {
//    @RequestMapping("/hello.do")
//    public String hello(){
//        System.out.println("--hello()--");
//        return "hello";
//    }
    @RequestMapping("/hello")
    public ModelAndView hello(){
        System.out.println("---hello()---");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("mag","I'm peter");
        return mav;
    }

    @RequestMapping(value = "param1.do",method = {RequestMethod.GET})
    public String param1(HttpServletRequest request){
        //接收client发来的数据
        String name = request.getParameter("name");//获取数据
        System.out.println("name="+name);//打印数据
        request.setAttribute("name",name);//将数据库存入request
        //调用业务层的方法
        //页面跳转
        return "hello";//跳转至jsp/hello.jsp页面
    }
    @RequestMapping(value = "param2.do",method = {RequestMethod.GET,RequestMethod.POST})
    public String param2(HttpServletRequest request, HttpSession session){
        //接收client发来的数据
        String name = request.getParameter("username");//获取数据
        String age = request.getParameter("age");//获取数据
        System.out.println("name="+name+",age="+age);//打印数据
        request.setAttribute("age",age);//将数据库存入request
        request.setAttribute("name",name);//将数据库存入request
        //调用业务层的方法
        //页面跳转
        return "hello";//跳转至jsp/hello.jsp页面
    }
    @RequestMapping(value = "param3",method = {RequestMethod.POST})
    public String param3(String username,int age){//数据名与方法参数名相同
        System.out.println("----param3()----");
        System.out.println("username="+username);
        System.out.println("age="+age);
        return "hello";
    }
    @RequestMapping(value = "param4",method = {RequestMethod.POST})//数据名与方法参数名不同
    public String param4(@RequestParam(value = "username")String u,
                         @RequestParam(value = "age",defaultValue = "18")int a){
        System.out.println("----param4()----");
        System.out.println("u="+u);
        System.out.println("a="+a);
        return "redirect:test";
    }
    @RequestMapping(value = "param5",method = {RequestMethod.POST})
    public String param5(User user,HttpSession session) {
        System.out.println("---param5()---");
        System.out.println("username=" + user.getUsername());
        System.out.println("age=" + user.getAge());
        session.setAttribute("name", user.getUsername());
        return "redirect:test";
    }
    @RequestMapping("test")//test.do
    public String test(){
        System.out.println("----test()----");
        return "hello";
    }
    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("username="+user.getUsername());
        System.out.println("pwd="+user.getAge());
        System.out.println("birthday="+user.getBirthday());
        System.out.println("city="+user.getAddress().getCity());
        System.out.println("street="+user.getAddress().getStreet());
        System.out.println("phone="+user.getAddress().getPhone());
        return "hello";
    }
    }


