package org.wys.demo.design.build;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wys
 * @date 2021/7/27
 */
@Slf4j
public class BuildDemoMain {

    public static void main(String[] args) {
        ResponseCode responseCode = ResponseCode.getByCode(200);
        Response res = new ResponseBuild()
                .buildCode(200)
                .buildData(null)
                .buildMsg(responseCode.getMsg()).build();
        log.info("res ===> {}" , res);
        log.info("res success ===> {}", ResponseUtil.fail(401));
    }
}
