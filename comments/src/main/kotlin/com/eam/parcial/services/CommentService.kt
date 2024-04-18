package com.eam.parcial.services

import com.eam.parcial.dto.CommentDTO
import com.eam.parcial.models.Comment
import java.util.Optional

interface CommentService {

    fun save(commentDTO: CommentDTO): Comment?

    fun findAll(): List<Comment?>?

    fun findByHostId(hostId: Int?): Optional<CommentDTO>?

    fun update(commentDTO: CommentDTO): Comment?

    fun factory(commentDTO: CommentDTO?): Comment?
}