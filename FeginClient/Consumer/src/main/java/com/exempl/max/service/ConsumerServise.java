package com.exempl.max.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exempl.max.fegin.AddressFeginClient;
import com.exempl.max.model.Address;
import com.exempl.max.model.Consumer;
import com.exempl.max.repository.ConsumerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumerServise {

	private final AddressFeginClient addressFeginClient;
	private final ConsumerRepository consumerRepository;
	

	
	public List<Consumer> findConsumers() {
		return consumerRepository.findAll();
	}
	
	public Consumer saveConsumer(Consumer consumer, Long addressId) {
		Address address = addressFeginClient.getAddress(addressId);
		if(address != null) {
			consumer.setAddressId(addressId);
			consumer.setCity(address.getCity());
			consumer.setStreet(address.getStreet());
			consumerRepository.save(consumer);
		}
		return consumer;
	}
	
	public Consumer getConsumer(Long addressId, Long idConsumer) {
		Address address = addressFeginClient.getAddress(addressId);
		Consumer consumer = consumerRepository.findById(idConsumer).get();
		if(address != null && consumer.getAddressId().equals(address.getAddressId())) {
			consumer.setCity(address.getCity());
			consumer.setStreet(address.getStreet());
			return consumer;
		} else {
			throw new RuntimeException();
		}
	}
	
	public Consumer updateConsumer(Long idAddress, Long idConsumer,
			Consumer consumer) {
		Address address = addressFeginClient.getAddress(idAddress);
		Consumer dataConsumer = consumerRepository.findById(idConsumer).get();
		if(dataConsumer != null) {
			dataConsumer.setName(consumer.getName());
			dataConsumer.setAddressId(address.getAddressId());
			dataConsumer.setCity(address.getCity());
			dataConsumer.setStreet(address.getStreet());
			return consumerRepository.save(dataConsumer);
		} else {
			throw new RuntimeException();
		}
	}
	
	public void deleteConsumer(Long id) {
		consumerRepository.deleteById(id);
	}
}
