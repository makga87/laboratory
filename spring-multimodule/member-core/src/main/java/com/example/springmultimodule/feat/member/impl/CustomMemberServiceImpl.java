package com.example.springmultimodule.feat.member.impl;

import org.springframework.stereotype.Service;

import com.example.springmultimodule.feat.member.MemberService;

@Service
public class CustomMemberServiceImpl implements MemberService {

	@Override
	public int getMemberNo() {
		return 10037;
	}
}
