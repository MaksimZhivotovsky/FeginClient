package com.exempl.max.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exempl.max.model.Address;
import com.exempl.max.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/fegin")
public class AddressController {

	private final AddressService addressService;
	
	@GetMapping
	public List<Address> getAddresses() {
		return addressService.getAddresses();
	}
	
	@PostMapping
	public Address saveAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@GetMapping(value = "/{id}")
	public Address getAddress(@PathVariable("id") Long id) {
		return addressService.getAddress(id);
	}
}
