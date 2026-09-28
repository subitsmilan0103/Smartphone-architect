package com.smartphonearchitect.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompatibilityResult {
    private boolean isCompatible;
    private String message;
    private double totalPrice;
}