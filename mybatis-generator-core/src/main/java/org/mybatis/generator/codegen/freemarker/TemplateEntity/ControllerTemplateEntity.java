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
package org.mybatis.generator.codegen.freemarker.TemplateEntity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by chenpengzhan on 2018/8/3.
 */
public class ControllerTemplateEntity implements TemplateEntity{
    private String templatePackage;//包名
    private String modelClazz;//对应的model类
    private String className;//生成的ServiceImpl类名
    private String modelName;//对应的model名
    private String projectTargetPackage;//Service生成的目标工程包
    private String generatedDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//代码生成日期
    private String generatedTime =  new SimpleDateFormat("HH:mm").format(new Date());//代码生成时间

    public String getTemplatePackage() {
        return templatePackage;
    }

    public void setTemplatePackage(String templatePackage) {
        this.templatePackage = templatePackage;
    }

    public String getModelClazz() {
        return modelClazz;
    }

    public void setModelClazz(String modelClazz) {
        this.modelClazz = modelClazz;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProjectTargetPackage() {
        return projectTargetPackage;
    }

    public void setProjectTargetPackage(String projectTargetPackage) {
        this.projectTargetPackage = projectTargetPackage;
    }
}
