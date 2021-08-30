package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    /**
     * @Test 가 붙은 테스트 함수들은 순서가 보장되지 않기 때문에 꼭 테스트가 끝난 후, 리셋해야 한다
     */
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void MEMBER_FINDALL_TEST() {
        // GIVEN(주어졌을 때)
        Member member1 = new Member("davincij", 30);
        Member member2 = new Member("hojong", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // WHEN(실행되었을 때)
        List<Member> members = memberRepository.findAll();

        // THEN(결과는 ~다)
        assertThat(members.size()).isEqualTo(2);
    }

    @Test
    void MEMBER_SAVE_TEST() {
        // GIVEN
        MemberRepository memberRepository = MemberRepository.getInstance();
        Member member1 = new Member("davincij", 30);

        // WHEN
        Member savedMember = memberRepository.save(member1);
        Member findMember = memberRepository.findById(savedMember.getId());

        // THEN
        assertThat(member1).isSameAs(findMember);
    }
}