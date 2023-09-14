package com.example.springwebtest.image.upload;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import com.example.springwebtest.image.upload.model.UploadRequest;


@Slf4j
@RequestMapping("/image")
@Controller
public class MultiImageUploadController {


	/**
	 * RequestBody는 안되고, ModelAttribute는 됨
	 * 단, 객체에 setter가 추가되어야 함
	 */
	@PostMapping(value = "/multi/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity uploadMultiImage(@ModelAttribute UploadRequest uploadRequest) {

		log.info("#### {}", uploadRequest.getEtc());
		log.info("#### {}", uploadRequest.getPcImage().toString());
		log.info("#### {}", uploadRequest.getMobileImage().toString());

		return ResponseEntity.ok().build();
	}
}
