package com.seungsu.springstudy;

import com.seungsu.springstudy.member.Grade;
import com.seungsu.springstudy.member.Member;
import com.seungsu.springstudy.member.MemberService;
import com.seungsu.springstudy.member.MemberServiceImpl;
import com.seungsu.springstudy.order.Order;
import com.seungsu.springstudy.order.OrderService;
import com.seungsu.springstudy.order.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order: " + order);
	}

}
