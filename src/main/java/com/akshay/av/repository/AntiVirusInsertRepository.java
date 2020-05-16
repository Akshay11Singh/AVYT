package com.akshay.av.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akshay.av.model.Md5_encrypted;

@Repository
public interface AntiVirusInsertRepository extends JpaRepository<Md5_encrypted, Long>{

	@Transactional
	@Modifying
	@Query(value="Insert into md5_encrypted(md5string,ransom_ware) values(:md5string,:ransom_ware)",nativeQuery=true)
	void saveAndFlush(@Param("md5string")String md5string,@Param("ransom_ware") String  ransom_ware);
	
/*	@Query(value = "SELECT mySeq.nextval FROM dual", nativeQuery = 
	        true)
	 Long getNextSeriesId();
*/}
