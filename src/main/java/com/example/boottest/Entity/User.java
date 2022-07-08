package com.example.boottest.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity //database table과 1:1 mapping 되는 객체
@Table(name = "user") //table name을 'user'로 지정
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor  //여기까지는 lombok annotation으로 get,set,builder,constructor 관련 코드 자동 생성
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;  //자동증가 primary key

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
