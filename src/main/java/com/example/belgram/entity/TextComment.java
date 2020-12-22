package com.example.belgram.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class TextComment {
    @Id
    private Long userId;
    @Column(columnDefinition = "varchar(255) default 'not defined'")
    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message too long")
    private String text;

}
