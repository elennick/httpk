package com.evanlennick.httpk

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

        var rawResponse: String = ""
        var line: String? = null
        while ({ line = reader.readLine(); line }() != null) {
            rawResponse += line + HttpRequest.EOL
        }

        writer.close()
        reader.close()
        socket.close()

        val response = HttpResponse(rawResponse)

        return response
    }

}