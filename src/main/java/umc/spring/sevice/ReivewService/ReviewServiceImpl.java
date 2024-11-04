package umc.spring.sevice.ReivewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(Long memberId, Long storeId, String content, Float score) {
        Review review = Review.builder()
                .store(storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found")))
                .member(memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found")))
                .body(content)
                .score(score)
                .build();

        return reviewRepository.save(review);
    }
}
