package net.xdclass.demoproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:pay.properties")
public class WXConfig {

    @Value("${wx.appid}")
    private String payAppId;
    @Value("${wx.secret}")
    private String paySecrete;
    @Value("${wx.mechid}")
    private String payMechId;

    public String getPayAppId() {
        return payAppId;
    }

    public void setPayAppId(String payAppId) {
        this.payAppId = payAppId;
    }

    public String getPaySecrete() {
        return paySecrete;
    }

    public void setPaySecrete(String paySecrete) {
        this.paySecrete = paySecrete;
    }

    public String getPayMechId() {
        return payMechId;
    }

    public void setPayMechId(String payMechId) {
        this.payMechId = payMechId;
    }
}
