package com.example.springredistest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Ticket {
	private int id;
	private int memberNo;
}
