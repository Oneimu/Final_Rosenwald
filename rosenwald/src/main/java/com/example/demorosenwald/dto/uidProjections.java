package com.example.demorosenwald.dto;

import lombok.Data;

import java.util.List;

@Data
public class uidProjections {

    private List<String> listUID;

    public uidProjections(String uid) {
        listUID.add(uid);
    }
}
