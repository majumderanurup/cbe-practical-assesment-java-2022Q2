package com.bp.cbe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bp.cbe.dto.MetricsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "metrics")
public class MetricsEntity {

	@Id
	@Column(name = "id_repository", nullable = false)
	private Long idRepository;

	// Added for PK = FK challenge
	@OneToOne
	@JoinColumn(name = "id_repository")
	@MapsId
	private RepositoryEntity repositoryEntity;

	@Column(name = "coverage", nullable = false)
	private Double coverage;

	@Column(name = "bugs", nullable = false)
	private int bugs;

	@Column(name = "vulnerabilities", nullable = false)
	private int vulnerabilities;

	@Column(name = "hotspot", nullable = false)
	private int hotspot;

	@Column(name = "code_smells", nullable = false)
	private int codeSmells;

	public MetricsDto getAsDto() {

		return new MetricsDto(this.idRepository, this.repositoryEntity.getName(), this.coverage, this.bugs,
				this.vulnerabilities, this.hotspot, this.codeSmells);

	}

}
