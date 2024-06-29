package com.seungsu.springstudy;

import com.seungsu.springstudy.member.Grade;
import com.seungsu.springstudy.member.Member;
import com.seungsu.springstudy.member.MemberService;
import com.seungsu.springstudy.order.Order;
import com.seungsu.springstudy.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
//		MemberService memberService = new MemberServiceImpl();
//		OrderService orderService = new OrderServiceImpl();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order: " + order);
	}

}
