package com.eam.hosts.reposotories;

import com.eam.hosts.models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    Optional<Feature> findByHostId(Integer id);
}
