package ssm.dao;
import org.apache.ibatis.annotations.Param;
import ssm.model.Logistics;
import ssm.model.Logisticsdetail;
import ssm.model.Merchants;
import ssm.model.Goods;

import java.util.List;

public interface MerchantsDao {

    Merchants selectMerchants(long id);

    //商家注册
    void insertMerchants(Merchants merchants);
    //商家登录
    Merchants signMerchants(@Param("MerchantsAccount")String account,@Param("MerchantsPasswd")String passwd);
    //商家更新密码
    void updatepasswd(@Param("MerchantsAccount")String account,@Param("MerchantsPasswd")String newpasswd);
    //商家更新信息
    void updateinformation(@Param("MerchantsAccount") String account,@Param("MerchantsName")String name,@Param("MerchantsEmail")String email,@Param("MerchantsTel")String tel,@Param("MerchantsAddr")String addr);

    //商家上传订单信息
    int Submit1(@Param("MerchantsName")String merchantsname);
    int Submit2(@Param("userName")String username);
    int Submit3(@Param("goodsName")String goodsname);
    String Submit4(@Param("userName")String username);
    int Submit5(@Param("userAddr")String useraddr);
    void Submit6(Logistics logistics);

    //商家查看仓库
    Goods seestore(@Param("MerchantsId")int merchantsid);
    //商家查询物流信息
    List<Logisticsdetail> Merchantsselectlogis(String account);

    //商家发货
    int getid(@Param("MerchantsAccount")String merchantsaccount);
    void send(@Param("MerchantsId")int merchantsid);
    void subnum(@Param("MerchantsId")int id);
}
