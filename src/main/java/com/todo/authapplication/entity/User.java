package com.todo.authapplication.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

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

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ColumnDefault("0")
    @Column(name = "is_deleted")
    private boolean isDeleted;

}
