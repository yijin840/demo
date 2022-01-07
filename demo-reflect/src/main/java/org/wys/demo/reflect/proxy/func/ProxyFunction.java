package org.wys.demo.reflect.proxy.func;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2022/1/6
 */
public interface ProxyFunction {

    public static void main(String[] args) {
        String jsonStr = "[{\"expressFunctionStr\":\"@APLT(277003)+@APLT(277004)\",\"taxCategoryIdentified\":{\"taxCategory\":\"STAMP_TAX\",\"taxCategoryCollectionItem\":{\"taxCategory\":\"STAMP_TAX\",\"itemName\":\"购销合同\",\"taxCategoryName\":\"印花税\",\"_version\":1,\"createdAt\":\"Jan 1, 2000 12:00:00 AM\",\"updatedAt\":\"Jan 1, 2000 12:00:00 AM\",\"id\":392,\"__trantorExtendFields\":{\"isDeleted\":false,\"deletedAt\":0}},\"taxRate\":0.0,\"taxTerm\":\"MONTH\",\"startAt\":\"Dec 1, 2021 12:00:00 AM\",\"endAt\":\"Dec 31, 2021 11:59:59 PM\",\"bookSet\":{\"id\":52265,\"__trantorExtendFields\":{}},\"_version\":2,\"createdAt\":\"Dec 17, 2021 11:53:57 AM\",\"updatedAt\":\"Dec 24, 2021 4:48:08 PM\",\"updatedBy\":{\"id\":50001,\"__trantorExtendFields\":{}},\"id\":15032,\"__trantorExtendFields\":{\"isDeleted\":false,\"deletedAt\":0}},\"reduceProportion\":0,\"__trantorExtendFields\":{}}]\n" +
                "2022-01-07 11:03:34.343DEBUG[ftm-voucher-runtime]  - [http-nio-8080-exec-9] i.t.t.b.manager.RedisContextCache       : deleted business context cache, prefix=117118d1-27af-4b5e-9abd-da6836ac468d:businessContext";
        Gson gson = new Gson();
        List<String> list = new ArrayList<>();
    }

}
