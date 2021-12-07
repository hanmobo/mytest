package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "/param1",method = {RequestMethod.GET})
    public String param1(User user, HttpSession session){
        System.out.println("---- param1 ----");
        System.out.println("username="+user.getUsername());
        System.out.println("age="+user.getAge());
        System.out.println("birthday="+user.getBirthday());
        System.out.println("city="+user.getAddress().getCity());
        System.out.println("street="+user.getAddress().getStreet());
        System.out.println("phone="+user.getAddress().getPhone());
        session.setAttribute("name",user.getUsername());
        session.setAttribute("bir",user.getBirthday());
        return "redirect:/user/test";
    }


    @RequestMapping(value = "test")
    public String test(){
        System.out.println("---- test ----");
        return "/hello.jsp";
    }



    @RequestMapping(value = "logon",method = {RequestMethod.POST})
    public String logon(User user, HttpSession session, HttpServletRequest request){
        System.out.println("---- logon ----");
        int flag = 0;
        if (flag ==1 ){
            System.out.println("username="+user.getUsername());
            session.setAttribute("user",user);
            return "welcome";
        }
        System.out.println("登录失败，返回首页index");
        request.setAttribute("error","登录失败！");
        return "forward:/index.jsp";
    }


    @RequestMapping(value = "delete")
    public String delete(HttpServletRequest request){
        System.out.println("---- delete ----");
        return "welcome";
    }
}
    //多个上传
    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    public String fileUpload(MultipartFile[] images, HttpServletRequest request,Map<String,Object>map) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        int count = 0;
        for (MultipartFile image: images) {
            is = image.getInputStream();//获取文件的输入流对象
            String filename = image.getOriginalFilename();//获取文件的原名
            if(filename.equals("")){
                System.out.println("进入下一轮");
                continue;
            }
            String realPath = request.getServletContext().getRealPath("/images");
            //根据文件的真实路径和名字创建输出流对象
            os = new FileOutputStream(new File(realPath,doFileName(filename)));
            /*IOUtils.copy(is,os);//把输入流写入输出流，完成上传*/
            int size = IOUtils.copy(is,os);
            if(size > 0){count++;}
        }
        os.close();is.close();//工作原则：先开的后关，后开的先关
        System.out.println("上传成功"+count+"张图片");
        map.put("shu",count);
        return "welcome";
    }
    private String doFileName(String filename){
        String extension = FilenameUtils.getExtension(filename);
        String uuid = UUID.randomUUID().toString();
        System.out.println("上传文件"+uuid);
        return uuid+"."+extension;
    }