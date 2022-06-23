package com.bp.cbe.repository.outputs;

import com.bp.cbe.dto.OrganizationDto;
import com.bp.cbe.repository.outputs.common.ErrorOut;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationOutput {
	
	private OrganizationDto organization;

	private ErrorOut error;

}
