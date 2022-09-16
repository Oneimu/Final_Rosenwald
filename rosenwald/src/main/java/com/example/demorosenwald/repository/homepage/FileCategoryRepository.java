package com.example.demorosenwald.repository.homepage;

import com.example.demorosenwald.entity.homepage.FileCategoryInfo;
import com.example.demorosenwald.enums.FileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileCategoryRepository extends JpaRepository<FileCategoryInfo, Long> {

    Optional<FileCategoryInfo> findByFileCategory(FileType fileType);
}
