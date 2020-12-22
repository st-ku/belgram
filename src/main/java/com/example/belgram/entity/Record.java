package com.example.belgram.entity;

import com.example.belgram.entity.security.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;
    @Column(columnDefinition = "varchar(255) default 'not defined'")
    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message too long")
    @CreationTimestamp
    private Date creationDate;
    private String textDescription;
    @NotBlank
    @OneToOne(cascade = CascadeType.REFRESH)
    private User user;
    @NotBlank
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ImageFile> imageFiles = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<TextComment> textComments = new ArrayList<>();
}
