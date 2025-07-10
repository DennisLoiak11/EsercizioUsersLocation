package com.dennisdebiasi.eserciziocybercore.repository;

import com.dennisdebiasi.eserciziocybercore.model.HomeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends MongoRepository<HomeModel, String> {

}
