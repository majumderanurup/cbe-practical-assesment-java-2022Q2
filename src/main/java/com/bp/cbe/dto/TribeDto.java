package com.bp.cbe.dto;

import java.util.Set;

import com.bp.cbe.entities.TribeEntity;
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
public class TribeDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long idTribe;

	private String organizationName;

	private String name;

	private int status;

	private Set<RepositoryDto> repositories;

	@JsonIgnore
	public TribeEntity getAsEntity() {

		TribeEntity tribeEntity = new TribeEntity();

		tribeEntity.setName(this.name);
		tribeEntity.setStatus(this.status);

		return tribeEntity;
	}

}
