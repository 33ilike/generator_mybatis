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

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.codegen.freemarker.TemplateEntity.TemplateEntity;
import org.mybatis.generator.internal.JavaFileMergerJaxp;

import java.io.*;

import static org.springframework.util.FileCopyUtils.copy;

/**
 * Created by whm on 2017/8/8.
 */
public class FreemarkerUtil {
    public static void generateFreemarkerFile(File file, Template t, TemplateEntity s) {
        try {
            Reader in;
            boolean isFirst = false;
            String oldFileSource = "";
            if (file != null && file.canRead()) {
                in = new FileReader(file);
                StringWriter out = new StringWriter();
                copy(in, out);
                oldFileSource = out.toString();
                isFirst = true;
            }
            FileOutputStream fos = new FileOutputStream(file); //java文件的生成目录
            t.process(s, new OutputStreamWriter(fos, "utf-8")); //
            fos.flush();
            fos.close();

            //读取新生成的文件内容
            String newFileSource = "";
            if (file != null && file.canRead()) {
                in = new FileReader(file);
                StringWriter out = new StringWriter();
                copy(in, out);
                newFileSource = out.toString();
                in.close();
            }
            if (isFirst) {
                String newJavaFileContent = new JavaFileMergerJaxp().getNewFreemarkerJavaFile(newFileSource, oldFileSource);
                Writer writer = new FileWriter(file);
                writer.write(newJavaFileContent);
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
