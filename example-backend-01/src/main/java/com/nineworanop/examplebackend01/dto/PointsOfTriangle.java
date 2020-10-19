package com.nineworanop.examplebackend01.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PointsOfTriangle {
	@NonNull
	private Point a;
	@NonNull
	private Point b;
	@NonNull
	private Point c;
}
