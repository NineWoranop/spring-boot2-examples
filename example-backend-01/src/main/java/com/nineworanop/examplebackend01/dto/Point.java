package com.nineworanop.examplebackend01.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Point {
	@NonNull
	private Integer x;
	@NonNull
	private Integer y;

}
