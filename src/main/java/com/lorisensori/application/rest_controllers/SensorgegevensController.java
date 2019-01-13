package com.lorisensori.application.rest_controllers;

import com.lorisensori.application.DTOs.tankDTOs.SensorgegevensDTO;
import com.lorisensori.application.domain.Sensorgegevens;
import com.lorisensori.application.service.SensorgegevensService;
import com.lorisensori.application.service.TankService;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class SensorgegevensController {

    private final SensorgegevensService sensorgegevensService;
    
    @Autowired
    private TankService tankService;
    
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/tank/sensorgegevens/{tankid}")
	public Set<SensorgegevensDTO> getAllSensorgegeven(@PathVariable(value = "tankId") Long tankId) {
		Set<Sensorgegevens> sensorgegevens = sensorgegevensService.findByTank(tankService.findByTankId(tankId));
		return sensorgegevens.stream().map(sensorgegevensService::convertToDto).collect(Collectors.toSet());
	}

	@Autowired
	public SensorgegevensController(SensorgegevensService sensorgegevensService, TankService tankService) {
		this.sensorgegevensService = sensorgegevensService;
		this.tankService = tankService;
	}
	
	
	
	
}