package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.springframework.web.bind.annotation.*

@RestController // 해당 컨트롤러는 REST API 컨트롤러로 동작함
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {
    @GetMapping("hello")
    //@GetMapping(path = ["/hello", "/abcd"]) //http://localhost:8080/api/hello(or)abcd
    fun hello() : String
    {
        return "hello Kotlin"
    }

    // 위와 똑같이 작동함, 옛날에는 이런 방식을 썼음
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping() : String
    {
        return "request-mapping"
    }

    //Path-Variable
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name : String, @PathVariable age : Int): String {

        println("${name},${age}")
        return name+","+age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name")_name : String,@PathVariable age: Int ): String {
        val name = "kotlin"
        println("${_name},${age}")
        return _name+","+age
    }


    //query-parameter
    @GetMapping("/get-mapping/query-param")// ?name=steve&age=20
    fun queryParam(
        @RequestParam name : String,
        @RequestParam(value = "age") _age : Int
    ): String {
        println("${name},${_age}")

        return name+""+_age
    }

    //name,address,age,email

    //주소에 파싱할 수 없는 변수가 있을 떄는 객체보다는 @RequestParam으로 해야함
    // kotlin에서는 변수명에 -을 쓸 수 없기 때문에 객체로 못받음
    // 따라서, @RequestParam(vlaue ="phone-number) phoneNumber : String형태로 받아야함 또는 Map<>형태로 받아야함
    //객체로 query-param 받기, 객체로 받으면 return 값이 JSON형태로 바뀜
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }


    //map을 사용해서 하는 방법 map 은 -하이픈)  사용가능
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number") //따로 뽑을 수 있음
        return map
    }
}