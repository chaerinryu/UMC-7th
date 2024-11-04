package umc.spring.sevice.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findOngoingMissionsByMemberId(Long memberId) {
        return missionRepository.findOngoingMissionsByMemberId(memberId);
    }

    @Override
    public List<Mission> findCompletedMissionsByMemberId(Long memberId) {
        return missionRepository.findCompletedMissionsByMemberId(memberId);
    }

    @Override
    public List<Mission> findOngoingMissionByAddress(String address) {
        return missionRepository.findOngoingMissionByAddress(address);
    }
}
