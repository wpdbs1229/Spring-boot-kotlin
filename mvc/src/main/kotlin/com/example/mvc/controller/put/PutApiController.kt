package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import jdk.nashorn.internal.objects.NativeFunction.apply
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping() : String{
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping() : String{
        return "request-mapping - put-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        //0. UserResponse //.apply() 자기자신을 계속해서 반환
       return  UserResponse().apply {

            //1.result
            this.result = Result().apply{
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            //2.destcription
            this.description = "김지은 재우기 성공"
        }.apply {
            //3.user mutable list

            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "kim"
                this.age = 27
                this.address = "청라국제도시"
                this.email = "kim@naver.com"
                this.phoneNumber = "010-1234-9999"
            })

            userList.add(UserRequest().apply {
                this.name = "Lee"
                this.age = 26
                this.address = "여월동"
                this.email = "LEE@naver.com"
                this.phoneNumber = "010-1234-5555"
            })

            this.userRequest = userList
        }

    }
}