package com.evanlennick.httpk

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class HttpkClient {

    fun request(url: String, requestMethod: RequestMethod, headers: Map<String, String>): HttpResponse? {
        val socket = Socket(url, 80)
        val writer = PrintWriter(socket.outputStream, true)
        val reader = BufferedReader(InputStreamReader(socket.inputStream))

        val request = HttpRequest(url, requestMethod, headers)
        println(request)
        writer.println(request)

        var statusLine: String = ""
        var headers: String = ""

        var line: String? = null
        var i = 0

        while ({ line = reader.readLine(); line }() != "") {
            println(line)
            if (i == 0) {
                statusLine = line + HttpRequest.EOL
            } else {
                headers += line  + HttpRequest.EOL
            }
            i++
        }

        val response = HttpResponse(statusLine, headers)
        val contentLength = response.getContentLength()
        if(null != contentLength) {
            val byteReader = BufferedInputStream(socket.inputStream)
            var contentBytes = ByteArray(contentLength.toInt())
            byteReader.read(contentBytes)
            val contentAsString = String(contentBytes, Charsets.US_ASCII)

            println()
            println(contentAsString)
        }

        writer.close()
        reader.close()
        socket.close()

        return response
    }

}