package com.example.demorosenwald.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StringSeparator {

    public List<String> splitString(List<String> stringList, String separatorKey){

        List<String> resultingList = new ArrayList<>();

        for (String string: stringList){
            resultingList.addAll(List.of(string.split(separatorKey)));
        }
        return resultingList;
    }
}
