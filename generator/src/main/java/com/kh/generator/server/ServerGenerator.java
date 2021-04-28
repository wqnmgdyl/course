package com.kh.generator.server;

import com.kh.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ly
 * @date 2021/4/28 14:10
 */
public class ServerGenerator {

    static String toServicePath = "business\\src\\main\\java\\com\\kh\\business\\service\\impl\\";

    public static void main(String[] args) throws Exception {
        String Domain = "Section";
        String domain = "section";
        Map<Object, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Domain + "ServiceImpl.java", map);
    }
}
