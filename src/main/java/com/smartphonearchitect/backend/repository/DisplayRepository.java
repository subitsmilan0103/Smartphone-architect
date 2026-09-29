package com.smartphonearchitect.backend.repository;

import com.smartphonearchitect.backend.model.Display;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayRepository extends JpaRepository<Display, Long> {
}
