package com.bp.cbe.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class GenericHandledException extends Exception {

	private String errorCode;

	private String errorMessage;

}
