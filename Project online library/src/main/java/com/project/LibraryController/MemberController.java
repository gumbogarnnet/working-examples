/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.LibraryController;

import com.project.model.Member;
import com.project.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Gumbo
 */
@Controller
public class MemberController {
    @Autowired
    MemberRepository memberRepository;
    
    
    @RequestMapping("/createmember")
    public String createMember(@RequestBody Member member){
    memberRepository.save(member);
    return "member/memberpage";
    }
    @GetMapping("/getallmembers")
    @ResponseBody
    public List<Member> getAllMembers(){
    return memberRepository.findAll();
    }
    @GetMapping("getmemberbyid/{idNumber}")
    @ResponseBody
    public Member getMemberById(@PathVariable String idNumber){
    return memberRepository.findOne(idNumber);
    }
    @DeleteMapping("/deletemember/{idNumber}")
    public void deleteMember(@PathVariable String idNumber){
    memberRepository.delete(idNumber);
    }
    @RequestMapping("editmember")
    public String editMember(@RequestParam String idNumber){
    return "editmember";
    }
    
    
    
}
