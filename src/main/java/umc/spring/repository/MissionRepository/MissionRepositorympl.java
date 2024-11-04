package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositorympl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QRegion region = QRegion.region;

    @Override
    public List<Mission> findOngoingMissionsByMemberId(Long memberId) {
        return jpaQueryFactory
                .select(memberMission.mission)
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.eq(MissionStatus.CHALLENGING)))
                .fetch();
    }

    @Override
    public List<Mission> findCompletedMissionsByMemberId(Long memberId) {
        QMemberMission memberMission = QMemberMission.memberMission;

        return jpaQueryFactory
                .select(memberMission.mission)
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.eq(MissionStatus.COMPLETE)))
                .fetch();
    }

    @Override
    public List<Mission> findOngoingMissionByAddress(String address) {
        return jpaQueryFactory
                .select(mission)
                .from(mission)
                .where(memberMission.status.eq(MissionStatus.CHALLENGING)
                        .and(mission.store.id.in(
                                JPAExpressions.select(store.id)
                                        .from(store)
                                        .where(store.region.id.in(
                                                JPAExpressions.select(region.id)
                                                        .from(region)
                                                        .where(region.name.eq(address))
                                        ))
                        )))
                .orderBy(mission.createdAt.desc())
                .limit(15)
                .fetch();
    }
}
