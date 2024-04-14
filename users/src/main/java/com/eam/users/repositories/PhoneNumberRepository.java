package com.eam.users.repositories;

import com.eam.users.models.Client;
import com.eam.users.models.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    Optional<PhoneNumber> findByNumber(String phoneNumber);
}
