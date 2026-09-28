package com.smartphonearchitect.backend.controller;

import com.smartphonearchitect.backend.dto.CompatibilityResult;
import com.smartphonearchitect.backend.service.CompatibilityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CompatibilityController {

    private final CompatibilityService compatibilityService;

    public CompatibilityController(CompatibilityService cs) {
        this.compatibilityService = cs;
    }

    @GetMapping("/api/check-compatibility")
    public CompatibilityResult check(@RequestParam Long caseId, @RequestParam Long batteryId) {
        return compatibilityService.checkCompatibility(caseId, batteryId);
    }
}