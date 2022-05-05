package com.example.demorosenwald.dataControllers;

import com.example.demorosenwald.entity.SchoolBuilding;
import com.example.demorosenwald.service.RosenwaldSchoolBuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class SchoolBuildingController{

    private RosenwaldSchoolBuildingService rosenwaldSchoolBuildingService;

    public SchoolBuildingController(RosenwaldSchoolBuildingService rosenwaldSchoolBuildingService) {
        this.rosenwaldSchoolBuildingService = rosenwaldSchoolBuildingService;
    }


    @RequestMapping(value = "/all_schools", method = RequestMethod.GET)
    public String allSchools(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(12);

        Page<SchoolBuilding> schoolBuildingPage = rosenwaldSchoolBuildingService.findPaginated(PageRequest.of(currentPage-1, pageSize));

        model.addAttribute("schoolBuildingPage", schoolBuildingPage.getContent());

        int totalPages = schoolBuildingPage.getTotalPages();

        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("totalItems", pageSize);
        model.addAttribute("currentPage", currentPage);

        return "all_schools";
    }



}
