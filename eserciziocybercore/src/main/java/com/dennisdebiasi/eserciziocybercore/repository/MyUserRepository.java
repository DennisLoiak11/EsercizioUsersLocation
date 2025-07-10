package com.dennisdebiasi.eserciziocybercore.repository;

import com.dennisdebiasi.eserciziocybercore.model.MyUserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends MongoRepository<MyUserModel, String> {

}
