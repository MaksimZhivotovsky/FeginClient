package com.exempl.max.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exempl.max.model.Address;
import com.exempl.max.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

	private final AddressRepository addressRepository;
	
	@GetMapping
	public ResponseEntity<List<Address>> getAllAddresses() {
		try {
			log.info("AddressController.getAllAddresses : {}", addressRepository.findAll());
			return ResponseEntity.ok(addressRepository.findAll());
		} catch (Exception e) {
			return new ResponseEntity<List<Address>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		try {
			log.info("AddressController.saveAddress : {}", address);
			return ResponseEntity.ok(addressRepository.save(address));
		} catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable("id") Long id) {
		try {
			log.info("AddressController.getAddress : {}", addressRepository.findById(id).get());
			return ResponseEntity.ok(addressRepository.findById(id).get());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id,
			@RequestBody Address address) {
		Address dataAddress = addressRepository.findById(id).get();
		if(dataAddress != null) {
			dataAddress.setCity(address.getCity());
			dataAddress.setStreet(address.getStreet());
			addressRepository.save(dataAddress);
			log.info("AddressController.updateAddresses : {}", dataAddress);
			return ResponseEntity.ok(dataAddress);
		}
		return new ResponseEntity(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAddress(@PathVariable("id") Long id) {
		addressRepository.deleteById(id);
	}
}
