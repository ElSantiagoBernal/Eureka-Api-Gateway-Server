package com.eam.flights.reposotories;

import com.eam.flights.models.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginRepository  extends JpaRepository<Origin, Long> {
}
