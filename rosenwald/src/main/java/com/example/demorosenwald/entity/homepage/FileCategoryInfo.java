package com.example.demorosenwald.entity.homepage;

import com.example.demorosenwald.entity.base.BaseModel;
import com.example.demorosenwald.enums.FileType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="file_category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileCategoryInfo implements Serializable {

    // this is the same as the file name, it is an enum type

    @Id
    @Column(nullable = false)
    private FileType fileCategory;

    private String description;

    // might be change to list of urls sometime in the future. for now, one image for one category
    private String imageUrl;

}
