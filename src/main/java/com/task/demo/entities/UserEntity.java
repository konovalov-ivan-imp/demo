package com.task.demo.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "demo_schema", catalog = "")
public class UserEntity {

    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "body")
    private String body;
    @Basic
    @Column(name = "postId")
    private Integer postId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && postId == that.postId && Objects.equals(body, that.body) && Objects.equals(username, that.username) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, postId, username, updatedAt);
    }
}
