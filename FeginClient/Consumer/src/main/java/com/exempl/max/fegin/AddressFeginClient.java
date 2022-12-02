package com.exempl.max.fegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exempl.max.model.Address;

@FeignClient(name = "AddressFeginClient", url = "${base-url}")
public interface AddressFeginClient {

	@GetMapping(value = "/address", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Address> getAllAddresses();
	
	@PostMapping(value = "/address", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address saveAddress(Address address);
	
	@GetMapping(value = "/address/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Address getAddress(@PathVariable("id") Long id);

	@PutMapping(value = "/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id,
			@RequestBody Address address);
	
	@DeleteMapping(value = "/address/{id}")
	public void deleteAddress(@PathVariable("id") Long id);
}
