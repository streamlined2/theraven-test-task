package com.streamlined.theraven.dto;

import java.util.Objects;
import lombok.Builder;

@Builder
public record CustomerDto(Long id, String fullName, String email, String phone, boolean isActive) {

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CustomerDto dto) {
			return Objects.equals(id, dto.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
