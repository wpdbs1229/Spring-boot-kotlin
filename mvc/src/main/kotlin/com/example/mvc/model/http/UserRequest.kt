package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,

    /*
    네이밍 컨벤션
    phoneNumber 같은 네이밍을 카멜 케이스 (낙타처러볼록!!)
    PhoneNumber 같은 네이밍을 쌍봉 카멜 케이스
    phone_caes 같은 네이밍을 스네이크 케이스(뱀처럼 생김!!)
    json의 데이터 경우 스네이크 케이스를 주로사용 따라서 카멜케이스를 사용하는 코틀린의 경우(-변수에 넣을 수 없음)
    아래와 같이 JsonProperty를 사용해야함

    주의 : 여러회사의 API를 가져다 사용하므로 class 자체에 네이밍 컨벤션을 사용하는 것이 좋은 방법
    @@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    */
    //@JsonProperty("phone_number")
    var phoneNumber:String?=null

)


