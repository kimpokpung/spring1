package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//aop를 사용하기 위한 어노테이션
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")//AOP를 어디에다 적용할것인지 타겟팅, 문법이 따로 있음, 여기에서는 패키지명.그밑에 있는것. 파라미터 타입 등등. 할튼 패키지 밑에 있는것 다 적용해라라는 뜻, 클래스명도 넣을수 있고 복잡하게 지원되나 실무에선 그중 5%정도만 씀
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
       long start = System.currentTimeMillis();
       System.out.println("START: " + joinPoint.toString());
       try {
           return joinPoint.proceed();
       }finally {
           long finish = System.currentTimeMillis();
           long timeMs = finish - start;
           System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
       }

    }
}
