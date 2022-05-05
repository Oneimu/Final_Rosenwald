package com.example.demorosenwald.service;


import com.example.demorosenwald.dto.SchoolDataDto;
import com.example.demorosenwald.entity.SchoolBuilding;
import com.example.demorosenwald.repository.SchoolDataRepository;
import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Service
@Getter
public class RosenwaldSchoolBuildingService {
    private static String SCHOOL_DATA_URL = "https://raw.githubusercontent.com/Aayush000/Rosenwald_Library/main/schools/school_metadata.csv";

    @Autowired
    private final SchoolDataRepository schoolDataRepository;

    private List<SchoolBuilding> schoolBuildingList;

    private final int pageSize = 180;

    // allSchoolData contain the raw entry of the csv files
    private List<SchoolBuilding> allSchoolData = new ArrayList<>();

    private SchoolDataDto schoolDataDto;

    public RosenwaldSchoolBuildingService(SchoolDataRepository schoolDataRepository) {
        this.schoolDataRepository = schoolDataRepository;
        schoolBuildingList = schoolDataRepository.getAllSchoolBuilding();
    }

    @PostConstruct
//    @Scheduled(cron = "* * 1 * * *") //run once every day
    public void RosenwaldSchoolDataService() throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(SCHOOL_DATA_URL)).build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(httpResponse.body());

        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {

            schoolDataDto = new SchoolDataDto();

            schoolDataDto.setAlternateNames(record.get("Alternate Names"));
            schoolDataDto.setAppl(record.get("Appl #"));
            schoolDataDto.setCounty(record.get("County"));
            schoolDataDto.setSchoolNames(record.get("School Names"));
            schoolDataDto.setCreator(record.get("Creator"));
            schoolDataDto.setSchoolCardId(record.get("School Card ID"));
            schoolDataDto.setPhotoId(record.get("Photo ID #"));
            schoolDataDto.setFormat(record.get("Format"));
            schoolDataDto.setDescription(record.get("Description"));
            schoolDataDto.setPublisher(record.get("Publisher"));
            schoolDataDto.setTitle(record.get("Title"));
            schoolDataDto.setRights(record.get("Rights"));
            schoolDataDto.setOriginalDate(record.get("Date.Original"));
            schoolDataDto.setUID(record.get("UID"));
            schoolDataDto.setState(record.get("State"));
            schoolDataDto.setSource(record.get("Source"));
            schoolDataDto.setSubject(record.get("Subject"));

            allSchoolData.add(schoolDataDto.toEntity());

        }

    }

    public void csvToDb() {
        if (!allSchoolData.isEmpty()) {
            schoolDataRepository.saveAll(allSchoolData);
        }
    }

    /**
     * FUTURE WORK
     * addSchool
     * update csv
     * delete
     */

    /**
     * CURRENT WORK
     * query the dataset (get all unique data based on county, state and school name)
     * pagination
     */

    public Page<SchoolBuilding> findPaginated(PageRequest pageRequest) {
        int currentPage = pageRequest.getPageNumber();
        int startIndex = currentPage * pageSize;

        List<SchoolBuilding> subSchoolBuildings;

        if (schoolBuildingList.size() < startIndex) {
            subSchoolBuildings = Collections.emptyList();
        } else {
            int endIndex = Math.min(startIndex + pageSize, schoolBuildingList.size());
            subSchoolBuildings = schoolBuildingList.subList(startIndex, endIndex);
        }

        Page<SchoolBuilding> schoolBuildingPage = new PageImpl<SchoolBuilding>(subSchoolBuildings, PageRequest.of(currentPage, pageSize), schoolBuildingList.size());

        return  schoolBuildingPage;
    }





}