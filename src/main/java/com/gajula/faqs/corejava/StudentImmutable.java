package com.gajula.faqs.corejava;

import java.util.HashMap;
import java.util.Map;

final class Student {

    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    public Student(String name, int regNo,Map<String, String> metadata){
        this.name = name;
        this.regNo = regNo;
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
       this.metadata = tempMap;
    }

    public String getName() { return name; }
    public int getRegNo() { return regNo; }
    public Map<String, String> getMetadata(){
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

class StudentImmutable {

    // Main driver method
    public static void main(String[] args){

        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        Student s = new Student("ABC", 101, map);
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());
        map.put("3", "third");
        System.out.println(s.getMetadata());
        s.getMetadata().put("4", "fourth");
        System.out.println(s.getMetadata());
    }
}