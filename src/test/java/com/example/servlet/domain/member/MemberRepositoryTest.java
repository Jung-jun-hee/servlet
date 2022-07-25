package com.example.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Junit 5부터는 public 이 필요하지 않다.
class MemberRepositoryTest {

    // 생성자를 private로 선언하여 다른 클래스에서 해당 클래스의 인스턴스를 new 로 생성하지 못하게 하고, getInstance()함수를 통해서 인스턴스를 갖도록 한다.
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello",20);

        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findById() {
        //given
        Member member1 = new Member("member1", 30);
        Member member2 = new Member("member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();
        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);
    }

    @Test
    void findAll() {
    }
}