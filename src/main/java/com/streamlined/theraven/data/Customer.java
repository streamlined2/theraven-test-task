package com.streamlined.theraven.data;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private LocalDateTime createdTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false)
	private LocalDateTime updatedTime;

	@Size(min = 2, max = 50, message = "Customer name should contain from 2 to 50 characters")
	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Size(min = 2, max = 100, message = "Customer email should contain from 2 to 100 characters")
	@Column(name = "email", nullable = false, unique = true)
	@Email(regexp = "^(.+)@(.+)$", message = "Incorrect email")
	@NaturalId
	private String email;

	@Size(min = 6, max = 14, message = "Customer phone should contain from 6 to 14 characters")
	@Column(name = "phone")
	@Pattern(regexp = "^\\+\\d+$", message = "Phone number must consist of digits with leading +")
	private String phone;

	@Column(name = "is_active", nullable = false)
	@Builder.Default
	private boolean isActive = true;

}
