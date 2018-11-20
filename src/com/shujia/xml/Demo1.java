package com.shujia.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * 解析xml文档
 *
 */
public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        File file = new File("E:\\bigdata\\java\\src\\com\\shujia\\xml\\students.xml");
        SAXReader saxReader = new SAXReader();
        /**
         * 创建xml文件Document对象
         *
         * 创建document对象方式
         * 1、通过文件创建
         * 2、通过字节输入流创建
         * 3、通过字符流输入创建
         *
         */
        Document document = saxReader.read(file);

        //获取文档根节点
        Element rootElement = document.getRootElement();
        //获取元素的文本
        String text = rootElement.getText();
//        System.out.println(text);

        //获取子节点
        Iterator iterator = rootElement.elementIterator();

        while (iterator.hasNext()) {
            //一个一个student
            Element next = (Element) iterator.next();
            //获取元素的属性,更具属性名获取属性
            Attribute id = next.attribute("id");
            //获取属性值
            System.out.print(id.getName()+":"+id.getValue()+",");

            Iterator iterator1 = next.elementIterator();

            while (iterator1.hasNext()) {
                Element next1 = (Element) iterator1.next();
                //获取元素名
                String n = next1.getName();
                //获取元素内容
                String value = next1.getText();
                System.out.print(n + ":" + value+",");

            }
            System.out.println();
        }
    }
}
