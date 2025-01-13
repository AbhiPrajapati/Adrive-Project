package com.adrive.ADrive.controller;

import com.adrive.ADrive.model.UserFiles;
import com.adrive.ADrive.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/files")
public class FilesController {

    @Autowired
    private FilesService filesService;


    @PostMapping
    public ResponseEntity<UserFiles> upload(UserFiles file)
    {
        return filesService.upload(file);
    }

    @GetMapping
    public ResponseEntity<UserFiles> fetchFile(int id)
    {
        return filesService.fetchFile(id);
    }

    @GetMapping
    public List<ResponseEntity<UserFiles>> findAll()
    {
        return filesService.findAll();
    }
}
