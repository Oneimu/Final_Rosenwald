package com.example.demorosenwald.repository;


import com.example.demorosenwald.dto.uidProjections;
import com.example.demorosenwald.entity.SchoolBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolDataRepository extends JpaRepository<SchoolBuilding, String> {

//    List<SchoolBuilding> findDistinctFirstByTitle();

    @Query("SELECT new com.example.demorosenwald.dto.uidProjections(s.UID) FROM SchoolBuilding s WHERE s.Title =: title" ) //com.example.demorosenwald.service.RosenwaldSchoolBuildingService")
    List<String> getSchoolUIDs(@Param("title") String title);

    @Query("SELECT s FROM SchoolBuilding AS s group by s.Title")
    List<SchoolBuilding> getAllSchoolBuilding();



//    @Query(value="select first_name, last_name from Users u where u.user_id =:userId", nativeQuery=true)
//    List<Object[]> getUserFullNameById(@Param("userId") String userId);

}
