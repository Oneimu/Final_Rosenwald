package com.example.demorosenwald.dataControllers;

import com.example.demorosenwald.service.RosenwaldSchoolBuildingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final RosenwaldSchoolBuildingService rosenwaldSchoolDataService;

    public HomeController(RosenwaldSchoolBuildingService rosenwaldSchoolDataService) {
        this.rosenwaldSchoolDataService = rosenwaldSchoolDataService;
//        rosenwaldSchoolDataService.csvToDb();
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("schools", rosenwaldSchoolDataService.getSchoolBuildingList().subList(1, 10));
        return "index";
    }
}
