package com.eam.flights.reposotories;

import com.eam.flights.models.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OriginRepository  extends JpaRepository<Origin, Long> {
    Optional<Origin> findByName(String name);
}
