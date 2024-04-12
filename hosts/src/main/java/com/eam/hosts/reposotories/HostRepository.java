package com.eam.hosts.reposotories;

import com.eam.hosts.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host, Long> {
    Optional<Host> findByName(String name);
}
