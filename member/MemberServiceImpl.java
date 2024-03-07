package member;

import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class MemberServiceImpl extends AbstractService<Member> implements MemberService {
    MemberRepository repository;
    Map<String, Member> members;
    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {
        this.members = new HashMap<>();
        this.repository = MemberRepository.getInstance();
    }
    public static MemberServiceImpl getInstance() {
        return instance;
    }






    @Override
    public Messenger save(Member member) {
        members.put(member.getMemberName(), member);
        return Messenger.SUCCESS;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Optional<Member> findAById(Long id) {
        return Optional.of(members
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Member> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }


    @Override
    public String login(Member member) {
        String msg = "";
        Member memberDto = members.get(member.getMemberName());
        if (memberDto==null){
            msg = "아이디가 틀렸습니다.";
        }else if (memberDto.getPw().equals(member.getPw())){
            msg = "로그인 성공";
        }else {
            msg = "비밀번호가 틀렸습니다.";
        }
        return msg;
    }

    @Override
    public String test() {
        return null;
    }


    @Override
    public String updatePassword(Member member) {
        members.get(member.getMemberName()).setPw(member.getPw());
        return "비밀번호 변경 완료";

    }

    @Override
    public String delete(Member member) {
        members.remove(member.getMemberName());
        return "회원삭제";
    }

    @Override
    public Map <String, Member> getMemberMap() {
        /*Map<String, MemberDto> members = memberController.getMemberMap();*/
        /*members.forEach((k,v)-> {
            System.out.printf("아이디 : %s, 회원정보: %s\n", k, v);
        });*/
        return members;
    }



    @Override
    public List<?> findMembersByName(String name) {
        return members
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findMembersByFromName(String name) {
        return members
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public List<?> findMembersByJob(String job) {
        return members
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findMembersByFromJob(String job) {
        return members
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }


    @Override
    public String addMembers() {
        Map<String, Member>map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String memberName = UtilServiceImpl.getInstance().createRandomMemberName();
            map.put(memberName,
                    Member.builder()
                            .memberName(memberName)
                            .pw("1")
                            .name(UtilServiceImpl.getInstance().createRandomName())
                            .job(UtilServiceImpl.getInstance().createRandomName())
                            .build());

        }
        members = map;
        return members.size()+" 개 더미값 추가";
    }

    @Override
    public Map<String, ?> findMembersByJobFromMap(String job) {
        return null;
    }

    @Override
    public List<?> findMembers() throws SQLException {
        return repository.findMembers();
    }
}