package com.example.belgram.entity.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @Transient
    private String passwordConfirm;
    @Column(columnDefinition = "varchar(255) default 'not defined'")
    @Email(message = "Email cannot be empty")
    private String email ;
    @Column(columnDefinition = "varchar(255) default 'not defined'")
    private String phoneNumber = "0";
    @OneToOne(cascade = CascadeType.PERSIST)
    private Role role;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<com.example.belgram.entity.Record> userRecords = new ArrayList<>();

    public User() {

    }

    public boolean isAdmin() {
        return this.getRole().getName().equals("ROLE_ADMIN");
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
