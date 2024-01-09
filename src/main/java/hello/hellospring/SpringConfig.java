package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;//하고

    @Autowired//생성자가 하나인경우 생략해도 됨(지금같은 경우에 생략 가능), 이렇게 하면 스프링 컨테이너에서 MemberRepository를 찾음, 근데 등록한게 없음 but SpringDataJpaMemberRepository에 가보면 등록해놓은게 있음, extends JpaRepository에서 JpaRepository가 SpringData가 제공하는 것임, 그래서 스프링 데이테jpa가 인터페이스에 대한 구현체를 만들고 스프링 빈에 등록해두기 때문에 인젝션 받을수 있음
    public SpringConfig(MemberRepository memberRepository) {//인젝션 받으면 SpringDataJpa가 구현체를 만들어놓은것이 등록이 됨
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(/*memberRepository()*/memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);//(엔티티매니저)
//    }

//    @Bean//AOP는 AOP가 사용되었음을 알수 있게끔 직접(@Component를 쓰지 않고) 이처럼 직접 SpringBean에 등록해주는것이 좋음, 하지만 여기선 그냥 컴포넌트 스캔 쓰겠음(TimeTraceAop 클래스)
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
