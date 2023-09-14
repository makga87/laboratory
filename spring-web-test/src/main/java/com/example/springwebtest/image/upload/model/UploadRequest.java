package com.example.springwebtest.image.upload.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UploadRequest {

	private String etc;
	private PcImage pcImage;
	private MobileImage mobileImage;

}
