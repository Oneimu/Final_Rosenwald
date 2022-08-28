package com.example.demorosenwald.controller;

import com.example.demorosenwald.service.RosenwaldSchoolBuildingService;
//import com.example.demorosenwald.service.RosenwaldSchoolFundService;
import com.example.demorosenwald.util.UniqueSchoolName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RosenwaldSchoolBuildingService rosenwaldSchoolBuildingService;
    private final UniqueSchoolName uniqueSchoolName;

    @RequestMapping("/")
    public String home(Model model) {

//        rosenwaldSchoolBuildingService.saveCsv();
//        uniqueSchoolName.updateSchoolName();
        model.addAttribute("schools", rosenwaldSchoolBuildingService.getAllSchoolBuildings().subList(1, 10));
        return "index";
    }
}
