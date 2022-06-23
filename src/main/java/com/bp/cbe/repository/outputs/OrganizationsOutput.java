package com.bp.cbe.repository.outputs;

import java.util.List;

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
public class OrganizationsOutput {

	private List<OrganizationDto> organizations;

	private ErrorOut error;

}
