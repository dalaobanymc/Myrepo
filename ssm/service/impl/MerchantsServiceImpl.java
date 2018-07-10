package ssm.service.impl;
import ssm.dao.MerchantsDao;
import ssm.model.Logistics;
import ssm.model.Logisticsdetail;
import ssm.model.Merchants;
import ssm.service.MerchantsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import ssm.model.Goods;

import java.util.List;

@Service
public class MerchantsServiceImpl implements MerchantsService {
    @Resource MerchantsDao merchantsDao;

    //商家注册
    @Override
    public void insertMerchants(Merchants merchants) {
        merchantsDao.insertMerchants(merchants);
    }

    //商家修改密码
    @Override
    public void updatePasswd(String account,String newpasswd) {
        merchantsDao.updatepasswd(account,newpasswd);
    }

    //商家登录
    @Override
    public Merchants signMerchants(String account, String passwd) {
        return merchantsDao.signMerchants(account,passwd);
    }

    //商家更新信息
    @Override
    public void updateinformation(String account, String name, String email, String tel, String addr) {
        merchantsDao.updateinformation(account,name,email,tel,addr);
    }

    //商家发货
    @Override
    public void send(String account) {
        int a = merchantsDao.getid(account);
        merchantsDao.send(a);
        merchantsDao.subnum(a);
    }

    //商家提交订单
    @Override
    public void submit(String merchantsname, String username, String goodsname) {

        int merid = merchantsDao.Submit1(merchantsname);
        int userid = merchantsDao.Submit2(username);
        int goodsid = merchantsDao.Submit3(goodsname);
        String useraddr = merchantsDao.Submit4(username);
        System.out.println(useraddr);
        int x = useraddr.indexOf("啊");
        String s = useraddr.substring(0,x);
        System.out.println(s);
        int courierid = merchantsDao.Submit5(s);
        System.out.println("\n"+courierid+"\n");
        Logistics lo = new Logistics();
        lo.setMerchantsId(merid);
        lo.setUserId(userid);
        lo.setGoodsId(goodsid);
        lo.setCourierId(courierid);

        merchantsDao.Submit6(lo);
    }

    //商家查看仓库
    @Override
    public Goods seestore(String account) {
        int a =  merchantsDao.getid(account);
        return merchantsDao.seestore(a);
    }

    //商家查询物流信息
    @Override
    public List<Logisticsdetail> Merchantsselectlogis(String account) {
        return merchantsDao.Merchantsselectlogis(account);
    }
}
