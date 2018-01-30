package org.ninjaware.roadtrip.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*
import javax.validation.constraints.NotEmpty

@Document(collection = "user")
class User() {
  @Id var id: String = UUID.randomUUID().toString()
  @Field @Indexed @NotEmpty lateinit var name: String
  @Field @Indexed @NotEmpty lateinit var email: String
  @Field var counter: Int = 0

  constructor(name: String, email: String, counter: Int = 0): this() {
      this.name = name
      this.email = email
  }

  constructor(id: String, name: String, email: String, counter: Int = 0) : this() {
      this.id = id
      this.name = name
      this.email = email
      this.counter = counter
  }





}