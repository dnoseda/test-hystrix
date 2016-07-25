@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7')
@Grab('oauth.signpost:signpost-core:1.2.1.2')
@Grab('oauth.signpost:signpost-commonshttp4:1.2.1.2')


import groovyx.net.http.*
import static groovyx.net.http.Method.*
import static groovyx.net.http.ContentType.*

def http = new HTTPBuilder()

http.request( 'https://api.mercadolibre.com', GET, JSON) { req ->
  uri.path = '/sites/MLA'
  //uri.query = [ v:'1.0', q: 'Calvin and Hobbes' ]
  //headers.'User-Agent' = "Mozilla/5.0 Firefox/3.0.4"
  headers.Accept = 'application/json'

  response.success = { resp, json ->
    assert resp.statusLine.statusCode == 200
    println "Got response: ${resp.statusLine}"
    println "Content-Type: ${resp.headers.'Content-Type'}"
    println json
  }

  response.'404' = {
    println 'Not found'
  }
}
