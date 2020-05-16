package com.akshay.av.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshay.av.model.Md5_encrypted;

@Repository
public interface AntiVirusRepository extends CrudRepository<Md5_encrypted, String> {
	Optional<Md5_encrypted> findByMd5String(String md5);	
	
}
