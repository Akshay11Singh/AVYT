package com.akshay.av.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.av.service.AntiVirusService;

@Controller
public class FileUploadController {

	@Autowired
	FileBeanDTO fileBeanDTO;

	@Autowired
	AntiVirusService antiVirusService;

	@GetMapping(value = "/fileUpload", produces = { "text/plain" })
	public String home(@ModelAttribute("fileBeanDTO") FileBeanDTO fileBeanDTO) {
		return "fileUpload";
	}

	@GetMapping(value = "/appName")
	public ResponseEntity appName() {
		return new ResponseEntity(" test", HttpStatus.OK);
	}

	@PostMapping(value = "/fileUploadProcess", produces = { "text/plain" })
	public String fileUploadProcess(@ModelAttribute("fileBeanDTO") FileBeanDTO fileBeanDTO, ModelMap model)
			throws Exception {

		if (!fileBeanDTO.equals(null)) {
			int recordsInserted = antiVirusService.insertMd5Batch(fileBeanDTO);

			if (recordsInserted >= 0) {
				model.addAttribute("result", recordsInserted); 
			} else {
				model.addAttribute("result", recordsInserted);
			}

		} else
			throw new Exception("file not found");
		return "result";
	}

}
