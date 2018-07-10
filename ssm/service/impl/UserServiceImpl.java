package ssm.service.impl;

import ssm.dao.UserDao;
import ssm.model.Logisticsdetail;
import ssm.model.User;
import ssm.service.UserService;
import org.springframework.stereotype.Service;//提供@Service注释
import javax.annotation.Resource;//提供@Resource注释
import java.util.List;

@Service//带了参数，但不知道参数的意义
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    //分析过程
    //理解一下，这里将UserDao映射器接口注入（接口不能运行，MYbatis运用动态代理技术使得接口可以运行起来）
    //通过调用映射器的方法，就相当于发送了SQL语句！！！！！（相当于通过创建sqlsession，通过sqlsession来发送SQL语句）
    //之后这个服务类被注射到对应的控制器类中(服务类也类似，注入的只是接口，应该也是通过动态代理技术实现的--UserController)
    //【当访问对应的uri时（控制类的requestmapping时）】然后在控制器类中调用该服务类的方法，也就调用了映射器接口的方法，使得其发送SQL语句，具体什么发送由映射器的xml文件定义
    //sql语句调用后将执行结果与对应的POJO（也即User）自动映射对应起来

    //总结一下
    //对数据库的操作方法定义在映射器的接口中，其具体实现定义在映射器的xml文件中
    //创建一个服务接口，创建一个继承该接口的类。服务接口中定义一个对数据库操作的方法，继承的类中注入映射器接口！，在对接口方法的实现中使用映射器来实现（有点别扭可以看看代码）
    //之后在控制器类中注入该服务类，就可以直接调用服务接口的对数据库操作的方法来操作数据库
    //本质上是一种封装----创建了映射器，服务接口+服务类把映射器封装，控制器类中直接注入服务类，调用对数据库操作的方法就好（为什么呢）


    //用户注册
    public void insertUser(User user)   {  userDao.insertUser(user);  }
    //用户更新密码
    public void updatepasswd(String account,String newpasswd)   { userDao.updatepasswd(account,newpasswd);}
    //用户登录
    public User signUser(String account, String passwd) {
        return userDao.signUser(account,passwd);
    }
    //用户更新信息
    public void updateinformation(String account,String name, String email, String tel, String addr) {
        userDao.updateinformation(account,name,email,tel,addr);
    }
    //用户查询物流信息
    public List<Logisticsdetail> Userselectlogis(String account) {
        return userDao.Userselectlogis(account);
    }
    //用户确认收货
    public void Makesureget(String account) {
        int a = userDao.Makesureget1(account);
        userDao.Makesureget2(a);
    }
}