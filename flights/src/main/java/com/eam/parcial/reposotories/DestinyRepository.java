package com.eam.parcial.reposotories;

import com.eam.parcial.models.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinyRepository  extends JpaRepository<Destiny, Long> {
    Optional<Destiny> findByName(String name);

}
