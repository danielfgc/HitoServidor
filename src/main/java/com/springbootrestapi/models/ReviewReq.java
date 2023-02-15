package com.springbootrestapi.models;

import lombok.Data;

@Data
public class ReviewReq {
    private Review review;
    private int idUser;
    private int idCategory;
}
