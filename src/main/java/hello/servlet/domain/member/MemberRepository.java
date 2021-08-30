package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // static 사용여부는 단지 변수가 어느 메모리에 할당되느냐에 차이만 있을뿐 다르 차이는 없다.
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    //싱글톤 방식으로 사용
    private static final MemberRepository INSTANCE = new MemberRepository();

    private MemberRepository() {}

    public static MemberRepository getInstance() {
        return INSTANCE;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(sequence, member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}