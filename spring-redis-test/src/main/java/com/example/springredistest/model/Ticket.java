package com.example.springredistest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class Ticket {
    private int id;
    private int memberNo;
}
