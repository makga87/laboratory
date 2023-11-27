package com.example.springmultimodule.feat.reserve;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.springmultimodule.feat.member.MemberService;


@RequiredArgsConstructor
@Service
public class ReserveService {

	private final MemberService memberService;

	public int getReserveNoByMemberNo(int memberNo) {
		return 10045;
	}

	public Map<String, Object> getReserveInfoByReserveNo(int reserveNo) {

		int result = memberService.getMemberNo();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("reserveNo", reserveNo);
		dataMap.put("memberNo", result);

		return dataMap;
	}
}
