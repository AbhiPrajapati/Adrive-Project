package com.adrive.ADrive.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.GeneratorStrategy;

import java.util.Date;

@Entity(name = "files")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFiles {

    @Id
    private int id;
    private String fileName;
    private String extension;
    private String size;
    private Date lastupdate;
    @Lob // This annotation tells JPA to store the field as a BLOB
    @Column(name = "data", columnDefinition = "BLOB")
    private String data;
}
