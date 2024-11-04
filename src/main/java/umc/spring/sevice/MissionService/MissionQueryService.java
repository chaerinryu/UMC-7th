package umc.spring.sevice.MissionService;

import umc.spring.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> findOngoingMissionsByMemberId(Long memberId);
    List<Mission> findCompletedMissionsByMemberId(Long memberId);
    List<Mission> findOngoingMissionByAddress(String address);
}
