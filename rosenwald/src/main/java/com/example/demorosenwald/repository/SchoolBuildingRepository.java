package com.example.demorosenwald.repository;


import com.example.demorosenwald.entity.SchoolBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolBuildingRepository extends JpaRepository<SchoolBuilding, String> {

//    List<SchoolBuildingng> findDistinctByTitle();

    @Query("SELECT new com.example.demorosenwald.util.uidProjections(s.UID) FROM SchoolBuilding s WHERE s.Title =: title" )
    List<String> getSchoolPhotoIDs(@Param("title") String title);

    // this query failed after working fore some time, to-do use a diction
    @Query("SELECT s FROM SchoolBuilding AS s group by s.Title")
    List<SchoolBuilding> getAllSchoolBuilding();

    List<SchoolBuilding> findAll();



//    @Query(value="select first_name, last_name from Users u where u.user_id =:userId", nativeQuery=true)
//    List<Object[]> getUserFullNameById(@Param("userId") String userId);

}
