package com.lorisensori.application.service;

import com.lorisensori.application.DAO_interfaces.MedewerkerRepository;
import com.lorisensori.application.DTOs.medewerkerDTOs.MedewerkerDTO;
import com.lorisensori.application.DTOs.medewerkerDTOs.UpdateMedewerkerDTO;
import com.lorisensori.application.domain.Bedrijf;
import com.lorisensori.application.domain.Medewerker;
import com.lorisensori.application.exceptions.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//Business logic goes here NOT in the repository
@Service("medewerkerService")
public class MedewerkerServiceImpl implements MedewerkerService {

    private final MedewerkerRepository medewerkerRepository;

    @Autowired
    public MedewerkerServiceImpl(MedewerkerRepository medewerkerRepository) {
        this.medewerkerRepository = medewerkerRepository;
    }

    @Override
    public Medewerker save(Medewerker medewerker) {
        if (!existsByVoornaam(medewerker.getVoornaam())) {
            return medewerkerRepository.save(medewerker);
        } else {
            throw new EntityExistsException("Medewerker", "Voornaam", medewerker.getVoornaam());
        }
    }

    @Override
    public boolean existsByVoornaam(String voornaam) {

        return medewerkerRepository.findByVoornaam(voornaam) != null;
    }

    @Override
    public List<Medewerker> findAll() {
    	return medewerkerRepository.findAll();
    }

    @Override
    public Set<Medewerker> findByBedrijf(Bedrijf bedrijf) {
    	return medewerkerRepository.findByBedrijf(bedrijf);
    }

    @Transactional
    public UpdateMedewerkerDTO update(Long id, UpdateMedewerkerDTO updateMedewerkerDTO){

        Medewerker entity = findById(id);

        entity.setGebruikersnaam(updateMedewerkerDTO.getGebruikersnaam());
        entity.setVoornaam(updateMedewerkerDTO.getVoornaam());
        entity.setAchternaam(updateMedewerkerDTO.getAchternaam());
        entity.setEmail(updateMedewerkerDTO.getEmail());
        entity.setTelefoonnummer(updateMedewerkerDTO.getTelefoonnummer());
        entity.setActive(updateMedewerkerDTO.getActive());
        entity.setEmailVerified(updateMedewerkerDTO.getEmailVerified());

        return new UpdateMedewerkerDTO(entity.getGebruikersnaam(), entity.getVoornaam(), entity.getAchternaam(), entity.getEmail(),
                entity.getTelefoonnummer(), entity.getActive(), entity.getEmailVerified());
    }

    @Override
    public Medewerker findById(Long id) {
        return medewerkerRepository.getOne(id);
    }

    @Override
    public Medewerker findByVoornaam(String voornaam) {
        return medewerkerRepository.findByVoornaam(voornaam);
    }

    @Override
    public Optional<Medewerker> findByGebruikersnaam(String gebruikersnaam) {
        return medewerkerRepository.findByGebruikersnaam(gebruikersnaam);
    }

    @Override
    public void delete(Medewerker medewerker) {
        medewerkerRepository.delete(medewerker);
    }

}
