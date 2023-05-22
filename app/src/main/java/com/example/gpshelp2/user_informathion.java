package com.example.gpshelp2;

public class user_informathion {
    public String id,name,sec_name, otchestvo,datarojden,adress,pasport,snils,police;

    public user_informathion( ) {
    }

    public user_informathion(String id, String name, String sec_name,String otchestvo, String datarojden,String adress,String pasport,String snils,String police) {
        this.id = id;
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
