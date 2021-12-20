package org.wys.demo.spring.publish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author wys
 * @date 2021/9/8
 */
@Service
@Slf4j
public class CouponService {

    @EventListener
    public void addCoupon(UserRegisterEvent event) {
        log.info("[addCoupon] 给用户 {} 添加优惠券", event.getUsername());
    }

}
