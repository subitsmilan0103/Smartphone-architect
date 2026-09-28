package com.smartphonearchitect.backend.service;

import com.smartphonearchitect.backend.dto.CompatibilityResult;
import com.smartphonearchitect.backend.model.Battery;
import com.smartphonearchitect.backend.model.PhoneCase;
import com.smartphonearchitect.backend.repository.BatteryRepository;
import com.smartphonearchitect.backend.repository.PhoneCaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityService {

    private final PhoneCaseRepository caseRepo;
    private final BatteryRepository batteryRepo;

    public CompatibilityService(PhoneCaseRepository cr, BatteryRepository br) {
        this.caseRepo = cr;
        this.batteryRepo = br;
    }

    public CompatibilityResult checkCompatibility(Long caseId, Long batteryId) {
        PhoneCase phoneCase = caseRepo.findById(caseId)
                .orElseThrow(() -> new RuntimeException("Nincs ilyen keszulekhaz"));

        Battery battery = batteryRepo.findById(batteryId)
                .orElseThrow(() -> new RuntimeException("Nincs ilyen akksi"));

        double totalPrice = battery.getPrice() + phoneCase.getPrice();
        double batteryDiff = phoneCase.getMaxBatteryThicknessMm() - battery.getThicknessMm();

        if (batteryDiff >= 0)
            return new CompatibilityResult(true, "passzol", totalPrice);
        else
            return new CompatibilityResult(false, "hiba: " + Math.abs(batteryDiff) + "mm-rel elter", totalPrice);
    }
}