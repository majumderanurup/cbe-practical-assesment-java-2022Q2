package com.bp.cbe.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bp.cbe.dto.RepositoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repository")
public class RepositoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_repository", nullable = false)
	private Long idRepository;

	/*
	 * @Column(name = "id_tribe") private Long idTribe;
	 */

	@ManyToOne
	@JoinColumn(name = "id_tribe", referencedColumnName = "id_tribe", nullable = false)
	private TribeEntity tribeEntity;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "state", nullable = false, length = 1)
	private String state;

	// Added length = 1 as per diagram
	@Column(name = "status", nullable = false, length = 1)
	private String status;

	@Column(name = "create_time", nullable = false)
	private LocalDateTime createTime;

	// Added One to One for better practice
	@OneToOne(mappedBy = "repositoryEntity")
	private MetricsEntity metricsEntity;

	public RepositoryDto getAsDto() {

		return new RepositoryDto(this.idRepository, this.tribeEntity.getName(), this.name, this.state, this.status,
				this.createTime, this.getMetricsEntity().getAsDto());

	}

}
