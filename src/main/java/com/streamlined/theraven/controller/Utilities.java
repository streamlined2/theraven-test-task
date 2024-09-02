package com.streamlined.theraven.controller;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utilities {

	public URI getResourceURI(HttpServletRequest servletRequest, Long id) {
		return UriComponentsBuilder.fromHttpUrl(servletRequest.getRequestURL().toString()).pathSegment("{id}")
				.build(id);
	}

}
