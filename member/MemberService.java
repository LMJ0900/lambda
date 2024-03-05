package member;

import java.util.List;
import java.util.Map;

public interface MemberService {
    String login(Member member);


    String updatePassword(String memberName, String updatePw);


    Map<String, ?> getMemberMap();

    List<?> findMembersByName(String Name);
    Map<String, ?> findMembersByFromName(String Name);
    List<?> findMembersByJob(String job);
    Map<String, ?> findMembersByFromJob(String job);


    String addMembers();

    Map<String,?> findMembersByJobFromMap(String job);
}
