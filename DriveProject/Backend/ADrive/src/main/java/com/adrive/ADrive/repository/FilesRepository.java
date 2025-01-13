package com.adrive.ADrive.repository;

import com.adrive.ADrive.model.UserFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<UserFiles, Integer> {
}
