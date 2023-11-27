package com.example.springmodulecomponent.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springmultimodule.feat.member.MemberService;

@Service
public class UserService {

	private final MemberService memberService;

	public UserService(@Qualifier("customMemberServiceImpl") MemberService memberService) {
		this.memberService = memberService;
	}

	public int getMemberNo() {
		return memberService.getMemberNo();
	}

}
