package com.nineworanop.examplebackend01.service;

import com.nineworanop.examplebackend01.dto.PointsOfTriangle;

public interface MathService {
	Float areaOfTriangle(PointsOfTriangle points);
	Integer plus(Integer x, Integer y);
}
