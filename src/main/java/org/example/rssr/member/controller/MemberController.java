package org.example.rssr.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.rssr.member.dto.get.ViewInfo;
import org.example.rssr.member.dto.post.RegisterInfo;
import org.example.rssr.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<?> viewMember(Principal principal) {
        ViewInfo myProfileInfo = memberService.viewMyInfo(principal.getName());// 아이디 가져오기
        return ResponseEntity.ok(myProfileInfo);
    }
    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterInfo registerInfo) {
        Long memberId = memberService.registerMember(registerInfo);
        return ResponseEntity.ok(memberId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }


}
