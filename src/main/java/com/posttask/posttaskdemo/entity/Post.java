package com.posttask.posttaskdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="post")
public class Post {
//    fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;


    @OneToMany(mappedBy = "post" , fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Post() {
    }

    public Post(int id, String title, String name, String description, String author, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.description = description;
        this.author = author;
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

//    @Override
//    public String toString() {
//        return "Post{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", author='" + author + '\'' +
//                ", comments=" + comments +
//                '}';
//    }
}
