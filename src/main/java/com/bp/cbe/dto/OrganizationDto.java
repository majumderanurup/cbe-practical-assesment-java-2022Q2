package com.bp.cbe.dto;

import java.util.Set;

import com.bp.cbe.entities.OrganizationEntity;
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
public class OrganizationDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long idOrganization;

	private String name;

	private int status;
	
	private Set<TribeDto> tribes;

	@JsonIgnore
	public OrganizationEntity getAsEntity() {

		OrganizationEntity organizationEntity = new OrganizationEntity();

		organizationEntity.setName(this.name);
		organizationEntity.setStatus(this.status);

		return organizationEntity;

	}

}
