package org.ninjaware.roadtrip.domain

class Vehicle() {
    var id = ""
    var license = ""
    var description = ""
    var active = true

    constructor(license: String, description: String, active: Boolean = true) : this()

    constructor(id: String, license: String, description: String, active: Boolean = true) : this(license, description, active) {
        this.id = id
    }


}


