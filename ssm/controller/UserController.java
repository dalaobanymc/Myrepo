package ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.model.Logisticsdetail;
import ssm.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("updateuserpasswd")
    public void changepassword(/*@RequestParam String account, */@RequestParam String passwd, HttpServletRequest request, HttpServletResponse response)throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下
        ObjectMapper mapper = new ObjectMapper();

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");

        userService.updatepasswd(account,passwd);
        response.getWriter().write(mapper.writeValueAsString(passwd));
        response.getWriter().close();
    }
    @RequestMapping("makesureget")
    public void makesureget(@RequestParam String account,HttpServletRequest request, HttpServletResponse response)throws IOException{

        /*HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");*/
        userService.Makesureget(account);

    }
    @RequestMapping("updateuserinformation")
    public void updateInformation(/*@RequestParam String account,*/ @RequestParam String name, @RequestParam String email, @RequestParam String tel, @RequestParam String addr, HttpServletRequest request, HttpServletResponse response )throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下
        ObjectMapper mapper = new ObjectMapper();

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");

        userService.updateinformation(account,name,email,tel,addr);
        response.getWriter().write(mapper.writeValueAsString("用户信息修改成功"));
        response.getWriter().close();
    }
    @RequestMapping("userSelectlogistics")
    public void Selectlogistics(/*@RequestParam String account,*/ HttpServletRequest request, HttpServletResponse response)throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");

        List<Logisticsdetail> lo = userService.Userselectlogis(account);
        response.getWriter().write(mapper.writeValueAsString(lo));
        response.getWriter().close();
    }



}
