package com.shujia.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 生产xml文档
 *
 */
public class Demo2 {

    public static void main(String[] args) throws IOException {
        /**
         * 创建一颗空的树
         */
        Document document = DocumentHelper.createDocument();

        //构建根节点
        Element students = document.addElement("students");
        //增加属性
        students.addAttribute("msg","学生信息");
        //增加子节点
        Element student = students.addElement("student");
        //增加属性
        student.addAttribute("id","1500100005");
        /**
         * 增加子节点
         */
        Element name = student.addElement("name");
        name.setText("宣谷芹");
        Element age = student.addElement("age");
        age.setText("22");
        Element gender = student.addElement("gender");
        gender.setText("女");
        Element clazz = student.addElement("clazz");
        clazz.setText("理科五班");

        //将Document保存到文件
        /**
         * 格式化器
         * 输出的文档自动对齐
         */
        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding();//可以设置文件额编码方式
        XMLWriter writer = new XMLWriter(new FileWriter("E:\\bigdata\\java\\src\\com\\shujia\\xml\\newStudent.xml"),format);
        writer.write(document);
        writer.close();

    }

}
