package com.eam.parcial.reposotories;

import com.eam.parcial.models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    Optional<Feature> findByHostId(Integer id);
}
