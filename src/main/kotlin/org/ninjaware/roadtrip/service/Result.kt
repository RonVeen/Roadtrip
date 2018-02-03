package org.ninjaware.roadtrip.service

class Result<T>(val succes: Boolean, val value: T? = null) {

    var message: String = ""
    var exception: Exception? = null

    //  Success constructor
    constructor(value: T) : this(true, value)

    constructor(message: String) : this(false, null) {
        this.message = message
    }

    constructor(succes: Boolean, message: String) : this(false, null) {
        this.message = message
    }

    constructor(exception: Exception) : this(false, null) {
        this.exception = exception
    }

    constructor(message: String, exception: Exception) : this(exception) {
        this.message = message
    }




}