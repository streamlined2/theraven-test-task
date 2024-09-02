package com.streamlined.theraven.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.streamlined.theraven.exception.IncorrectDataException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class Utilities {

	public <T> Stream<T> stream(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}

	public void checkIfValid(Validator validator, Object entity, String entityType) {
		Set<ConstraintViolation<Object>> violations = validator.validate(entity);
		if (!violations.isEmpty()) {
			String violationDescription = Utilities.getViolations(violations);
			log.error("Incorrect {} data: {}", entityType, violationDescription);
			throw new IncorrectDataException("Incorrect %s data: %s".formatted(entityType, violationDescription));
		}
	}

	private <T> String getViolations(Set<ConstraintViolation<T>> violations) {
		return violations.stream().map(Utilities::formatViolation).collect(Collectors.joining(",", "[", "]"));
	}

	private <T> String formatViolation(ConstraintViolation<T> violation) {
		return "Error %s: property '%s' has invalid value '%s'".formatted(violation.getMessage(),
				violation.getPropertyPath(), violation.getInvalidValue());
	}

}
