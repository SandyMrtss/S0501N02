package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.dto;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.domain.FlorEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlorDTO {
    private final static List<String> countriesEU = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));
    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    public FlorDTO() {

    }
    public FlorDTO(FlorEntity flor){
        this.pk_FlorID = flor.getPk_FlorID();
        this.nomFlor = flor.getNomFlor();
        String pais = flor.getPaisFlor().toLowerCase();
        this.paisFlor = StringUtils.capitalize(pais);
        this.tipusFlor = tipusPaisFlor();
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    private String tipusPaisFlor() {
        if(isEU(this.paisFlor)){
            return "EU";
        }
        else {
            return  "Non EU";
        }
    }

    public String getTipusFlor() {
        return tipusFlor;
    }

    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
    }

    private boolean isEU(String country) {
        return countriesEU.contains(country);
    }
}
