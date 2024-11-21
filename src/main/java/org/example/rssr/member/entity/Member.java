package org.example.rssr.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert // 자동으로 insert문에 null값을 배제하고 쿼리문을 날려줌.
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String memberId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String nickname;
    private String introduce; //한줄소개
    @ColumnDefault("'ROLE_USER'")
    private String roleSet;
    @ColumnDefault("0")
    private Long popularity;
    @Column(nullable = false)
    private String myImgUrl; // 파일 이름

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public void setRole(String roleSet) {
        this.roleSet = roleSet;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void hashPassword(PasswordEncoder passwordEncoder) {
        setPassword(passwordEncoder.encode(getPassword()));
    }
    @Builder
    public Member(Long id, String memberId, String password,
                  String nickname, String introduce, Long popularity,
                  String myImgUrl, String roleSet) {
        this.memberId = memberId;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.introduce = introduce;
        this.popularity = popularity;
        this.myImgUrl = myImgUrl;
        this.roleSet = roleSet;
    }
}
