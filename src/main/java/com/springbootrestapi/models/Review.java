package com.springbootrestapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "reviews")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Review implements Serializable {
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
