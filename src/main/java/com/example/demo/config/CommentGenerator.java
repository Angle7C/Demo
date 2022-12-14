package com.example.demo.config;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;
import java.util.Set;
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String MAPPER_SUFFIX="MAPPER";
    private static final String API_MODEL_PROERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";
    private static final String ALL_CONSTRUCTOR = "lombok.AllArgsConstructor";
    private static final String NO_CONSTRUCTOR= "lombok.NoArgsConstructor";

    @Override
    public void addConfigurationProperties(Properties props) {
        super.addConfigurationProperties(props);
        this.addRemarkComments = StringUtility.isTrue(props.getProperty("addRemarkComments"));
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        super.addModelClassComment(topLevelClass, introspectedTable);
        topLevelClass.addAnnotation("@AllArgsConstructor");
        topLevelClass.addAnnotation("@NoArgsConstructor");
        topLevelClass.addImportedType(NO_CONSTRUCTOR);
        topLevelClass.addImportedType(ALL_CONSTRUCTOR);

    }


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            addFieldJavaDoc(field,remarks);
            if (remarks.contains("\"")) {
                remarks.replace("\"", "'");
            }
            field.addJavaDocLine("@ApiModelProperty(value = \""+remarks+"\")");
        }
    }
    private void addFieldJavaDoc(Field field, String remarks) {
        //??????????????????
        field.addJavaDocLine("/**");
        //????????????????????????????????????
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for(String remarkLine:remarkLines){
            field.addJavaDocLine(" * "+remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        super.addFieldAnnotation(field, introspectedTable, imports);
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        if(!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)&&!compilationUnit.getType().getFullyQualifiedName().contains(MAPPER_SUFFIX)){
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROERTY_FULL_CLASS_NAME));
//            compilationUnit.addImportedType(new FullyQualifiedJavaType(NO_CONSTRUCTOR));
//            compilationUnit.addImportedType(new FullyQualifiedJavaType(ALL_CONSTRUCTOR));
        }
    }

}
