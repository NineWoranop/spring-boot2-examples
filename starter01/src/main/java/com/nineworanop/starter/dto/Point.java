package com.nineworanop.starter.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Point {
	@NonNull
	private Integer x;
	@NonNull
	private Integer y;

}
