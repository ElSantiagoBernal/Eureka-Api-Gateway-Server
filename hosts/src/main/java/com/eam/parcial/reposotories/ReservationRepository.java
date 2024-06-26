package com.eam.parcial.reposotories;

import com.eam.parcial.models.Picture;
import com.eam.parcial.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT * FROM Reservation r WHERE r.userId = :userId", nativeQuery = true)
    List<Reservation> findByUserId(Integer userId);
}
