package hello.hellospring.controller;

public class MemberForm {
    private String name;//(MemberForm.html에서 보낸 name="name"에서 ""안의 name과 이 클래스의 변수 name의 매칭되면서 값이 들어옴-스프링이 넣어줌)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }//name변수가 private기 때문에 막 접근 못함. 따라서 set,getName메서드 사용
}
