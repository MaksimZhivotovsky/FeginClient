package com.exempl.max.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exempl.max.fegin.AddressFeginClient;
import com.exempl.max.model.Address;
import com.exempl.max.model.Consumer;
import com.exempl.max.service.ConsumerServise;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fegin/{idAddress}/consumer")
@RequiredArgsConstructor
public class ConsumerController {

	private final ConsumerServise consumerServise;

	@GetMapping
	public List<Consumer> getAllConsumers() {
		return consumerServise.findConsumers();
	}
	
	@PostMapping
	public Consumer saveConsumer(@RequestBody Consumer consumer,
			@PathVariable("idAddress") Long idAddress) {
		return consumerServise.saveConsumer(consumer, idAddress);
	}
	
	@GetMapping(value = "/{idConsumer}")
	public Consumer getConsumer(@PathVariable("idAddress") Long idAddress,
			@PathVariable("idConsumer") Long idConsumer) {
		return consumerServise.getConsumer(idAddress, idConsumer);
	}
	
	@PutMapping(value = "/{idConsumer}")
	public Consumer updateConsumer(@PathVariable("idAddress") Long idAddress,
			@PathVariable("idConsumer") Long idConsumer, @RequestBody Consumer consumer) {
		return consumerServise.updateConsumer(idAddress, idConsumer, consumer);
	}
	
	@DeleteMapping(value = "/{idConsumer}")
	public void delete(@PathVariable("idConsumer") Long id) {
		consumerServise.deleteConsumer(id);
	}
}
