package com.basic.authentication.project.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.authentication.project.models.Error;
import com.basic.authentication.project.models.Product;
import com.basic.authentication.project.service.ProductService;
import com.basic.authentication.project.utils.HttpDescription;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Products", description = "Products methods")
@ApiResponses(value = {
        @ApiResponse(responseCode = HttpDescription.STATUS_400, description = HttpDescription.MSG_400, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))}),
		@ApiResponse(responseCode = HttpDescription.STATUS_401, description = HttpDescription.MSG_401, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))}),
        @ApiResponse(responseCode = HttpDescription.STATUS_403, description = HttpDescription.MSG_403, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))}),
        @ApiResponse(responseCode = HttpDescription.STATUS_404, description = HttpDescription.MSG_404, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))}),
        @ApiResponse(responseCode = HttpDescription.STATUS_500, description = HttpDescription.MSG_500, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))}),
        @ApiResponse(responseCode = HttpDescription.STATUS_503, description = HttpDescription.MSG_503, content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))})
})
@RestController
@RequestMapping("/products")
public class ProductsRestController {


	@Autowired
	private ProductService productService;
	
    @Operation(summary = "Get all products.", security = @SecurityRequirement(name = HttpDescription.SCHEME_NAME) ,
            responses = { @ApiResponse( description = HttpDescription.MSG_200, responseCode = HttpDescription.STATUS_200,
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema( schema = @Schema(implementation =  Product.class, type = "array" )))})})
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(this.productService.findAll());
	}


    @Operation(summary = "Get product by id.", security = @SecurityRequirement(name = "bearer-jwt") ,
            responses = { @ApiResponse( description = HttpDescription.MSG_200, responseCode = HttpDescription.STATUS_200,
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                             schema = @Schema(implementation =  Product.class))})})
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok().body(this.productService.findByid(id));
	}

    

    @Operation(summary = "New product.", security = @SecurityRequirement(name = "bearer-jwt") ,
            responses = { @ApiResponse( description = HttpDescription.MSG_201, responseCode = HttpDescription.STATUS_201,
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                             schema = @Schema(implementation =  Product.class))})})
    @PostMapping
	public ResponseEntity<?> addNew(@RequestBody Product request){
		var response = this.productService.newProduct(request);
		return ResponseEntity.created(URI.create("/products" + response.getId())).body(response);
	}


    @Operation(summary = "update product.", security = @SecurityRequirement(name = "bearer-jwt") ,
            responses = { @ApiResponse( description = HttpDescription.MSG_201, responseCode = HttpDescription.STATUS_201,
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                             schema = @Schema(implementation =  Product.class))})})
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product request){
		var response = this.productService.updateProduct(request);
		return ResponseEntity.created(URI.create("/products" + response.getId())).body(response);
	}
	

    @Operation(summary = "Delete product.", security = @SecurityRequirement(name = "bearer-jwt") ,
            responses = { @ApiResponse( description = HttpDescription.MSG_204, responseCode = HttpDescription.STATUS_204,
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                             schema = @Schema(implementation =  Void.class))})})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		this.productService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
