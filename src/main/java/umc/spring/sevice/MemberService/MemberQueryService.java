package umc.spring.sevice.MemberService;

import umc.spring.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findById(Long memberId);
}
