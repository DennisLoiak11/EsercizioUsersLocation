package com.dennisdebiasi.eserciziocybercore.controller;

import com.dennisdebiasi.eserciziocybercore.service.SvuotaCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache")
public class SvuotaCacheController {
    @Autowired
    private SvuotaCacheService svuotaCacheService;

    @DeleteMapping("/svuotaCache")
    public String clearCache() {
        return  svuotaCacheService.svuotaLocationsCache();
    }
}