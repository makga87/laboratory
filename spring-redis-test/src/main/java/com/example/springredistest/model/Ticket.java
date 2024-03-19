package com.example.springredistest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Ticket implements Serializable {

	private static final long serialVersionUID = 5084766631518237388L;

	private int id;
	private int memberNo;
}
