package com.bp.cbe.dto;

import java.time.LocalDateTime;

import com.bp.cbe.entities.RepositoryEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long idRepository;

	private String tribeName;

	private String name;

	private String state;

	private String status;

	private LocalDateTime createTime;

	private MetricsDto metrics;

	@JsonIgnore
	public RepositoryEntity getAsEntity() {

		RepositoryEntity repositoryEntity = new RepositoryEntity();

		repositoryEntity.setName(this.name);
		repositoryEntity.setState(this.state);
		repositoryEntity.setStatus(this.status);

		return repositoryEntity;
	}

}
