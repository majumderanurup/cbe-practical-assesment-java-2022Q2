package com.bp.cbe.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bp.cbe.dto.OrganizationDto;
import com.bp.cbe.dto.TribeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization")
public class OrganizationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_organization", nullable = false)
	private Long idOrganization;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "status", nullable = false)
	private int status;

	// Added One to Many for better practice
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organizationEntity")
	private Set<TribeEntity> tribeEntities;

	public OrganizationDto getAsDto() {

		Set<TribeDto> tribes = new HashSet<>();

		for (TribeEntity tribeEntity : tribeEntities) {
			tribes.add(tribeEntity.getAsDto());
		}

		return new OrganizationDto(this.idOrganization, this.name, this.status, tribes);

	}

}
