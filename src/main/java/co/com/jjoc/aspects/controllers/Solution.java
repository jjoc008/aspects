package co.com.jjoc.aspects.controllers;

import co.com.jjoc.aspects.model.Response;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args){
        Class response = Response.class;
        Method[] methods = response.getMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method: methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}
