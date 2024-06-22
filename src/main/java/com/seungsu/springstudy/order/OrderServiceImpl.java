package com.seungsu.springstudy.order;

import com.seungsu.springstudy.discount.DiscountPolicy;
import com.seungsu.springstudy.discount.FixDiscountPolicy;
import com.seungsu.springstudy.member.Member;
import com.seungsu.springstudy.member.MemberRepository;
import com.seungsu.springstudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	private MemberRepository memberRepository = new MemoryMemberRepository();
	private DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
