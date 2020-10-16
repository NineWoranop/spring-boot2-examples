package com.nineworanop.examplebackend01.service;

import org.springframework.stereotype.Service;

import com.nineworanop.examplebackend01.dto.Point;
import com.nineworanop.examplebackend01.dto.PointsOfTriangle;

@Service
public class MathServiceImpl implements MathService {

	@Override
	public Float areaOfTriangle(final PointsOfTriangle points) {
		final Point a = points.getA();
		final Point b = points.getB();
		final Point c = points.getC();
		float area = (a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0f;
		return Math.abs(area);
	}

	@Override
	public Integer plus(final Integer x, final Integer y) {
		return x + y;
	}
}
