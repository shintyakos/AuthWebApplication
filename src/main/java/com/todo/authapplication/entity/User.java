package com.todo.authapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "user")
@EqualsAndHashCode(of = {"userId"})
@ToString(exclude = {"password"})
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "password", length = 60)
    private String password;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ColumnDefault("0")
    @Column(name = "is_deleted")
    private boolean isDeleted;

}
