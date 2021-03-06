package com.toyproj.pinchhitterhomerun.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_hint")
@Getter
public class MemberPasswordHint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hint_id")
    private PasswordHint hintId;

    private String answer;

    public MemberPasswordHint() {
    }

    public MemberPasswordHint(Member memberId, PasswordHint hintId, String answer) {
        this.memberId = memberId;
        this.hintId = hintId;
        this.answer = answer;
    }
}
