package com.dennisdebiasi.eserciziocybercore.repository;

import com.dennisdebiasi.eserciziocybercore.model.LocationModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<LocationModel, String> {
}
