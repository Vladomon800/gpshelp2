package com.example.gpshelp2;

public class user_informathion {
    public String id;

    public String name;


    public String email;
    public String sec_name;
    public String otchestvo;
    public String datarojden;
    public String adress;
    public String pasport;
    public String snils;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getDatarojden() {
        return datarojden;
    }

    public void setDatarojden(String datarojden) {
        this.datarojden = datarojden;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public String police;

    public user_informathion( ) {
    }

    public user_informathion(String id,String email, String name, String sec_name,String otchestvo, String datarojden,String adress,String pasport,String snils,String police) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.sec_name = sec_name;
        this.otchestvo = otchestvo;
        this.datarojden = datarojden;
        this.adress = adress;
        this.pasport = pasport;
        this.snils = snils;
        this.police = police;

    }
}
