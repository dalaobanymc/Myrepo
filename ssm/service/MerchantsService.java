package ssm.service;

import ssm.model.Logisticsdetail;
import ssm.model.Merchants;
import ssm.model.Goods;
import java.util.List;

public interface MerchantsService {

    void insertMerchants(Merchants merchants);

    void updatePasswd(String account, String newpasswd);

    public void updateinformation(String account,String name,String email,String tel,String addr);

    Merchants signMerchants(String account, String passwd);

    //商家提交订单信息
    void submit(String merchantsname,String username,String goodsname);
    //商家发货
    void send(String account);
    //商家查看仓库
    Goods seestore(String account);
    //商家查看物流信息
    public List<Logisticsdetail> Merchantsselectlogis(String account);




}
