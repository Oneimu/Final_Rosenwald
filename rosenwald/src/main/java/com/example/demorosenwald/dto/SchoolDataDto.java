package com.example.demorosenwald.dto;

import com.example.demorosenwald.entity.SchoolBuilding;
import lombok.Data;

@Data
public class SchoolDataDto {
    private String UID;

    private String State;

    private String County;

    private String schoolNames;

    private String alternateNames;

    private String Appl;

    private String originalDate;

    private String Title;

    private String Subject;

    private String Description;

    private String Creator;

    private String Source;

    private String Publisher;

    private String Rights;

    private String Format;

    private String schoolCardId;

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
