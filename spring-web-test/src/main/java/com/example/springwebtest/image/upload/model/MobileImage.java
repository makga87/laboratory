package com.example.springwebtest.image.upload.model;


import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MobileImage {
	private MultipartFile image;
	private String imageUrl;
}
