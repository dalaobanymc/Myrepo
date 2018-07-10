package ssm.service;

import ssm.model.Logisticsdetail;
import ssm.model.User;

import java.util.List;

public interface UserService {

    //用户注册
    public void insertUser(User user);
    //用户登录
    public User signUser(String account,String passwd);
    //用户修改密码
    public void updatepasswd(String account,String newpasswd);
    //用户修改信息
    public void updateinformation(String account,String name,String email,String tel,String addr);
    //用户查询物流信息
    public List<Logisticsdetail> Userselectlogis(String account);
    //用户确认收货
    public void Makesureget(String account);

}