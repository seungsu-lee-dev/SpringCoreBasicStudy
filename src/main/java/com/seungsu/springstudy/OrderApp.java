package com.seungsu.springstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.seungsu.springstudy.member.Grade;
import com.seungsu.springstudy.member.Member;
import com.seungsu.springstudy.member.MemberService;
import com.seungsu.springstudy.order.Order;
import com.seungsu.springstudy.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
//		MemberService memberService = new MemberServiceImpl();
//		OrderService orderService = new OrderServiceImpl();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order: " + order);
	}

}
//