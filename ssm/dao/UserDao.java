package ssm.dao;

//在这里要引入Model里对应的POJO类，写明全路径
import org.apache.ibatis.annotations.Param;
import ssm.model.Logisticsdetail;
import ssm.model.User;

import java.util.List;

public interface UserDao {

    User selectUser(long id);

    //用户注册
    void insertUser(User user);
    //用户登录
    User signUser(@Param("userAccount") String account, @Param("userPasswd") String passwd);
    //用户更新密码
    void updatepasswd(@Param("userAccount") String account,@Param("userPasswd") String newpasswd);
    //用户更新信息
    void updateinformation(@Param("userAccount") String account,@Param("userName")String name,@Param("userEmail")String email,@Param("userTel")String tel,@Param("userAddr")String addr);
    //用户查询物流信息
    List<Logisticsdetail> Userselectlogis(String account);
    //用户确认收货
    int Makesureget1(@Param("userAccount")String useraccount);
    void Makesureget2(@Param("userId")int userid);



}