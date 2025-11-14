package com.orderManagement.order_service.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@RefreshScope
@Getter
@Component
@ConfigurationProperties(prefix = "discount")
public class DiscountConfig {

    private boolean enabled;
    private double amount;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
