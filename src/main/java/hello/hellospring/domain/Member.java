package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity//JPA를 사용하기 위한 맵핑, 객체와 테이블을 맵핑하는것, 이걸적음으로써 JPA가 관리하는 엔티티가 되는것
public class Member {

    @Id/*pk맵핑 */ @GeneratedValue(strategy = GenerationType.IDENTITY)/*db에 데이터 넣을때 id값을 db가 자동으로 생성하게 하는 전략을 identity전략이라고 함, 그래서 적어주는것*/
    private Long id;
    private String name;

    /*@Column(name = "username")  => 예를들어 db의 컬럼명이 name이면 이런식으로 어노테이션 쓰면 db에 있는 컬럼명과 이 username이 맵핑 되는것*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
