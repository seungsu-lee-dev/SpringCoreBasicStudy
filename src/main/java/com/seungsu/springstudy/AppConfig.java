package com.seungsu.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seungsu.springstudy.discount.DiscountPolicy;
import com.seungsu.springstudy.discount.FixDiscountPolicy;
import com.seungsu.springstudy.discount.RateDiscountPolicy;
import com.seungsu.springstudy.member.MemberRepository;
import com.seungsu.springstudy.member.MemberService;
import com.seungsu.springstudy.member.MemberServiceImpl;
import com.seungsu.springstudy.member.MemoryMemberRepository;
import com.seungsu.springstudy.order.OrderService;
import com.seungsu.springstudy.order.OrderServiceImpl;


@Configuration
public class AppConfig {
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
