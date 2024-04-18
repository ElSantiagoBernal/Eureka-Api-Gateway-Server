package com.eam.parcial.models

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data

@Entity
@Data
@Table(name = "clients")
@Builder
@AllArgsConstructor
class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var hostId: Int? = null

    @Column
    var userEmail: String? = null

    @Column(nullable = false)
    var comment: String? = null

}