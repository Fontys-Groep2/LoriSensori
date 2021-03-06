package com.lorisensori.application.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lorisensori.application.enums.LandEnums;
import com.lorisensori.application.enums.StatusEnums;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bedrijf")
public class Bedrijf {
    /**
     *
     */

    @Id
    @Column
    private String bedrijfsnaam;

    @Column
    private String telefoonnummer, rekeningnummer, btwNummer, vatNummer, kvkNummer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adrescode")
    private Adres adres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactpersoon")
    private Medewerker contactpersoon;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusEnums status;

    @OneToMany(mappedBy = "bedrijf", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "medewerkers")
    private Set<Medewerker> medewerkers;

    @OneToMany(mappedBy = "bedrijf", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "tanks")
    private Set<Tank> tanks;


    public Set<Medewerker> getMedewerkers() {
        return medewerkers;
    }

    public void setMedewerkers(Set<Medewerker> medewerkers) {
        this.medewerkers = medewerkers;
    }

    public void addMedewerker(Medewerker medewerker) {
        if (medewerkers == null){
            medewerkers = new Set<Medewerker>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<Medewerker> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(Medewerker medewerker) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends Medewerker> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }
            };
        }
        if (!medewerkers.contains(medewerker)) medewerkers.add(medewerker);
        else {
            throw new EntityExistsException();
        }
    }

    public void addTank(Tank tank) {
        if (!tanks.contains(tank)) tanks.add(tank);
        else {
            throw new EntityExistsException();
        }
    }

    public void removeTank(Tank tank) {
        tanks.remove(tank);
    }


    public Bedrijf() {

    }

    public StatusEnums getStatus() {
        return status;
    }

    public void setStatus(StatusEnums status) {
        this.status = status;
    }

    public Bedrijf(String bedrijfsnaam, Adres adres, String telefoonnummer, Medewerker contactpersoon, String rekeningnummer, String btwNummer, String vatNummer, String kvkNummer, StatusEnums status) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.adres = adres;
        this.telefoonnummer = telefoonnummer;
        this.contactpersoon = contactpersoon;
        this.rekeningnummer = rekeningnummer;
        this.btwNummer = btwNummer;
        this.vatNummer = vatNummer;
        this.kvkNummer = kvkNummer;
        this.status = status;
    }

    public void setAdres(String straatnaam, int huisnummer, String huisnummertoevoeging, String postcode, String plaatsnaam, LandEnums land) {
//		this.adres = adres;
        adres.setStraatnaam(straatnaam);
        adres.setHuisnummer(huisnummer);
        adres.setHuisnummertoevoeging(huisnummertoevoeging);
        adres.setPostcode(postcode);
        adres.setPlaatsnaam(plaatsnaam);
        adres.setLand(land);
    }

    // getters en setters


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

    public String getVatNummer() {
        return vatNummer;
    }

    public void setVatNummer(String vatNummer) {
        this.vatNummer = vatNummer;
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

    public Medewerker getContactpersoon() {
        return contactpersoon;
    }

    public void setContactpersoon(Medewerker contactpersoon) {
        this.contactpersoon = contactpersoon;
    }

    public Set<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(Set<Tank> tanks) {
        this.tanks = tanks;
    }

    public String toString() {
        return bedrijfsnaam + "(" + adres + ")";
    }


    public boolean loginverificatie(String username, String password) {
        // TODO Auto-generated method stub
        return username.equals("Tester") && password.equals("!Test00");
    }
}

