package com.lorisensori.application.DTO;

import com.lorisensori.application.enums.LandEnums;
import com.lorisensori.application.enums.StatusEnums;
import com.lorisensori.application.logic.Adres;

import java.util.List;

public class BedrijfDTO {

    private String bedrijfsnaam;
    private String telefoonnummer;
    private String rekeningnummer;
    private String btwNummer;
    private String kvkNummer;
    private Adres adres;
    private MedewerkerDTO contactpersoon;
    private StatusEnums status;
    private List<MedewerkerDTO> medewerkers;
    private List<TankDTO> tanks;

    //////////////////////////////////////////////
    //GETTERS & SETTERS
    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public String getBtwNummer() {
        return btwNummer;
    }

    public void setBtwNummer(String btwNummer) {
        this.btwNummer = btwNummer;
    }

    public String getKvkNummer() {
        return kvkNummer;
    }

    public void setKvkNummer(String kvkNummer) {
        this.kvkNummer = kvkNummer;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public MedewerkerDTO getContactpersoon() {
        return contactpersoon;
    }

    public void setContactpersoon(MedewerkerDTO contactpersoon) {
        this.contactpersoon = contactpersoon;
    }

    public StatusEnums getStatus() {
        return status;
    }

    public void setStatus(StatusEnums status) {
        this.status = status;
    }

    public List<TankDTO> getTanks() {
        return tanks;
    }

    public void setTanks(List<TankDTO> tanks) {
        this.tanks = tanks;
    }

    public List<MedewerkerDTO> getMedewerkers() {
        return medewerkers;
    }

    public void setMedewerkers(List<MedewerkerDTO> medewerkers) {
        this.medewerkers = medewerkers;
    }

    public void addMedewerker(MedewerkerDTO medewerker) {
        medewerkers.add(medewerker);
    }

    public void addTank(TankDTO tank){tanks.add(tank);}

    public void setAdres(String straatnaam, int huisnummer, String huisnummertoevoeging, String postcode, String plaatsnaam, LandEnums land) {
//		this.adres = adres;
        adres.setStraatnaam(straatnaam);
        adres.setHuisnummer(huisnummer);
        adres.setHuisnummertoevoeging(huisnummertoevoeging);
        adres.setPostcode(postcode);
        adres.setPlaatsnaam(plaatsnaam);
        adres.setLand(land);
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////