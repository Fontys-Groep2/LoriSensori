package com.lorisensori.application.DAO_interfaces;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorisensori.application.domain.SensorLog;

@Repository
public interface SensorLogRepository extends JpaRepository<SensorLog, Long>{
	
//	Set<SensorLog> findNewest25();
}
