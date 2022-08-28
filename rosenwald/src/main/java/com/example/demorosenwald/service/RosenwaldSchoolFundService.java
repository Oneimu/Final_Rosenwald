//package com.example.demorosenwald.service;
//
//
//import com.example.demorosenwald.entity.SchoolFund;
//import com.example.demorosenwald.repository.SchoolFundRepository;
//import com.example.demorosenwald.util.CSVtoDb;
//import com.example.demorosenwald.util.StringSeparator;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
//@RequiredArgsConstructor
//public class RosenwaldSchoolFundService {
//
//    private final SchoolFundRepository schoolFundRepository;
//
//    private final CSVtoDb csvtoDb;
//
//    private final StringSeparator stringSeparator;
//
//    public SchoolFund saveSchoolFund(SchoolFund schoolFund) {
//        return schoolFundRepository.save(schoolFund);
//    }
//
//    public List<SchoolFund> saveAllSchoolFunds(List<SchoolFund> schoolFunds) {
//        return schoolFundRepository.saveAll(schoolFunds);
//    }
//
//    public SchoolFund updateSchoolBuilding(String UID, SchoolFund schoolFund) {
//        SchoolFund updateSchoolFund = getSchoolFundByUID(UID);
//
//        updateSchoolFund.setSchoolNames(schoolFund.getSchoolNames());
//        updateSchoolFund.setAlternateNames(schoolFund.getAlternateNames());
//        updateSchoolFund.setCounty(schoolFund.getCounty());
//        updateSchoolFund.setState(schoolFund.getState());
//        updateSchoolFund.setTitle(schoolFund.getTitle());
//        updateSchoolFund.setDescription(schoolFund.getDescription());
//
//        return updateSchoolFund;
//    }
//
//    public SchoolFund getSchoolFundByUID(String UID) {
//        return schoolFundRepository.findById(UID).orElseThrow(() -> new NoSuchElementException("school not found"));
//    }
//
//    public List<SchoolFund> getAllSchoolFundByTitle(String title){
//        return null;
////        return schoolFundRepository.findAllByTitle(title);
//    }
//
//    public List<SchoolFund> getAllSchoolFunds() {
//        return schoolFundRepository.findAll();
//    }
//
//    public SchoolFund getSchoolFundsByTitle(String title) {
//        return schoolFundRepository.findSchoolFundByTitle(title);
//    }
//
//    public void saveCsv() {
//        try {
//            csvtoDb.schoolFundCSVToDb(csvtoDb.getFUND_DATA_URL());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        if (!csvtoDb.getAllSchoolFund().isEmpty()) {
//            saveAllSchoolFunds(csvtoDb.getAllSchoolFund());
//        }
//    }
//
//}
