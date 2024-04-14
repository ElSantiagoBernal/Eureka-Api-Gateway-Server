package com.eam.comments.controller

import com.eam.comments.dto.CommentDTO
import com.eam.comments.dto.Response
import com.eam.comments.models.Comment
import com.eam.comments.services.CommentService
import lombok.AllArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
class CommentController {

    private val commentService: CommentService? = null

    @PostMapping
    fun save(@RequestBody commentDTO: CommentDTO?): ResponseEntity<Response<Comment?>> {
        return ResponseEntity.status(HttpStatus.CREATED).body(Response("Alojamiento creado correctamente", commentDTO?.let { commentService?.save(it) }))
    }

    @GetMapping
    fun findAll(): ResponseEntity<Response<List<Comment?>?>> {
        return ResponseEntity.status(HttpStatus.OK).body(Response("", commentService?.findAll()))
    }

    @GetMapping("/{hostId}")
    fun findAll(@PathVariable hostId: Int?): ResponseEntity<Response<Optional<CommentDTO>?>> {
        return ResponseEntity.status(HttpStatus.OK).body(Response("", commentService?.findByHostId(hostId)))
    }
}