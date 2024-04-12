package com.eam.flights.reposotories;

import com.eam.flights.models.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinyRepository  extends JpaRepository<Destiny, Long> {
    Optional<Destiny> findByName(String name);

}
