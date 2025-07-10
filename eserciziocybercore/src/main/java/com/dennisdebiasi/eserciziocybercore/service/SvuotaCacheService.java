package com.dennisdebiasi.eserciziocybercore.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class SvuotaCacheService {

    //metodo per svuotare la cache senza dover riavviare il progetto che deve essere implementato in un bean a parte
    @CacheEvict(value = "locationsCache", allEntries = true) //con "allEntries = true" rimuovo tutto il contenuto della cache indicata nel value
    public String svuotaLocationsCache() {
        System.out.println(" --- Cache svuotata ---");
        return "Cache del sistema svuotata";
    }
}
