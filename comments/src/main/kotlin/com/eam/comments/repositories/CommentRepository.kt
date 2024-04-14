package com.eam.comments.repositories

import com.eam.comments.dto.CommentDTO
import com.eam.comments.models.Comment
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByHostId(hostId: Int): Optional<CommentDTO>

}