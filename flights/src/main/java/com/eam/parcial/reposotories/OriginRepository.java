package com.eam.parcial.reposotories;

import com.eam.parcial.models.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OriginRepository  extends JpaRepository<Origin, Long> {
    Optional<Origin> findByName(String name);
}
