package com.example.demorosenwald.controller;

import com.example.demorosenwald.entity.SchoolBuilding;
import com.example.demorosenwald.entity.SchoolFund;
import com.example.demorosenwald.service.RosenwaldSchoolBuildingService;
//import com.example.demorosenwald.service.RosenwaldSchoolFundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/rosenwald/")
public class SchoolController {

//    private final RosenwaldSchoolBuildingService rosenwaldSchoolBuildingService;

//    private final RosenwaldSchoolFundService rosenwaldSchoolFundService;

    @RequestMapping("/school")
    public String school() {
    // public String school(@PathVariable (value = "uid") String uid) {
        /**
         * To do
         * UID is the photoID, create a method to get them
         * retrieve the uid from the web
         * use the uid to retrieve the schoolBuilding file
         * get the "title" column from the schoolBuilding
         * use the title to retrieve the data info from schoolFund
         * check if the data is empty, if true, display information from schoolBuilding
         * else display data from
         */
//        List<String> photoIds = new ArrayList<>();
//
//        SchoolBuilding schoolBuilding = rosenwaldSchoolBuildingService.getBuildingByUID(uid);
//        String titleOfSchool = schoolBuilding.getTitle();
//
//        SchoolFund schoolFund = rosenwaldSchoolFundService.getSchoolFundByTitle(titleOfSchool);
//
//        photoIds.addAll(rosenwaldSchoolBuildingService.getSchoolBuildingPhotoIDs(titleOfSchool));

        return "school";
    }

}
