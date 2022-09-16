package com.example.demorosenwald.service;


import com.example.demorosenwald.entity.SchoolBuilding;
import com.example.demorosenwald.repository.SchoolBuildingRepository;
import com.example.demorosenwald.util.CSVtoDb;
import com.example.demorosenwald.util.StringSeparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;



@Slf4j
@Service
@RequiredArgsConstructor
public class RosenwaldSchoolBuildingService {

    @Autowired
    private final SchoolBuildingRepository schoolDataRepository;

    private final CSVtoDb csvtoDb;

    private final StringSeparator stringSeparator;

    private final int pageSize = 180;


    public SchoolBuilding saveSchoolBuilding(SchoolBuilding schoolBuilding){
        return schoolDataRepository.save(schoolBuilding);
    }

    public List<SchoolBuilding> saveAllSchools(List<SchoolBuilding> schoolBuildings){
        return schoolDataRepository.saveAll(schoolBuildings);
    }

    public List<SchoolBuilding> getAllSchoolBuildings(){
        return getAllUniqueSchoolBuildings();
//        return schoolDataRepository.getAllSchoolBuilding();
    }

    public SchoolBuilding getBuildingByUID(String UID){
        return schoolDataRepository.findById(UID).orElseThrow(() -> new NoSuchElementException("school not found"));
    }

    public SchoolBuilding updateSchoolBuilding(String UID, SchoolBuilding schoolDataDto){
        SchoolBuilding schoolBuilding = getBuildingByUID(UID);

        schoolBuilding.setSchoolNames(schoolDataDto.getSchoolNames());
        schoolBuilding.setAlternateNames(schoolDataDto.getAlternateNames());
        schoolBuilding.setCounty(schoolDataDto.getCounty());
        schoolBuilding.setState(schoolDataDto.getState());
        schoolBuilding.setTitle(schoolDataDto.getTitle());
        schoolBuilding.setDescription(schoolDataDto.getDescription());

        return schoolBuilding;
    }

    public List<String> getSchoolBuildingPhotoIDs(String title){
        return schoolDataRepository.getSchoolPhotoIDs(title);
    }


    public Page<SchoolBuilding> findPaginated(PageRequest pageRequest) {
        int currentPage = pageRequest.getPageNumber();
        int startIndex = currentPage * pageSize;

        List<SchoolBuilding> subSchoolBuildings;

        int schoolSize = getAllSchoolBuildings().size();



        if (schoolSize < startIndex) {
            subSchoolBuildings = Collections.emptyList();
        } else {
            int endIndex = Math.min(startIndex + pageSize, schoolSize);
            subSchoolBuildings = getAllSchoolBuildings().subList(startIndex, endIndex);
        }

        Page<SchoolBuilding> schoolBuildingPage = new PageImpl<SchoolBuilding>(subSchoolBuildings, PageRequest.of(currentPage, pageSize), schoolSize);

        return  schoolBuildingPage;
    }

    /**
     *Temporary method use to find the unique school, this is not the best way to get the data! slow
     */
    public List<SchoolBuilding> getAllUniqueSchoolBuildings() {
        List<SchoolBuilding> uniqueSchools = new ArrayList<>();
        HashSet titles = new HashSet();
        for (SchoolBuilding schoolBuilding: schoolDataRepository.findAll()){
            if (!titles.contains(schoolBuilding.getTitle())){
                uniqueSchools.add(schoolBuilding);
            }
            titles.add(schoolBuilding.getTitle());
        }
        return uniqueSchools;
    }

        public void saveCsv() {
        try {
            csvtoDb.schoolBuildingCSVToDb(csvtoDb.getSCHOOL_DATA_URL());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!csvtoDb.getAllSchoolData().isEmpty()) {
            System.out.println(csvtoDb.getAllSchoolData().size());
            saveAllSchools(csvtoDb.getAllSchoolData());
            System.out.println("HERE211111111111111111111111111111111111111111111111111111111111111111");
        }
    }




}