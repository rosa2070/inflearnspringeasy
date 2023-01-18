package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // Map에서 키(key)는 Long타입인 회원의 아이디, 값(value)은 Member
    // sequence는 0,1,2 ... 이렇게 키값을 생성해줌
    public static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // Optional은 Null이 될 가능성을 가진 값을 객체로 감싼다.
        return Optional.ofNullable(store.get(id));
    }

    //member.getName()이 parameter로 넘어온 name값과 같은지 확인. 같은 경우에만 필터링됨
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        // store를 싹 비운다.
        store.clear();
    }
}
