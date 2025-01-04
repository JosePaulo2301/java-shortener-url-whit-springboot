package io.github.com.shortener.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;

import com.google.common.hash.Hashing;

import io.github.com.shortener.model.Url;
import io.github.com.shortener.model.UrlDTO;

public class UrlServiceImpl implements UrlService{

	@Override
	public Url generatedShortLink(UrlDTO urlDto) {
		if(StringUtils.isNotEmpty(urlDto.getUrl())) {
			String encodeUrl = encodeUrl(urlDto.getUrl());
			Url urlToPersist = new Url();
			
			urlToPersist.setCreationDate(LocalDateTime.now());
			urlToPersist.setExpirationDate(LocalDateTime.now());
		
		}
		return null;
	}

	private String encodeUrl(String url) {
		String encoderUrl = "";
		LocalDateTime time = LocalDateTime.now();
		encoderUrl = 
				Hashing.murmur3_32()
				.hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
				.toString();
		
		return encoderUrl;
	}

	@Override
	public Url persistShortLink(Url url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Url getEncodedURl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletShortLink(Url url) {
		// TODO Auto-generated method stub
		
	}

}
