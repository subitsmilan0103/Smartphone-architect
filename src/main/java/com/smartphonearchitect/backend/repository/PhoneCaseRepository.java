package com.smartphonearchitect.backend.repository;

import com.smartphonearchitect.backend.model.PhoneCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneCaseRepository extends JpaRepository<PhoneCase, Long> {
}
