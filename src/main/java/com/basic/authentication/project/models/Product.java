package com.basic.authentication.project.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Schema(description = "Product identifier.", example = "100100100", required = false)
	private Integer id;

	@Schema(description = "Product name.", example = "Tv Sony 30\"", required = true)
	@NotEmpty
	private String name;

	@Schema(description = "Price of product.", example = "10000.00", required = true)
	@NotNull
	private BigDecimal price;

	@Schema(description = "Date creation.", example = "2022/10/06 22:12:12", required = true)
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date createAt;
	
}
