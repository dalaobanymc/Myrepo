package ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.model.Goods;
import ssm.model.Logisticsdetail;
import ssm.service.MerchantsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MerchantsController {

    @Resource
    MerchantsService merchantsService;
    @RequestMapping("updatemerchantspasswd")
    public void changepassword(/*@RequestParam String account, */@RequestParam String passwd, HttpServletRequest request, HttpServletResponse response)throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下
        ObjectMapper mapper = new ObjectMapper();

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");

        merchantsService.updatePasswd(account,passwd);
        response.getWriter().write(mapper.writeValueAsString(passwd));
        response.getWriter().close();
    }

    @RequestMapping("Submit")
    public void submit(@RequestParam String merchantsname, @RequestParam String username, @RequestParam String goodsname, HttpServletRequest request, HttpServletResponse response)throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下
        merchantsService.submit(merchantsname,username,goodsname);
        response.getWriter().write(mapper.writeValueAsString("发货成功"));
        response.getWriter().close();
    }

    @RequestMapping("Send")
    public void send(/*@RequestParam String merchantsaccount*/HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");
        merchantsService.send(account);
    }

    @RequestMapping("Seestore")
    public void seestore(/*@RequestParam String account,*/HttpServletRequest request, HttpServletResponse response)throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");
        Goods goods = merchantsService.seestore(account);

        response.getWriter().write(mapper.writeValueAsString(goods));
        response.getWriter().close();
    }

    @RequestMapping("updatemerchantsinformation")
    public void updateInformation(/*@RequestParam String account, */@RequestParam String name, @RequestParam String email, @RequestParam String tel, @RequestParam String addr,  HttpServletRequest request, HttpServletResponse response )throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下
        ObjectMapper mapper = new ObjectMapper();

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");

        merchantsService.updateinformation(account,name,email,tel,addr);
        response.getWriter().write(mapper.writeValueAsString("商家信息修改成功"));
        response.getWriter().close();
    }
    @RequestMapping("merchantsSelectlogistics")
    public void Selectlogistics(/*@RequestParam String account,*/ HttpServletRequest request, HttpServletResponse response)throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下

        HttpSession session = request.getSession(true);
        String account = (String)session.getAttribute("Account");

        List<Logisticsdetail> lo = merchantsService.Merchantsselectlogis(account);
        response.getWriter().write(mapper.writeValueAsString(lo));
        response.getWriter().close();
    }
}
