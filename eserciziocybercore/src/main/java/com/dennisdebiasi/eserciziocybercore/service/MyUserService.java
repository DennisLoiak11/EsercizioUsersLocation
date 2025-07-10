package com.dennisdebiasi.eserciziocybercore.service;

import com.dennisdebiasi.eserciziocybercore.model.*;
import com.dennisdebiasi.eserciziocybercore.repository.HomeRepository;
import com.dennisdebiasi.eserciziocybercore.repository.LocationRepository;
import com.dennisdebiasi.eserciziocybercore.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService {
    //dependency injection per utilizzare i metodi delle interfacce repository
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private HomeRepository homeRepository;

    //con l'annotazione Transactional se nel metodo si verifica un'eccezione permette di "riavvolgere il nastro"
    //per annullare tutte le operazioni fatte prima di quel momento e non creare discrepanze sul DB
    @Transactional
    public String createOrUpdateUser(UserRequestModel userRequestModel){
        String result;
        ArrayList<String> idLocations = new ArrayList<>();
        //creo una variabile boolean come riferimento per poi restituire il messaggio corretto in base al caso di aggiornamento o nuovo inserimento
        boolean isUpdate = myUserRepository.existsById(userRequestModel.getUsername());

        try{
            if(isUpdate){//se l'utente esiste già procedo con la cancellazione dei dati per poi salvarli nuovamente in modo atomico
                MyUserModel userEsistente = myUserRepository.findById(userRequestModel.getUsername()).orElseThrow();
                //raccolgo gli id delle location relative all'user già esistente
                List<String> idLocationsEsistenti = userEsistente.getIdLocations();
                //recupero tutte le location dai loro id
                List<LocationModel> locationEsistenti = locationRepository.findAllById(idLocationsEsistenti);
                //recupero gli id delle home relative alle location ciclando la lista locationEsistenti
                List<String> idHomeEsistenti = locationEsistenti.stream().map(location -> location.getHomeId()).toList();

                //elimino i dati delle entità esistenti per salvarle nuovamente in modo atomico
                homeRepository.deleteAllById(idHomeEsistenti);
                locationRepository.deleteAllById(idLocationsEsistenti);
            }
            //creo/ricreo i dati per salvarli atomicamente
            for(UserRequestModel.LocationRequestModel locationRequestModel : userRequestModel.getLocations()){
                //creo e salvo la nuova Home o la modifica della vecchia home e faccio la stessa cosa per location
                HomeModel home = new HomeModel(locationRequestModel.getHome().getName());
                homeRepository.save(home);
                LocationModel location = new LocationModel(locationRequestModel.getCity(), locationRequestModel.getAddress(), home.getId());
                locationRepository.save(location);
                idLocations.add(location.getId());
            }
            //creo e salvo il nuovo user
            MyUserModel nuovoUtente = new MyUserModel(userRequestModel.getUsername(), userRequestModel.getFirstName(), userRequestModel.getLastName(), idLocations);
            myUserRepository.save(nuovoUtente);

            if(isUpdate == true){
                result = "Risorsa modificata con successo"; //se si tratta di un aggiornamento
            }else{
                result = "Risorsa creata con successo"; //se si tratta di una nuova creazione
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il salvataggio, rollback effettuato", e);
        }
        return result;
    }

    @Cacheable(value = "locationsCache")
    public List<LocationResponseModel> getLocationsByUsername(String username){
        System.out.println(" --- Sono all'interno del metodo getLocationsByUsername() ---");
        List<LocationResponseModel> result = new ArrayList<>();
        MyUserModel user = myUserRepository.findById(username).orElseThrow();
        //recupero tutte le location relative all'username specificato come parametro della richiesta
        List<LocationModel> listaLocations = locationRepository.findAllById(user.getIdLocations());
        for(LocationModel location : listaLocations){
            //recupero il nome della home di ogni location
            HomeModel home = homeRepository.findById(location.getHomeId()).orElseThrow();
            String homeName = home.getName();
            //creo un oggetto di tipo locationResponse
            LocationResponseModel locationResponse = new LocationResponseModel(location.getCity(), location.getAddress(), homeName);
            //aggiungo l'oggetto locationResponse alla lista di oggeti locationResponse che ritornerò come risultato del metodo
            result.add(locationResponse);
        }
        return result;
    }
}
