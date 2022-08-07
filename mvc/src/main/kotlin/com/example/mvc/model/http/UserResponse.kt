package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse(
    var result : Result? = null,
    var description: String?=null,

    @JsonProperty("user")
    var userRequest: MutableList<UserRequest>? = null
 )


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class  Result(

    var resultCode : String? = null, //result_code
    var resultMessage : String? = null //result_message
)

/*
//JSON Data
    {
    "result":{
    "result_code": "OK",
    "result_message": "성공"
    },
    "description": "김지은 재우기 성공",
    "user":[
    {
    "name": "Kim_Ji_Eun",
    "age": 27,
    "email": "kim@naver.com",
    "address": "인천특별시 청라국제도시",
    "phoneNumber": "010-1234-5679"
    },
    {
    "name": "kim",
    "age": 27,
    "email": "kim@naver.com",
    "address": "청라국제도시",
    "phoneNumber": "010-1234-9999"
    },
    {
    "name": "Lee",
    "age": 26,
    "email": "LEE@naver.com",
    "address": "여월동",
    "phoneNumber": "010-1234-5555"
    }
    ]
    }
 */