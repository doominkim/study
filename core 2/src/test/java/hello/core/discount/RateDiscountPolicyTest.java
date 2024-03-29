package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10% 할인이 되어야한다.")
	void vip_o() {
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		int discountPrice = discountPolicy.discount(member, 10000);
		Assertions.assertThat(discountPrice).isEqualTo(1000);
	}

	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아아한다.")
	void vip_x() {
		Member member = new Member(1L, "memberBasic", Grade.BASIC);
		int discountPrice = discountPolicy.discount(member, 10000);
		Assertions.assertThat(discountPrice).isEqualTo(0);
	}


}