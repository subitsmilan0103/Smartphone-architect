package com.smartphonearchitect.backend.config;

import com.smartphonearchitect.backend.model.Battery;
import com.smartphonearchitect.backend.model.PhoneCase;
import com.smartphonearchitect.backend.repository.BatteryRepository;
import com.smartphonearchitect.backend.repository.PhoneCaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PhoneCaseRepository phoneCaseRepository;
    private final BatteryRepository batteryRepository;

    public DataSeeder(PhoneCaseRepository pcr, BatteryRepository br) {
        this.phoneCaseRepository = pcr;
        this.batteryRepository = br;
    }

    @Override
    public void run(String... args) throws Exception {
        // Phone cases
        PhoneCase slimCase = new PhoneCase();
        slimCase.setName("Slim Aluminium Unibody");
        slimCase.setMaterial("Aluminium");
        slimCase.setPrice(120.0);
        slimCase.setMaxBatteryThicknessMm(6.0);

        PhoneCase ruggedCase = new PhoneCase();
        ruggedCase.setName("Rugged Titanium");
        ruggedCase.setMaterial("Titanium");
        ruggedCase.setPrice(200.0);
        ruggedCase.setMaxBatteryThicknessMm(12.0);

        phoneCaseRepository.save(slimCase);
        phoneCaseRepository.save(ruggedCase);

        System.out.println("Keszulekhazak betoltve");

        // Batteries
        Battery thinBattery = new Battery();
        thinBattery.setName("Thin Battery");
        thinBattery.setPrice(30.0);
        thinBattery.setCapacityMah(4000);
        thinBattery.setThicknessMm(5.5);

        Battery thickBattery = new Battery();
        thickBattery.setName("Thick Battery");
        thickBattery.setPrice(50.0);
        thickBattery.setCapacityMah(6000);
        thickBattery.setThicknessMm(9.0);

        batteryRepository.save(thinBattery);
        batteryRepository.save(thickBattery);

        System.out.println("Akksik betoltve");
    }
}