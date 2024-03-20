package kr.co.sample.sampleapi.controller;

import kr.co.sample.sampleapi.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/*
@Api	 클래스를 Swagger 리소스 대상으로 표시
@ApiOperation	 요청 URL 에 매핑된 API 에 대한 설명
@ApiParam	 요청 Parameter에 대한 설명 및 필수여부, 예제값 설정
@ApiResponse	 응답에 대한 설명
*/




@RestController
public class TestController {

    @ApiOperation(value = "사용자 정보 조회 " , notes = "User Id를 이용하여 사용자 정보를 조회합니다.")

    @GetMapping(value = "/user/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object findUser(
            @ApiParam(value = "user id" , required = true , example = "1")
            @PathVariable(value = "id" , required = true) String id,

            @ApiParam(value = "User Agent Type" , required = true , example = "Mozila")
            @RequestHeader(value = "User-Agent") String userAgent,

            @ApiParam(value = "parameter1" , required = false)
            @RequestParam(value = "param1", required = false ) String param1,

            @ApiParam(value = "parameter2" , required = false)
            @RequestParam(value = "param2" , required = false) String param2
    ){
        return true;
    }

    @ApiOperation(value = "사용자  리스트 조회 " , notes = "특정 조건에 맞는 사용자 리스트를 조회합니다.")
    @GetMapping(value = "/user" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object findUsers(
            @RequestHeader (value = "User-Agent") String userAgent,
            @ModelAttribute User user){

            User userData = new User(user.getUserName() , user.getPhoneNumber());
            //return true;

            return userData;
    }

    @ApiOperation(value = "사용자 생성 " , notes = "신규 사용자를 생성합니다.")
    @PostMapping(value = "/user" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object CreateUser(
            @RequestHeader (value = "User-Agent") String userAgent,
            @RequestBody(required = true) User user){

            User userData = new User(user.getUserName() , user.getPhoneNumber());

        return true;
    }

    /*@ApiOperation(value = "getMethodTest " , notes = "getMethodTest")
    @GetMapping(value= "/getTest" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getTest(){

        return true;
    }

    @ApiOperation(value = "PostMethodTest " , notes = "PostMethodTest")
    @PostMapping(value= "/PostTest" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object PostTest(){

        return true;
    }

    @ApiOperation(value = "PutMethodTest " , notes = "PutMethodTest")
    @PutMapping(value= "/PutTest" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object PutTest(){

        return true;
    }

    @ApiOperation(value = "PatchMethodTest " , notes = "PatchMethodTest")
    @PatchMapping(value= "/PatchTest" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object PatchTest(){

        return true;
    }

    @ApiOperation(value = "DeleteMethodTest " , notes = "DeleteMethodTest")
    @DeleteMapping(value= "/DeleteTest" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object DeleteTest(){

        return true;
    }*/

}
