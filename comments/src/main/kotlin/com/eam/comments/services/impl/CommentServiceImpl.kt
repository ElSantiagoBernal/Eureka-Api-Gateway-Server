package com.eam.comments.services.impl

import com.eam.comments.dto.CommentDTO
import com.eam.comments.models.Comment
import com.eam.comments.repositories.CommentRepository
import com.eam.comments.services.CommentService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
@AllArgsConstructor
class CommentServiceImpl( @Autowired private val commentRepository: CommentRepository) : CommentService{
    override fun save(commentDTO: CommentDTO): Comment? {
            return factory(commentDTO)?.let { commentRepository.save(it) }
    }

    override fun findAll(): List<Comment?>? {
        return commentRepository.findAll()
    }

    override fun findByHostId(hostId: Int?): Optional<CommentDTO>? {
        return hostId?.let { commentRepository.findByHostId(it) }
    }

    override fun update(commentDTO: CommentDTO): Comment? {
        return factory(commentDTO)?.let { commentRepository.save(it) }
    }

    override fun factory(commentDTO: CommentDTO?): Comment? {
        return commentDTO?.let {
            val comment = Comment()
            comment.hostId = it.hostId
            comment.userEmail = it.userEmail
            comment.comment = it.comment
            comment
        }

    }


}