package com.eam.comments.services

import com.eam.comments.dto.CommentDTO
import com.eam.comments.models.Comment
import java.util.Optional

interface CommentService {

    fun save(commentDTO: CommentDTO): Comment?

    fun findAll(): List<Comment?>?

    fun findByHostId(hostId: Int?): Optional<CommentDTO>?

    fun update(commentDTO: CommentDTO): Comment?

    fun factory(commentDTO: CommentDTO?): Comment?
}