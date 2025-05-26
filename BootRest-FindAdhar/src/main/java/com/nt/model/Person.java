package com.nt.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private Integer pno;
	private String pname;
	private String padd;
	private Long pmobile;
	private String padhar;
	private LocalDate pdob;
}
