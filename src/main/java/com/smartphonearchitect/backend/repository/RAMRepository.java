package com.smartphonearchitect.backend.repository;

import com.smartphonearchitect.backend.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {
}
