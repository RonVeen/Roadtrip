package org.ninjaware.roadtrip.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*
import javax.validation.constraints.NotEmpty

@Document(collection = "user")
class User() {
  @Id lateinit var id: String
  @Field @Indexed @NotEmpty lateinit var name: String
  @Field @Indexed @NotEmpty lateinit var email: String
  @Field @NotEmpty lateinit var password: String
  @Field var active = true
  @Field val vehicles: MutableList<Vehicle> = mutableListOf()


  constructor(id: String, name: String, email: String, password: String, active: Boolean = true): this() {
      this.id = id
      this.name = name
      this.email = email
      this.active = active
      this.password = password
  }







}