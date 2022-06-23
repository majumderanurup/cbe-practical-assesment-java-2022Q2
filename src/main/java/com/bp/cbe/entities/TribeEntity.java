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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bp.cbe.dto.RepositoryDto;
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
@Table(name = "tribe")
public class TribeEntity {

	@Id
	// Added @GeneratedValue for better practice
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tribe", nullable = false)
	private Long idTribe;

	// Removed simple col and added Many to one
	/*
	 * @Column(name = "id_organization") private Long idOrganization;
	 */

	@ManyToOne
	@JoinColumn(name = "id_organization", referencedColumnName = "id_organization", nullable = false)
	private OrganizationEntity organizationEntity;

	// Added nullable = false and length =50 as per bdd photo
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "status", nullable = false)
	private int status;

	// Added One to Many for better practice
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tribeEntity")
	private Set<RepositoryEntity> repositoryEntities;

	public TribeDto getAsDto() {

		Set<RepositoryDto> repositories = new HashSet<>();

		for (RepositoryEntity repositoryEntity : repositoryEntities) {
			repositories.add(repositoryEntity.getAsDto());
		}

		return new TribeDto(this.idTribe, this.organizationEntity.getName(), this.name, this.status, repositories);

	}

}
