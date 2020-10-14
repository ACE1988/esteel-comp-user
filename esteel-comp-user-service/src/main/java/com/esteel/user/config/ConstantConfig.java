package com.esteel.user.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @ClassName ConstantConfig.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  18:04
 */
@Component
@ConfigurationProperties(prefix = "constant")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ConstantConfig {

    /** 跳转至晋南下单url */
   private   String  cardKey;

}
