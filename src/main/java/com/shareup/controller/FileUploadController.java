package com.shareup.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


//@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.100.239:3000"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class FileUploadController {
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	@PostMapping(value = "/upload")
	public ResponseEntity<?> fileUpload(@RequestParam("files") MultipartFile[] files,@RequestParam("swapfiles") MultipartFile[] swapfiles,@RequestParam("stryfiles") MultipartFile[] stryfiles){
		System.out.println(files);
		try {
			System.out.println("File List:");
			for(MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				file.transferTo(new File (FILE_DIRECTORY,fileName));
			}
			for(MultipartFile file : swapfiles) {
				String fileName = file.getOriginalFilename();
				file.transferTo(new File (FILE_DIRECTORY,fileName));
			}
			for(MultipartFile file : stryfiles) {
				String fileName = file.getOriginalFilename();
				file.transferTo(new File (FILE_DIRECTORY,fileName));
			}
			
		} catch (Exception e) {
			System.out.println(e +  " ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("Successfull");		
	}
}
