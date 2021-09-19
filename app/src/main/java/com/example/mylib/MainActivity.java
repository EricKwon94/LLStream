package com.example.mylib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.github.llstream.LLStream;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

class Base {

}

class Person extends Base {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(10);
        list.add(15);
        list.add(35);

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("apple", 1);
        map.put("apple2", 2);
        map.put("banana", 2);
        map.put("cpple3", 3);

        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(300);

        String[] str = new String[]{"11", "12", "13"};
        Person[] people = new Person[]{new Person("k", 10)};
        int[] nums = {0,2,1,3,100};

        String[] result = LLStream.filter(str, s -> s.equals("a"));
        Person[] result2 = LLStream.filter(people, elem -> elem.age == 10);
        int[] result3 = LLStream.filter(nums, elem -> elem == 1);
        ArrayList<Integer> result4 = LLStream.filter(list, elem -> elem == 1);
        TreeMap<String, Integer> result5 = LLStream.filter(map, elem -> elem.getKey().equals("banana"));
        TreeSet<Integer> result6 = LLStream.filter(set, elem -> elem == 3);


        TreeMap<String, Integer> result7 = LLStream.takeLast(map, 2);
        TreeSet<Integer> result8 = LLStream.takeLast(set, 2);
        ArrayList<Integer> result9 = LLStream.takeLast(list, 3);
        int[] result10 = LLStream.takeLast(nums,2);
        int[] result11 = LLStream.skipLast(nums,2);
        int[] result12 = LLStream.skipTakeLast(nums,2,2);

        int result13=LLStream.indexOf(nums,elem->elem==100);
        int result14=LLStream.indexOf(set,elem->elem==300);

        Object result15=LLStream.get(map,30);
        int result16=LLStream.get(set,5);


        int i = 10;
    }
}