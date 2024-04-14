package com.eam.comments.dto

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

@Data
class CommentDTO {

    var hostId: Int? = null
    var userEmail: String? = null
    var comment: String? = null

}