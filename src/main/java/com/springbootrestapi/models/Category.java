package com.springbootrestapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name ="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category")
    private String category;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Review> reviews;
}
