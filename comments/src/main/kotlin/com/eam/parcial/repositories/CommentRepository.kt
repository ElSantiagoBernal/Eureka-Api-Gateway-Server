package com.eam.parcial.repositories

import com.eam.parcial.dto.CommentDTO
import com.eam.parcial.models.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByHostId(hostId: Int): Optional<CommentDTO>

}