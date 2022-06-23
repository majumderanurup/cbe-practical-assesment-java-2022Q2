package com.bp.cbe.dto;

import com.bp.cbe.entities.MetricsEntity;
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
public class MetricsDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long idRepository;

	private String repositoryName;

	private Double coverage;

	private int bugs;

	private int vulnerabilities;

	private int hotspot;

	private int codeSmells;

	@JsonIgnore
	public MetricsEntity getAsEntity() {

		MetricsEntity metricsEntity = new MetricsEntity();

		metricsEntity.setCoverage(this.coverage);
		metricsEntity.setBugs(this.bugs);
		metricsEntity.setVulnerabilities(this.vulnerabilities);
		metricsEntity.setHotspot(this.hotspot);
		metricsEntity.setCodeSmells(this.codeSmells);

		return metricsEntity;

	}

}