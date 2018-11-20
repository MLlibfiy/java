package com.shujia.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {

        Dog dog = new Dog("布丁",2);
        Person person = new Person("张三", 23, dog);


        Dog dog1 = new Dog("小",2);
        Person person2 = new Person("李四", 23, dog1);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person2);

        Gson gson = new Gson();
        String json = gson.toJson(person);

        String jsons = gson.toJson(persons);
        System.out.println(jsons);

        List<Person> lists =  gson.fromJson(jsons,new TypeToken<ArrayList<Person>>(){}.getType());


        for (Person list : lists) {
            System.out.println(list);
        }


    }
}
