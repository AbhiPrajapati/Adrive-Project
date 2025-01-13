package com.adrive.ADrive.service.impl;

import com.adrive.ADrive.model.UserFiles;
import com.adrive.ADrive.repository.FilesRepository;
import com.adrive.ADrive.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesRepository filesRepository;

    @Override
    public ResponseEntity<UserFiles> upload(UserFiles files) {
        return  ResponseEntity.ok(filesRepository.save(files));
    }

    @Override
    public ResponseEntity<UserFiles> fetchFile(int id) {
        Optional<UserFiles> userFiles = filesRepository.findById(id);
        if(userFiles.isEmpty())
            return (ResponseEntity<UserFiles>) ResponseEntity.notFound();
        else
            return  ResponseEntity.ok(userFiles.get());
    }

    @Override
    public List<ResponseEntity<UserFiles>> findAll() {
        return (List<ResponseEntity<UserFiles>>) ResponseEntity.ok(filesRepository.findAll());
    }
}
