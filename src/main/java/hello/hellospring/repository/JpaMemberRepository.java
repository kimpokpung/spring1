package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;//엔티티매니저 주입받는것

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);//이렇게 하면 JPA가 insert쿼리 다 만들어서 db에 집어넣고 member에 setid까지 다 해줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);//pk값 조회 => (조회할 타입, 식별자 pk값)
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {//특별한 jpql이라는 객체지향 쿼리 언어를 써야함
        List<Member> result = em.createQuery("select m from Member m where m.name = :name ", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)//jpql이라는 쿼리 언어, 보통은 테이블을 대상으로 쿼리를 날리지만, 이것은 객체(정확히는 엔티티)를 대상으로 쿼리를 날림, Member 엔티티를 조회하고 member엔티티 자체를 조회하는것, 매핑 이미 다 되어있고, select id, name 그런거 안해도 됨
                .getResultList();
    }
}
