package org.example.rssr.member.dto.get;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.example.rssr.member.entity.Member;

@Getter
@Builder
public class ViewInfo {
    private String memberId;
    private String nickname;
    private String introduce;
    private String myImgUrl; // 파일 url

    public static ViewInfo of(Member member) {
        return ViewInfo.builder()
                .memberId(member.getMemberId())
                .nickname(member.getNickname())
                .introduce(member.getIntroduce())
                .myImgUrl(member.getMyImgUrl())
                .build();
    }
}
