package com.smartphonearchitect.backend.config;

import com.smartphonearchitect.backend.model.Battery;
import com.smartphonearchitect.backend.model.Display;
import com.smartphonearchitect.backend.model.PhoneCase;
import com.smartphonearchitect.backend.model.SoC;
import com.smartphonearchitect.backend.model.RAM;
import com.smartphonearchitect.backend.model.Storage;
import com.smartphonearchitect.backend.model.Camera;
import com.smartphonearchitect.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PhoneCaseRepository phoneCaseRepository;
    private final BatteryRepository batteryRepository;
    private final DisplayRepository displayRepository;
    private final CameraRepository cameraRepository;
    private final RAMRepository ramRepository;
    private final StorageRepository storageRepository;
    private final SoCRepository soCRepository;


    public DataSeeder(PhoneCaseRepository pcr, BatteryRepository br,  DisplayRepository dr, CameraRepository cr, RAMRepository rr, StorageRepository sr, SoCRepository socr) {
        this.phoneCaseRepository = pcr;
        this.batteryRepository = br;
        this.displayRepository = dr;
        this.cameraRepository = cr;
        this.ramRepository = rr;
        this.storageRepository = sr;
        this.soCRepository = socr;
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

        // Displays
        Display oledDisplay = new Display();
        oledDisplay.setName("OLED Display 6.8");
        oledDisplay.setSizeInches(6.8);
        oledDisplay.setRefreshRateHz(120);
        oledDisplay.setPrice(200.0);

        Display ipsDisplay = new Display();
        ipsDisplay.setName("IPS Display 6.0");
        ipsDisplay.setSizeInches(6.0);
        ipsDisplay.setRefreshRateHz(90);
        ipsDisplay.setPrice(100.0);

        displayRepository.save(oledDisplay);
        displayRepository.save(ipsDisplay);
        System.out.println("Kijelzok betoltve");

        // SoC
        SoC a20proSoc = new SoC();
        a20proSoc.setName("Apple A20 Pro");
        a20proSoc.setPrice(45.0);
        a20proSoc.setMaxSupportedDisplaySize(6.5);
        a20proSoc.setMaxSupportedRefreshRate(120);

        SoC sd8gen3 = new SoC();
        sd8gen3.setName("Snapdragon 8 Gen 3");
        sd8gen3.setPrice(130.0);
        sd8gen3.setMaxSupportedDisplaySize(8.0);
        sd8gen3.setMaxSupportedRefreshRate(144);

        soCRepository.save(a20proSoc);
        soCRepository.save(sd8gen3);
        System.out.println("Processzorok betoltve");

        // RAMs
        RAM basicRam = new RAM();
        basicRam.setCapacityGb(8);
        basicRam.setType("LPDDR4X");
        basicRam.setPrice(20.0);

        RAM proRam = new RAM();
        proRam.setCapacityGb(16);
        proRam.setType("LPDDR5X");
        proRam.setPrice(65.0);

        ramRepository.save(basicRam);
        ramRepository.save(proRam);
        System.out.println("RAM-ok betoltve");

        // Storages
        Storage basicStorage = new Storage();
        basicStorage.setCapacityGb(256);
        basicStorage.setType("UFS 3.1");
        basicStorage.setPrice(35.0);

        Storage proStorage = new Storage();
        proStorage.setCapacityGb(1024);
        proStorage.setType("UFS 4.0");
        proStorage.setPrice(110.0);

        storageRepository.save(basicStorage);
        storageRepository.save(proStorage);
        System.out.println("Tarhelyek betoltve");

        // Cameras
        Camera basicCamera = new Camera();
        basicCamera.setName("50MP normal angle");
        basicCamera.setMegapixels(50);
        basicCamera.setThicknessMm(2.2);
        basicCamera.setSelfie(false);
        basicCamera.setPrice(30.0);

        Camera wideCamera = new Camera();
        wideCamera.setName("200MP wide angle");
        wideCamera.setMegapixels(200);
        wideCamera.setThicknessMm(4.8);
        wideCamera.setSelfie(false);
        wideCamera.setPrice(95.0);

        cameraRepository.save(basicCamera);
        cameraRepository.save(wideCamera);
        System.out.println("Kamerak betoltve");

    }
}