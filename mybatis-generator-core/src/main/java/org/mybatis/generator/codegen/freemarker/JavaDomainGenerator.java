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
import org.mybatis.generator.codegen.freemarker.TemplateEntity.DomainTemplateEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.mybatis.generator.codegen.freemarker.FreemarkerUtil.generateFreemarkerFile;

/**
 * Created by whm on 2017/7/26.
 */
public class JavaDomainGenerator {
    public static void addJavaDomainGenerator(List<DomainTemplateEntity> domainTemplateEntities) {
        try  {
            for (DomainTemplateEntity d:domainTemplateEntities) {
                Configuration cfg = new  Configuration();
                DomainTemplateEntity.DomainTemplate domainTemplate = d.getDomainTemplate();
                DomainTemplateEntity.NativeDomainTemplate nativeDomainTemplate = d.getNativeDomainTemplate();
                cfg.setClassForTemplateLoading(JavaDomainGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t = cfg.getTemplate("DomainTemplate"); //指定模板
                File f = new File(System.getProperty("user.dir") +"/"+ domainTemplate.getProjectTargetPackage());
                f.mkdirs();
                File domainFile = new File(System.getProperty("user.dir") +"/"+ domainTemplate.getProjectTargetPackage() + domainTemplate.getDomainInterface()+".java");
                generateFreemarkerFile(domainFile,t,domainTemplate);
                Configuration cfg1 = new  Configuration();
                cfg1.setClassForTemplateLoading(JavaDomainGenerator.class, "/template"); //指定模板所在的classpath目录
                Template t1 = cfg1.getTemplate("NativeDomainTemplate"); //指定模板
                File nativeDomainFile = new File(System.getProperty("user.dir") +"/"+ nativeDomainTemplate.getProjectTargetPackage() + nativeDomainTemplate.getNativeDomainClazz()+".java");

                generateFreemarkerFile(nativeDomainFile,t1,nativeDomainTemplate);

            }
        } catch  (IOException e) {
            e.printStackTrace();
        }

    }
}
