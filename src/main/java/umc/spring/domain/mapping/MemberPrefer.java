package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memeber_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}
