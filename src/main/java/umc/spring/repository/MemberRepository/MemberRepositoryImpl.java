package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = QMember.member;

    @Override
    public Optional<Member> findByMemberid(Long memberId) {

        Member foundMember = jpaQueryFactory
                .select(qMember)
                .from(qMember)
                .where(qMember.id.eq(memberId))
                .fetchOne();

        return Optional.ofNullable(foundMember);
    }
}
