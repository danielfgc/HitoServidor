package com.springbootrestapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "idUser")
    private User user;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "idCategory")
    private Category category;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "valoration")
    private float valoration;
    @Column(name = "likes")
    private int likes;
    @Column(name = "dislikes")
    private int dislikes;
}
