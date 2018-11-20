package com.shujia.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();

        FileReader fileReader = new FileReader("E:\\bigdata\\java\\src\\com\\shujia\\json\\students.json");

        List<Student> lists = gson.fromJson(fileReader, new TypeToken<ArrayList<Student>>(){}.getType());

        for (Student s : lists) {
            System.out.println(s);
        }



    }
}
