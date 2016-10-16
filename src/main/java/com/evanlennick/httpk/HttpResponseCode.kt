package com.evanlennick.httpk

enum class HttpResponseCode(name: String, code: Int) {

    OK("OK", 200),

    CREATED("Created", 201),

    BAD_REQUEST("Bad Request", 400),

    NOT_AUTHORIZED("Not Authorized", 401),

    FORBIDDEN("Forbidden", 403),

    NOT_FOUND("Not Found", 404),

    INTERNAL_SERVER_ERROR("Internal Server Error", 500)

}