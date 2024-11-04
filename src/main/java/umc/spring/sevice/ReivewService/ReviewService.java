package umc.spring.sevice.ReivewService;

import umc.spring.domain.Review;

public interface ReviewService {
    Review addReview(Long memberId, Long storeId, String content, Float score);
}
