package com.evanlennick.httpk

fun main(args: Array<String>) {
    val hostname = "www.yahoo.com"
    val headers = mapOf(Pair("User-Agent", "httpk-client 1.0.0"), Pair("Host", "www.yahoo.com"))

    val httpkClient = HttpkClient()
    val request = httpkClient.request(hostname, RequestMethod.GET, headers)

    print(request)
}
