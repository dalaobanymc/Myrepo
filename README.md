# Myrepo
Share something
MVC开发模式
MVC开发模式=model+view+controller
Model代表数据结构，与数据库表相映射。View代表视图，被服务器转发跳转，用于展示页面。Controller负责接受请求，业务处理，跳转视图。
SSM的框架搭建中  
Mybatis：
1. 直接负责对数据库的操作                    
2. 主要涉及到映射器的使用。映射器=接口+xml配置文件，接口中的方法对应每一种数据库操作（增，删，查，改），xml配置文件要写出对接口中每一种数据库操作的具体                       实现（查哪张表，条件是什么）。
3. 接口函数中使用@Param("S")实现传参（S为需要传入的参数），而在xml对应的实现中，#{S}运用参数                   
4. 对应Dao.java    Dao.XML

Service依赖注入：
1. 服务类，负责业务处理      
2. Service接口+Service实现类，负责业务处理，对应业务操作。                    
3. Service存在的意义是进行业务处理，简化控制器，封装数据库操作。往往一个业务操作对应多个数据库操作，则将这一个业务操作写为接口，在实现类中调用数据库操作(依赖注入           Dao)
---例如商家发货这个业务操作Send()，需要两个update数据库操作，一个修改物流表物流状态为已发货-Changestate()，一个修改仓库表中库存数量减1-Subnum()。则在实现类中
 
1
@Resource MerchantsDao merchantsdao
2
void Send()
3
{
4
    merchantsdao.Changestate();
5
    merchantsdao.Subnum();
6
}

4. 对应Service.java    ServiceImpl.java    

Controller：
1. 控制器，负责调用service业务处理方法，跳转页面                    
2. 由于业务处理在Service中进行，于是简化了控制器的部分，控制器中只用依赖注入对应的service类，调用其封装好的业务操作方法即可。    
构造逻辑：
1. 在经过一次SSM后端框架编写后，我觉得应采用按对象分类的方式构造各部分文件                     
2. 比如这个系统中，要使用的对象有s个，则构造s个Dao，Service，Controller                     
3. 如有一个对象：用户。用户使用该系统进行登陆，注册，查询，修改信息。则按以下步骤构造其文件结构                   
（1）构造Dao接口，其中的所有数据库操作的发起方都是用户。同时XML文件配置好各种数据库操作                  
（2）构造Service接口，其中所有的业务处理操作的发起方都是用户，其继承类实现各业务处理接口。                  
（3）构造Controller，其中的所有操作发起方也都是用户。用户发出不同的业务操作请求，对不同的业务操作（@RequestMapping）调用不同的业务处理方法(Userservice中的方法)

此次上手实践SSM对后端的理解：
    所谓的后端，就是通过服务器处理前端用户发送的各种业务操作请求。而这些业务操作归根到底就是对数据库的操作。
    业务操作=有逻辑的数据库操作的封装+页面跳转
