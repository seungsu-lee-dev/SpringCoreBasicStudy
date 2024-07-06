package com.seungsu.springstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.seungsu.springstudy.member.Grade;
import com.seungsu.springstudy.member.Member;
import com.seungsu.springstudy.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		MemberService memberService = new MemberServiceImpl();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member: " + member.getName());
		System.out.println("find member: " + findMember.getName());
	}

}
