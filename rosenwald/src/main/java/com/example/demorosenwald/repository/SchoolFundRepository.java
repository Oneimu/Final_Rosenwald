//package com.example.demorosenwald.repository;
//
//
//import com.example.demorosenwald.entity.SchoolBuilding;
//import com.example.demorosenwald.entity.SchoolFund;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface SchoolFundRepository extends JpaRepository<SchoolFund, String> {
//
////    List<SchoolFund> findAllByTitle(String title);
//
//    SchoolFund findSchoolFundByTitle(String title);
//
////    @Query("SELECT new com.example.demorosenwald.util.uidProjections(s.UID) FROM SchoolFund s WHERE s.Title =: title" ) //com.example.demorosenwald.service.RosenwaldSchoolBuildingService")
////    List<String> getSchoolFundPhotoIDs(@Param("title") String title);
//
////    List<SchoolFund> getAllByTitle(String title);
//
////    @Query("SELECT s FROM SchoolFund AS s group by s.Title")
////    List<SchoolFund> getAllSchoolFund();
//
//
////    SchoolFund getSchoolFundByTitle(String s);
//}
