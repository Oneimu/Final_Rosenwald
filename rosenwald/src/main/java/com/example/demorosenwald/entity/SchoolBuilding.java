package com.example.demorosenwald.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="rosenwald_schools")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolBuilding implements Serializable {

    @Id
    @Column(updatable = false, nullable = false)
    private String UID;

    private String State;

    private String County;

    private String schoolNames;

    private String alternateNames;

    private String Appl;

    private String originalDate;

    private String Title;

    private String Subject;

    @Column(length = 3000)
    private String Description;

    private String Creator;

    private String Source;

    private String Publisher;

    @Column(length = 3000)
    private String Rights;

    private String Format;

    private String schoolCardId;

    private String photoId;


}
