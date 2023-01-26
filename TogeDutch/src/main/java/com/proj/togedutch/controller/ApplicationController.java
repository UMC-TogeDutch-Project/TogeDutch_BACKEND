package com.proj.togedutch.controller;


import com.proj.togedutch.config.BaseException;
import com.proj.togedutch.config.BaseResponse;
import com.proj.togedutch.entity.Application;
import com.proj.togedutch.entity.Post;
import com.proj.togedutch.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class ApplicationController {
    final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplicationService applicationService;


    // 공고 생성
    @ResponseBody
    @PostMapping("post/{postIdx}/application")
    public BaseResponse<Application> applyPost(@PathVariable("postIdx") int postIdx,@RequestBody Application application){
        try{
            Application newApplication=applicationService.applyPost(postIdx, application);
            return new BaseResponse<>(newApplication);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }


    //TODO 공고 수락
    @ResponseBody
    @PostMapping("application/{applicationidx}/accept")
    public BaseResponse<Application> modifyStatus(@PathVariable("applicationidx") int applicationIdx){
        try{
            Application application=applicationService.modifyStatus(applicationIdx);
            return new BaseResponse<>(application);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }


    //TODO 공고 수락
    @ResponseBody
    @PostMapping("application/{applicationidx}/deny")
    public BaseResponse<Application> modifyStatus_deny(@PathVariable("applicationidx") int applicationIdx){
        try{
            Application application=applicationService.modifyStatus_deny(applicationIdx);
            return new BaseResponse<>(application);
        }catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    // 신청상태 전체조회






    //공고 상태 전체 조회(내가 업로드)
    /*@ResponseBody
    @GetMapping("{postIdx}/application/upload")
    public BaseResponse<Post> getPost(@PathVariable("{postIdx}/application/upload") int postIdx) {
        try{
            Post getPost=postService.getPost(postIdx);
            return new BaseResponse<>(getPost);
        } catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
    //공고 상태 잔체 조회(내가 참여한 공고)
    @ResponseBody
    @GetMapping("{postIdx}/application/join")
    public BaseResponse<Post> getJoinPost(@PathVariable("{postIdx}/application/join") int postIdx) {
        try{
            Post getJoinPost=postService.getJoinPostBypostIdx(postIdx);
            return new BaseResponse<>(getJoinPost);
        } catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
    //채팅방 전체 조회(내가 참여)
    @ResponseBody
    @GetMapping("{postIdx}/chatroom")
    public BaseResponse<Post> getJoinPost(@PathVariable("{postIdx}/chatroom") int postIdx) {
        try{
            Post getChatroom=postService.getChatBypostIdx(postIdx);
            return new BaseResponse<>(getChatroom);
        } catch(BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }*/
}