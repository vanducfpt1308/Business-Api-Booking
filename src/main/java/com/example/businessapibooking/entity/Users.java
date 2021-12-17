package com.example.businessapibooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "username")
    private String username;

    private String password;

    @Column(name="is_enable")
    private boolean isEnable;

    @Column(name="is_locked")
    private boolean isLocked;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    @OneToOne(mappedBy = "user")
    private Staff staff;

    @OneToOne(mappedBy = "user")
    private Customer customer;

}
