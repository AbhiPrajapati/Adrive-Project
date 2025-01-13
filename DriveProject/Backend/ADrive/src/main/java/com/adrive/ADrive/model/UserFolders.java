package com.adrive.ADrive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "folders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFolders {

    @Id
    private int id;
    private String folderName;
    private String parentId;
    private int fileId;
    private Date lastUpdate;

}
