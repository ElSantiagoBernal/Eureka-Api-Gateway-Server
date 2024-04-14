package com.eam.comments.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@AllArgsConstructor
@Data
@NoArgsConstructor
class Response<T>(private val mensaje: String, private val dato: T) {

}