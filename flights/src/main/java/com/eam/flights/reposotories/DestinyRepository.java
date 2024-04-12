package com.eam.flights.reposotories;

import com.eam.flights.models.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinyRepository  extends JpaRepository<Destiny, Long> {
}
