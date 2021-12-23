package org.wys.demo.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wys.demo.common.bean.Currency;

/**
 * @author wys
 * @date 2021/12/21
 */
@RestController
@Slf4j
public class WebParamsController {

    @PostMapping("/testNull")
    public String testNull(@RequestBody Currency currency) {
        System.out.println(currency.getValue());
        return "success";
    }

}
