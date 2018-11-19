package com.shujia.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 读取数据工具
 */
public class DataUtil {

    public static ArrayList<String> load(String path) {
        ArrayList<String> lists = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {//监控异常代码块
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            String line ;
            while ((line = bufferedReader.readLine())!=null){
                lists.add(line);
            }

        } catch (FileNotFoundException e) {//处理异常的代码块，如果出现了异常会执行eatch代码
            //打印堆栈信息，也就是异常信息
            System.out.println("文件找不到");
//            e.printStackTrace();
        } catch (IOException e) {//eatch根据异常类型捕获异常
            e.printStackTrace();
        } finally {//不管是否发生异常都会执行
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("数据加载完成");

        return lists;
    }
}
