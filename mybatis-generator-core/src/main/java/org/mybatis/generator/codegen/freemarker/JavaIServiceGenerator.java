/**
 *    Copyright 2006-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.IServiceTemplateEntity;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.ServiceImplTemplateEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.mybatis.generator.codegen.freemarker.FreemarkerUtil.generateFreemarkerFile;


/**
 * 通过解析serviceTemplate生成对应的service
 * Created by whm on 2017/7/26.
 */
public class JavaIServiceGenerator {

    public static void addJavaIServiceGenerator(List<IServiceTemplateEntity> iServiceTemplateEntityList) {
        Configuration cfg = new Configuration();
        try {
            for (IServiceTemplateEntity s : iServiceTemplateEntityList) {
                cfg.setClassForTemplateLoading(JavaIServiceGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t = cfg.getTemplate("IServiceTemplate"); //指定模板
                File f = new File(System.getProperty("user.dir") + "/" + s.getProjectTargetPackage());
                f.mkdirs();
                String filePath = System.getProperty("user.dir") + "/" + s.getProjectTargetPackage() + s.getClassName() + ".java";
                File file = new File(filePath);
                generateFreemarkerFile(file ,t,s);
            }
        } catch  (IOException e) {
        e.printStackTrace();
        }
    }
}
