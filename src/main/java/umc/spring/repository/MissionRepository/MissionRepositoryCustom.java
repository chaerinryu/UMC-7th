package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    // 진행 중인 미션
    List<Mission> findOngoingMissionsByMemberId(Long memberId);

    // 완료된 미션
    List<Mission> findCompletedMissionsByMemberId(Long memberId);

    // 홈화면
    List<Mission> findOngoingMissionByAddress(String address);
}
