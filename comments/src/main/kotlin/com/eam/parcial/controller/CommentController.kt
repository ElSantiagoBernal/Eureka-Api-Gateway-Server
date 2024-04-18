package com.eam.parcial.controller

import com.eam.parcial.dto.CommentDTO
import com.eam.parcial.dto.Response
import com.eam.parcial.models.Comment
import com.eam.parcial.services.CommentService
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
        return ResponseEntity.status(HttpStatus.CREATED).body(Response("Comentario creado correctamente", commentDTO?.let { commentService?.save(it) }))
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