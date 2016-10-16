package com.evanlennick.httpk

class HttpResponse {

    private val statusLine: String

    private val headers: MutableMap<String, String>

    var body: ByteArray? = null

    constructor(statusLine: String, headers: MutableMap<String, String>) {
        this.statusLine = statusLine
        this.headers = headers
    }

    constructor(statusLine: String, headers: String) {
        this.statusLine = statusLine

        this.headers = mutableMapOf()
        val headerLines = headers.split(HttpRequest.EOL)

        for (headerLine in headerLines) {
            if(!headerLine.contains(":")) {
                continue
            }
            val name = headerLine.substring(0, headerLine.indexOf(":")).trim()
            val value = headerLine.substring(headerLine.indexOf(":") + 1, headerLine.length).trim()
            this.headers.put(name, value)
        }

    }

    fun getContentLength(): String? {
        return this.headers.get("Content-Length")
    }

    override fun toString(): String{
        return "HttpResponse(statusLine='$statusLine', headers=$headers, body='$body')"
    }

}