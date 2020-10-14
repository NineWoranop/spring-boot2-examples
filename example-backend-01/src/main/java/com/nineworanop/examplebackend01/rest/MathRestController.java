package com.nineworanop.examplebackend01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nineworanop.examplebackend01.dto.PointsOfTriangle;
import com.nineworanop.examplebackend01.service.MathService;

@RestController
@RequestMapping("/rest/math")
public class MathRestController {

	private final MathService mathService;

	@Autowired
	public MathRestController(final MathService mathService) {
		this.mathService = mathService;
	}

	@PostMapping(path = "/area/triangle")
    public Float areaOfTriangle(@RequestBody PointsOfTriangle points) {
        return mathService.areaOfTriangle(points);
    }

    @GetMapping(path = "/plus")
    public Integer plus(@RequestParam("x") final Integer x, @RequestParam("y") final Integer y) {
        return mathService.plus(x, y);
    }
}
