package com.nineworanop.starter.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class PointsOfTriangle {
	@NonNull
	private Point a;
	@NonNull
	private Point b;
	@NonNull
	private Point c;
}
