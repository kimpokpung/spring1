package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {/*인터페이스가 인터페이스를 받을때에는 implenments가 아니라 extends라고 함, <키, 아이디(=엔티티에서 식별자, 즉 pk, type(Member에 id가 Long타입)> -> 인터페이스만 있지만 SpringdataJPA가 구현체를 자동으로 만들고 자동으로 스프링 빈에 등록 해줌, 그리고 그걸 그냥 가져다 쓰면 됨(Springconfig에서) */

    //JPQL select m from Member m where m.name=?  => findByName과 같이 일정한 인터페이스(메서드) 이름을 짓거나 반환타입등의 규칙이 있음 그 규칙에 띠라서 만들면 스프링 데이터 jpa가 다 그런걸 읽어서 jpql로 만들어서 풀어내줌 => 스프링 데이터 jpa제공기능 -> 인터페이스를 통한 기본적인 CRUD, 메서드 이름만으로 조회기능 제공, 페이징 기능 제공
    @Override
    Optional<Member> findByName(String name);
}
