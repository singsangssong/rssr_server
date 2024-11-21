package org.example.rssr.member.service;

import lombok.RequiredArgsConstructor;
import org.example.rssr.member.dto.get.ViewInfo;
import org.example.rssr.member.dto.post.RegisterInfo;
import org.example.rssr.member.entity.Member;
import org.example.rssr.member.exception.MemberDuplicateException;
import org.example.rssr.member.exception.MemberNotFoundException;
import org.example.rssr.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Long registerMember(RegisterInfo registerInfo) {
        Optional<Member> isMember = memberRepository.findByMemberId(registerInfo.getMemberId());
        if(isMember.isPresent()) throw new MemberDuplicateException();
        Member member = RegisterInfo.toEntity(registerInfo);
        member.hashPassword(bCryptPasswordEncoder);
        return memberRepository.save(member).getId();
    }

    public ViewInfo viewMyInfo(String memberId) {
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(MemberNotFoundException::new);
        return ViewInfo.of(member);
    }
    public void deleteMember(Long memberId) {
        memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        memberRepository.deleteById(memberId);
    }

}
