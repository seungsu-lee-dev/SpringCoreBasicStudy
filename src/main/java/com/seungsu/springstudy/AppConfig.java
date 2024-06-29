package com.seungsu.springstudy;

import com.seungsu.springstudy.discount.FixDiscountPolicy;
import com.seungsu.springstudy.member.MemberService;
import com.seungsu.springstudy.member.MemberServiceImpl;
import com.seungsu.springstudy.member.MemoryMemberRepository;
import com.seungsu.springstudy.order.OrderService;
import com.seungsu.springstudy.order.OrderServiceImpl;

public class AppConfig {
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	private MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	private FixDiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}
