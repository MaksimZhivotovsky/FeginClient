package com.exempl.max.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exempl.max.fegin.AddressFeginClient;
import com.exempl.max.model.Address;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

	private final AddressFeginClient addressFeginClient;
	
	public List<Address> getAddresses() {
		return addressFeginClient.getAllAddresses();
	}
	
	public Address addAddress(Address address) {
		return addressFeginClient.saveAddress(address);
	}
	
	public Address getAddress(Long id) {
		return addressFeginClient.getAddress(id);
	}
}
