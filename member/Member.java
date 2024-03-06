package member;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Member {
    private Long id;
    private String memberName;
    private String pw;
    private String name;
    private String personId;
    private String phoneNumber;
    private String address;
    private String job;
    private double height;
    private double weight;

@Builder(builderMethodName = "builder")
    public Member(String memberName, String pw, String name, String personId, String phoneNumber, String address, String job, double height, double weight) {
        this.memberName = memberName;
        this.pw = pw;
        this.name = name;
        this.personId = personId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}