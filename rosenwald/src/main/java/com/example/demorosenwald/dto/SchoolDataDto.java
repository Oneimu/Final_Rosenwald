package com.example.demorosenwald.dto;

import com.example.demorosenwald.entity.SchoolBuilding;
import lombok.Data;

@Data
public class SchoolDataDto {
    private String UID;

    private String State;

    private String County;

    //    @Column(name = "School Names")
    private String schoolNames;

    //    @Column(name = "Alternate Names")
    private String alternateNames;

    //    @Column(name = "Appl #")
    private String Appl;

    //    @Column(name = "Date.Original")
    private String originalDate;

    private String Title;

    private String Subject;

    private String Description;

    private String Creator;

    private String Source;

    private String Publisher;

    private String Rights;

    private String Format;

    //    @Column(name = "School Card ID")
    private String schoolCardId;

    //    @Column(name = "Photo ID #")
    private String photoId;

    public SchoolBuilding toEntity(){
        SchoolBuilding schoolData = new SchoolBuilding();

        schoolData.setAlternateNames(schoolNames);
        schoolData.setAppl(Appl);
        schoolData.setCounty(County);
        schoolData.setSchoolNames(schoolNames);
        schoolData.setCreator(Creator);
        schoolData.setSchoolCardId(schoolCardId);
        schoolData.setPhotoId(photoId);
        schoolData.setFormat(Format);
        schoolData.setDescription(Description);
        schoolData.setPublisher(Publisher);
        schoolData.setTitle(Title);
        schoolData.setRights(Rights);
        schoolData.setOriginalDate(originalDate);
        schoolData.setUID(UID);
        schoolData.setState(State);
        schoolData.setSource(Source);
        schoolData.setSubject(Subject);

        return schoolData;

    }
}
