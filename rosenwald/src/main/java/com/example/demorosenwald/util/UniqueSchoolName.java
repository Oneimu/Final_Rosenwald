package com.example.demorosenwald.util;

import com.example.demorosenwald.entity.SchoolBuilding;
import com.example.demorosenwald.service.RosenwaldSchoolBuildingService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UniqueSchoolName {

    private final RosenwaldSchoolBuildingService rosenwaldSchoolBuildingService;

    public void updateEmptySchoolName(SchoolBuilding schoolBuilding){
        SchoolBuilding updatedSchoolBuilding = schoolBuilding;
        updatedSchoolBuilding.setSchoolNames(schoolBuilding.getCounty()+" School");

        rosenwaldSchoolBuildingService.updateSchoolBuilding(updatedSchoolBuilding.getUID(), updatedSchoolBuilding);
    }

    public void updateSchoolName(){

        List<SchoolBuilding> allSchoolBuildings = rosenwaldSchoolBuildingService.getAllSchoolBuildings();

        HashSet<String> uniqueSchoolNames = new HashSet<>();

        String name = "";

        for (SchoolBuilding schoolBuilding: allSchoolBuildings){
            name = schoolBuilding.getSchoolNames();
            if (name.isEmpty() || name == "" || name == " " ||  uniqueSchoolNames.contains(name)|| name.contains("County Training School")
                || name.contains("unknown")){
                updateEmptySchoolName(schoolBuilding);
            }

            uniqueSchoolNames.add(name);
        }


    }

    public boolean reduceNameLength(String name){
        String[] spiltName = name.split(" ");

        return spiltName.length > 4;
    }
}
