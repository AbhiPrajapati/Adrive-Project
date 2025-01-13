package com.adrive.ADrive.service;

import com.adrive.ADrive.model.UserFiles;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilesService {

    public ResponseEntity<UserFiles> upload(UserFiles files);
    public ResponseEntity<UserFiles> fetchFile(int id);
    public List<ResponseEntity<UserFiles>> findAll();
}
