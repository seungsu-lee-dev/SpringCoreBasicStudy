package com.seungsu.springstudy.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.seungsu.springstudy.member.MemberService;

public class XmlAppContext {
	@Test
	void xmlAppContext() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
