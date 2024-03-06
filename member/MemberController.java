package member;

import enums.Messenger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Optional;


public class MemberController {
    MemberServiceImpl memberService;


    public MemberController() {
        this.memberService = MemberServiceImpl.getInstance();

    }
    public String login(Scanner scanner) {
        return memberService.login(Member.builder()
                .memberName(scanner.next())
                .pw(scanner.next())
                .build());

    }
    public String addMembers() {
        return memberService.addMembers();
    }
    public Messenger save(Scanner sc) {
        memberService.save(Member.builder()
                .memberName(sc.next())
                .personId(sc.next())
                .address(sc.next())
                .phoneNumber(sc.next())
                .pw(sc.next())
                .build());
        return Messenger.SUCCESS;
    }
    public List<Member> findAll(){
        return memberService.findAll();
    }
    public Optional<Member> findAById(Scanner sc){
        return memberService.findAById(sc.nextLong());
    }
    public String count(){
        return memberService.count();
    }
    public Optional<Member> getOne(Scanner sc){
        return memberService.getOne(sc.next());
    }
    public String deleteAll(){
        return memberService.deleteAll();
    }
    public Boolean existById(Scanner sc){
        return memberService.existById(sc.nextLong());
    }
    public String updatePassword(Scanner sc) {
        return memberService.updatePassword(Member.builder()
                .memberName(sc.next())
                .personId(sc.next())
                .address(sc.next())
                .phoneNumber(sc.next())
                .pw(sc.next())
                .build()
        );
    }

        public String delete(Scanner sc){
            return memberService.delete(Member.builder()
                    .memberName(sc.next())
                    .build()
            );
        }
    public List<?> findMembersByName(Scanner sc){
        return memberService.findMembersByName(sc.next());
    }
    public Map<String, ?> findMembersByFromName(Scanner sc){
        return memberService.findMembersByFromName(sc.next());
    }
    public List<?> findMembersByJob(Scanner sc){
        return memberService.findMembersByJob(sc.next());
    }
    public Map<String, ?> findMembersByFromJob(Scanner sc){
        return memberService.findMembersByFromJob(sc.next());
    }
    public Map<String, ?> findMembersByJobFromMap(Scanner sc){
        return null;
    }










}
