package org.wys.demo.geteway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wys
 * @date 2022/5/24
 */
@RestController
public class MapController {

    @PostMapping("/map")
    public String mapTest(Map<String, String> map) {
        map.forEach((key,value) -> {
            System.out.println(key + " : " + value);
        });
        return "true";
    }

}
