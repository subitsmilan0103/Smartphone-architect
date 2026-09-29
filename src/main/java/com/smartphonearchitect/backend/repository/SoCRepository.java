package com.smartphonearchitect.backend.repository;

import com.smartphonearchitect.backend.model.SoC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoCRepository extends JpaRepository<SoC, Long> {
}
