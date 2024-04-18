package com.eam.parcial.dto

import lombok.Data

@Data
class CommentDTO {

    var hostId: Int? = null
    var userEmail: String? = null
    var comment: String? = null

}