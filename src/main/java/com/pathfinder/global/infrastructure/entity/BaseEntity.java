package com.pathfinder.global.infrastructure.entity;

import java.time.Instant;

import org.hibernate.annotations.FilterDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@FilterDef(
	name = "notDeleted",
	defaultCondition = "deleted_At IS NULL",
	autoEnabled = true
)
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@CreatedDate
	@Column(name = "created_At")
	private Instant createdAt;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@LastModifiedDate
	@Column(name = "modified_At")
	private Instant modifiedAt;

	@LastModifiedBy
	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "deleted_At")
	private Instant deletedAt;

	@Column(name = "deleted_By")
	private String deletedBy;

	public void softDelete(Instant deletedAt, Long userId) {
		this.deletedAt = deletedAt;
		this.deletedBy = userId.toString();
	}
}
