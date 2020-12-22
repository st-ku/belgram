package com.example.belgram.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class ImageFile {
    @Id
    private Long id;
    @Column(columnDefinition = "varchar(255) default 'not defined'")
    @NotBlank(message = "Please fill the filename")
    @Length(max = 255, message = "Filename too long")
    private String fileName;
    @Lob
    private byte[] data;
}
