package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.repository.MemberRepository;
import hello.hellospring.domain.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X
        Optional<Member> result = memberRepository.findByName(member.getName());


        memberRepository.save(member);
        return  member.getId();

    }

}
