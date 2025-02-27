package com.example.tgdd.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tgdd_user")
public class TgddUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long roleId;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private gender gender;
    private String avatar;
    private String createdAt;
    private String updatedAt;

    public enum gender {
        MALE, FEMALE
    }
}
