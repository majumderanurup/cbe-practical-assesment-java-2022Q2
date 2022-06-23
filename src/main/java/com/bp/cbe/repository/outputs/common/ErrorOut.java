package com.bp.cbe.repository.outputs.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorOut {

	private String errorCode;

	private String errorMessage;

}