package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {


    //현재 자주 사용하는 방식(2022.08.07)
    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    // 과거에 자주 사용했던 방식(회사에가면 이런 코드가 존재할 수 있으므로 알아두는 것이 좋음)
    // GET에도 동일한 주소가 있지만, 충돌오류가 발생하지 않음 >> 동일한 메소드, 주소일때만 충돌오류가 발생
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    //POST의 경우 request-body에 JSON 형태의 데이터를 보낼 수 있음
    /*
      	{

  "name" : "kimjieun",
  "age" : 27,
  "email" : "kim@naver.com",
  "address" : "인천특별시 청라국제도시"

}
     */

    @PostMapping("/post-mapping/object")
    //objectmapper는 json-->object로 변환 OR object-->json 형태로 변환해주는 라이브러리
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {

        // json-->object
        println(userRequest)
        //object-->json
        return userRequest
    }
}