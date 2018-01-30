package org.ninjaware.roadtrip.domain

class Vehicle(var license: String, var description: String) {

    var id = UUIDGenerator.next()
    var active = true


    constructor(id: String, license: String, description: String, active: Boolean = true) : this(license, description) {
        this.description = description
        this.license = license
        this.active = active
    }

}