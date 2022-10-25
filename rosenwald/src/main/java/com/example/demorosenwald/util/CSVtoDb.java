package com.example.demorosenwald.util;

import com.example.demorosenwald.dto.SchoolDataDto;
import com.example.demorosenwald.dto.SchoolFundDto;
import com.example.demorosenwald.entity.SchoolBuilding;
import com.example.demorosenwald.entity.SchoolFund;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
@Getter
public class CSVtoDb {

    private final String SCHOOL_DATA_URL = "https://raw.githubusercontent.com/Aayush000/Rosenwald_Library/main/schools/school_metadata.csv";

    private final String FUND_DATA_URL = "https://raw.githubusercontent.com/Aayush000/Rosenwald_Library/main/schools/fund_metadata.csv";

    private List<SchoolBuilding> allSchoolData = new ArrayList<>();

    private List<SchoolFund> allSchoolFund = new ArrayList<>();


    public void schoolBuildingCSVToDb(String URL) throws IOException, InterruptedException {

        Iterable<CSVRecord>  records = readURL(URL);

        SchoolDataDto schoolDataDto;

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

    public void schoolFundCSVToDb(String URL) throws IOException, InterruptedException {

        Iterable<CSVRecord>  records = readURL(URL);

        SchoolFundDto schoolFundDto;

        for (CSVRecord record : records) {

            schoolFundDto = new SchoolFundDto();

            schoolFundDto.setAlternateNames(record.get("Alternate Names"));
            schoolFundDto.setAppl(record.get("Appl #"));
            schoolFundDto.setCounty(record.get("County"));
            schoolFundDto.setSchoolNames(record.get("School Names"));
            schoolFundDto.setCreator(record.get("Creator"));
            schoolFundDto.setSchoolPhotoId(record.get("School Photo ID"));
            schoolFundDto.setItemNumber(record.get("Item Number"));
            schoolFundDto.setFormat(record.get("Format"));
            schoolFundDto.setDescription(record.get("Description"));
            schoolFundDto.setPublisher(record.get("Publisher"));
            schoolFundDto.setTitle(record.get("Title"));
            schoolFundDto.setRights(record.get("Rights"));
            schoolFundDto.setOriginalDate(record.get("Date.Original"));
            schoolFundDto.setUID(record.get("UID"));
            schoolFundDto.setState(record.get("State"));
            schoolFundDto.setSource(record.get("Source"));
            schoolFundDto.setSubject(record.get("Subject"));
            schoolFundDto.setAcreage(record.get("Acreage"));
            schoolFundDto.setBudgetYear(record.get("Budget Year"));
            schoolFundDto.setTotalCost(record.get("Total Cost"));
            schoolFundDto.setTeacherType(record.get("Teacher Type"));
            schoolFundDto.setNegroesContribution(record.get("Negroes Contribution"));
            schoolFundDto.setWhitesContribution(record.get("Whites Contribution"));
            schoolFundDto.setPublicContribution(record.get("Public Contribution"));
            schoolFundDto.setRosenwaldContribution(record.get("Rosenwald Contribution"));

            allSchoolFund.add(schoolFundDto.toEntity());

        }

    }




    private Iterable<CSVRecord> readURL(String URL) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(httpResponse.body());

        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        return records;
    }
}
