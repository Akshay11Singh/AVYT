package com.akshay.av.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.akshay.av.controller.FileBeanDTO;
import com.akshay.av.model.Md5_encrypted;
import com.akshay.av.repository.AntiVirusInsertRepository;
import com.akshay.av.repository.AntiVirusRepository;

@Service
public class AntiVirusService {

	@Autowired(required = true)
	AntiVirusRepository antiVirusRepository;

	@Autowired
	AntiVirusInsertRepository virusInsertRepository;
		/*
	 * @Autowired(required = true) AntiVirusJdbcRepository antiVirusJdbcRepository;
	 */
	Md5_encrypted mdEncrypted ;

	@Autowired
	EntityManager entityManager;
	
	public Optional<Md5_encrypted> getMD5(String md5) {
		return antiVirusRepository.findByMd5String(md5);

	}

	@Transactional
	public int insertMd5Batch(FileBeanDTO fileBeanDTO) throws Exception {
		MultipartFile file = fileBeanDTO.getMultipartFile();
		String name = file.getOriginalFilename();
		File fileUpload = new File(name);
		int readLine = 0;
		int c = 0;
		String line;
		try {
		String path = fileUpload.getAbsolutePath();
		fileUpload = new File(path);
				if (fileUpload.createNewFile()) {
			
			BufferedOutputStream bisTemp = new BufferedOutputStream(new FileOutputStream(fileUpload));
			InputStreamReader bis = new InputStreamReader(file.getInputStream());
			while ((c = bis.read()) != -1) {
				char write = (char) c;
				bisTemp.write(write);
				c++;
			}
			bisTemp.flush();
			bisTemp.close();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			while ((line = bufferedReader.readLine()) != null) {
				readLine++;
				if (line != "" && !"".equals(line)) {
					mdEncrypted = new Md5_encrypted(line,"WinRasomware Found " + readLine);
					virusInsertRepository.saveAndFlush( mdEncrypted.getMd5(),mdEncrypted.getRansomWare());
					//entityManager.persist(mdEncrypted);
					
				}
					
				if(readLine%1000==0) {
					System.out.println("No. of lines :::" + readLine+ " Current Date & Time:  "+java.time.LocalDateTime.now() );
					entityManager.flush();
					entityManager.clear();
				}
			}

			bufferedReader.close();
			//entityManager.close();
		} else {
			return -1;
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			entityManager.close();
			throw new Exception(e.getMessage());
		}
		finally {
			entityManager.flush();
			entityManager.close();
		}
		return readLine;
	}

}
