package com.evanlennick.httpk

class HttpRequest(url: String, requestMethod: RequestMethod, headers: Map<String, String>) {

    companion object {
        val HTTP_VERSION = "HTTP/1.1"
        val EOL = "\r\n"
    }

    var rawRequest: String

    init {
        val requestLine = requestMethod.toString() + " / " + HTTP_VERSION + EOL
        var headersString = ""

        for ((name, value) in headers) {
            headersString += name + ": " + value + EOL
        }

        val body = ""

        rawRequest = requestLine + headersString + EOL + body
    }

    override fun toString(): String {
        return rawRequest
    }
}