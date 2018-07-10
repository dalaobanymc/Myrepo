package ssm.model;

public class Merchants {
    private long MerchantsId;
    private String MerchantsName;
    private String MerchantsAccount;
    private String MerchantsPasswd;
    private String MerchantsEmail;
    private String MerchantsTel;
    private String MerchantsAddr;

    public long getId() {
        return MerchantsId;
    }

    public void setId(long id) {
        this.MerchantsId = id;
    }

    public String getMerchantsName() {
        return MerchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        MerchantsName = merchantsName;
    }

    public String getMerchantsAccount() {
        return MerchantsAccount;
    }

    public void setMerchantsAccount(String merchantsAccount) {
        MerchantsAccount = merchantsAccount;
    }

    public String getMerchantsPasswd() {
        return MerchantsPasswd;
    }

    public void setMerchantsPasswd(String merchantsPasswd) {
        MerchantsPasswd = merchantsPasswd;
    }

    public String getMerchantsEmail() {
        return MerchantsEmail;
    }

    public void setMerchantsEmail(String merchantsEmail) {
        MerchantsEmail = merchantsEmail;
    }

    public String getMerchantsTel() {
        return MerchantsTel;
    }

    public void setMerchantsTel(String merchantsTel) {
        MerchantsTel = merchantsTel;
    }

    public String getMerchantsAddr() {
        return MerchantsAddr;
    }

    public void setMerchantsAddr(String merchantsAddr) {
        MerchantsAddr = merchantsAddr;
    }
}
