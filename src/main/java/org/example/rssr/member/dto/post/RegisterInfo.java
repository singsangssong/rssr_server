package org.example.rssr.member.dto.post;

import lombok.Data;
import org.example.rssr.member.entity.Member;

@Data
public class RegisterInfo {
    private String memberId;
    private String password;
    private String nickname;
    private String introduce;
    private String myImgUrl; // 파일 url

    public static Member toEntity(RegisterInfo registerInfo) {
        return Member.builder()
                .memberId(registerInfo.memberId)
                .password(registerInfo.password)
                .nickname(registerInfo.nickname)
                .introduce(registerInfo.introduce)
                .myImgUrl(registerInfo.myImgUrl)
                .build();
    }
}
