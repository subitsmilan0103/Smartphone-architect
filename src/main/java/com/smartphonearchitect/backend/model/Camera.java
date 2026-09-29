package com.smartphonearchitect.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //pl szeles latoszogu, telefoto stb.
    private int megapixels;
    private double thicknessMm;
    private boolean isSelfie;
    private double price;
}