package ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.model.Logisticsdetail;
import ssm.model.Merchants;
import ssm.model.User;
import ssm.service.MerchantsService;
import ssm.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class SignInAndRegisterController {

    @Resource
    private UserService userService;
    @Resource
    private MerchantsService merchantsService;

    @RequestMapping("signin")
    public void signin(@RequestParam String account,@RequestParam String passwd,@RequestParam String type, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //创建Session会话
        HttpSession session = request.getSession(true);
        session.setAttribute("Account",account);
        session.setAttribute("Passwd",passwd);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");//
        response.setContentType("text/html;charset=utf-8");//解决输出在页面中文乱码的情况下
        ObjectMapper mapper = new ObjectMapper();
        if(type.equals("user")) {
            User user = userService.signUser(account, passwd);
            if (user == null) {
                response.getWriter().write(mapper.writeValueAsString("账户密码输入错误，请重新登录"));
            } else {
                response.getWriter().write(mapper.writeValueAsString(user));
            }
        }
        else{
            Merchants merchants = merchantsService.signMerchants(account,passwd);
            if (merchants == null) {
                response.getWriter().write(mapper.writeValueAsString("账户密码输入错误，请重新登录"));
            } else {
                response.getWriter().write(mapper.writeValueAsString(merchants));
            }
        }
        response.getWriter().close();
    }
    @RequestMapping("register")
    public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String type = request.getParameter("type");
        if(type.equals("user") ) {
            User user = new User();
            user.setUserName("aaa");
            user.setUserAccount(request.getParameter("account"));
            user.setUserPasswd(request.getParameter("passwd"));
            user.setUserEmail("bbb");
            user.setUserTel(request.getParameter("tel"));
            user.setUserAddr(request.getParameter("addr"));
            this.userService.insertUser(user);
            response.getWriter().write(mapper.writeValueAsString(user));

        }
        else{
            Merchants merchants = new Merchants();
            merchants.setMerchantsName("yumaochuan");
            merchants.setMerchantsAccount(request.getParameter("account"));
            merchants.setMerchantsPasswd(request.getParameter("passwd"));
            merchants.setMerchantsEmail("sss");
            merchants.setMerchantsTel(request.getParameter("tel"));
            merchants.setMerchantsAddr(request.getParameter("addr"));
            merchantsService.insertMerchants(merchants);
            response.getWriter().write(mapper.writeValueAsString(merchants));
        }
        response.getWriter().close();
    }



}
