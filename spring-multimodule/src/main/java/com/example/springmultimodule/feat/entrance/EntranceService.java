package com.example.springmultimodule.feat.entrance;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.springmultimodule.feat.reserve.ReserveService;

@RequiredArgsConstructor
@Service
public class EntranceService {

	private final ReserveService reserveService;

	public Map<String, Object> getEntranceInfoByReserveNo(int reserveNo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("reserveInfo", reserveService.getReserveInfoByReserveNo(reserveNo));
		dataMap.put("entranceNo", 10055);

		return dataMap;
	}
}
