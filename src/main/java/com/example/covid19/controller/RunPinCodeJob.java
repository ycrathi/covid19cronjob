package com.example.covid19.controller;

import com.example.covid19.models.Center;
import com.example.covid19.models.CovidCenters;
import com.example.covid19.models.Session;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class RunPinCodeJob {

    int counter = 1;

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String checkPinCode(String pincode, String date) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0." + (counter++) + ".93 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        final ResponseEntity<CovidCenters> response = restTemplate().exchange(
                "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin" +
                        "?pincode=" + pincode + "&date=" + date,
                HttpMethod.GET,
                entity,
                CovidCenters.class);
        String availablePincode = "";
        if (response.getStatusCode() == HttpStatus.OK) {
            if (response.getBody().getCenters() != null) {
                for (Center center : response.getBody().getCenters()) {
                    for (Session session : center.getSessions()) {
                        if (session.getVaccine().equalsIgnoreCase("covaxin")) {
                            if (session.getAvailableCapacity() > 0)
                                availablePincode = pincode;
                        }
                    }
                }
            }
        }
        return availablePincode;
    }

    public List<String> findVaccineInPuneLocation() {
        List<String> list = new ArrayList<>();
        addPunePinCode().forEach(s -> {
            System.out.println("Finding for " + s);
            String pinCode = checkPinCode(s, "11-05-2021");
            if (!StringUtils.isEmpty(pinCode)) {
                list.add(pinCode);
                System.out.println("Available here " + pinCode);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return list;
    }

    private List<String> addPunePinCode() {
        List<String> list = new ArrayList<>();
        list.add("411230");
        list.add("410301");
        list.add("410302");
        list.add("410401");
        list.add("410402");
        list.add("410403");
        list.add("410405");
        list.add("410406");
        list.add("410501");
        list.add("410502");
        list.add("410503");
        list.add("410504");
        list.add("410505");
        list.add("410506");
        list.add("410507");
        list.add("410508");
        list.add("410509");
        list.add("410510");
        list.add("410511");
        list.add("410512");
        list.add("410513");
        list.add("410515");
        list.add("410516");
        list.add("411001");
        list.add("411002");
        list.add("411003");
        list.add("411004");
        list.add("411005");
        list.add("411006");
        list.add("411007");
        list.add("411008");
        list.add("411009");
        list.add("411011");
        list.add("411012");
        list.add("411013");
        list.add("411014");
        list.add("411015");
        list.add("411016");
        list.add("411017");
        list.add("411018");
        list.add("411019");
        list.add("411020");
        list.add("411021");
        list.add("411022");
        list.add("411023");
        list.add("411024");
        list.add("411025");
        list.add("411026");
        list.add("411027");
        list.add("411028");
        list.add("411030");
        list.add("411031");
        list.add("411032");
        list.add("411033");
        list.add("411034");
        list.add("411035");
        list.add("411036");
        list.add("411037");
        list.add("411038");
        list.add("411039");
        list.add("411040");
        list.add("411041");
        list.add("411042");
        list.add("411043");
        list.add("411044");
        list.add("411045");
        list.add("411046");
        list.add("411047");
        list.add("411048");
        list.add("411051");
        list.add("411052");
        list.add("411057");
        list.add("411058");
        list.add("411060");
        list.add("411061");
        list.add("412101");
        list.add("412102");
        list.add("412103");
        list.add("412104");
        list.add("412105");
        list.add("412106");
        list.add("412107");
        list.add("412108");
        list.add("412109");
        list.add("412110");
        list.add("412112");
        list.add("412114");
        list.add("412115");
        list.add("412201");
        list.add("412202");
        list.add("412203");
        list.add("412204");
        list.add("412205");
        list.add("412206");
        list.add("412207");
        list.add("412208");
        list.add("412209");
        list.add("412210");
        list.add("412211");
        list.add("412212");
        list.add("412213");
        list.add("412214");
        list.add("412215");
        list.add("412216");
        list.add("412218");
        list.add("412219");
        list.add("412220");
        list.add("412301");
        list.add("412303");
        list.add("412304");
        list.add("412305");
        list.add("412306");
        list.add("412307");
        list.add("412308");
        list.add("412311");
        list.add("412312");
        list.add("412401");
        list.add("412402");
        list.add("412403");
        list.add("412404");
        list.add("412405");
        list.add("412406");
        list.add("412408");
        list.add("412409");
        list.add("412410");
        list.add("412411");
        list.add("412412");
        list.add("413102");
        list.add("413103");
        list.add("413104");
        list.add("413105");
        list.add("413106");
        list.add("413110");
        list.add("413114");
        list.add("413115");
        list.add("413116");
        list.add("413120");
        list.add("413130");
        list.add("413132");
        list.add("413133");
        list.add("413801");
        list.add("413802");
        return list;
    }
}
