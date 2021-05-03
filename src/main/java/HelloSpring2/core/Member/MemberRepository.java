package HelloSpring2.core.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
