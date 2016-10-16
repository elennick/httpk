package com.evanlennick.httpk

class HttpResponse {

    private val rawResponse: String

    private val headers: Map<String, String>

    private val body: String //this will probably need to be Byte or something more abstract

    constructor(rawResponse: String) {
        this.rawResponse = rawResponse
        headers = emptyMap()
        body = ""
    }

    override fun toString(): String{
        return "HttpResponse(rawResponse='$rawResponse', headers=$headers, body='$body')"
    }

}