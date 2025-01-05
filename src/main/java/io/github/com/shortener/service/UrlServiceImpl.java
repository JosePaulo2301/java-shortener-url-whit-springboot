package io.github.com.shortener.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

import io.github.com.shortener.model.Url;
import io.github.com.shortener.model.UrlDto;
import io.github.com.shortener.repository.UrlRepository;

@Component
public class UrlServiceImpl implements UrlService{

	@Autowired
	private UrlRepository urlRepository;
			
	@Override
	public Url generatedShortLink(UrlDto UrlDto) {
		if(StringUtils.isNotEmpty(UrlDto.getUrl())) {
			String encodeUrl = encodeUrl(UrlDto.getUrl());
			Url urlToPersist = new Url();
			
			urlToPersist.setCreationDate(LocalDateTime.now());
			urlToPersist.setShortLink(encodeUrl);
			urlToPersist.setOriginalUrl(UrlDto.getUrl());
			urlToPersist.setExpirationDate(getExpirationDate(UrlDto.getExpirationDate(), urlToPersist.getCreationDate()));
			Url urlToRet = persistShortLink(urlToPersist);
			
			if(urlToRet != null) 
				return urlToRet;
				
			return null;
		}
		return null;
	}

	private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
		
		if (StringUtils.isBlank(expirationDate) ) {
			return creationDate.plusSeconds(60);
		}
		LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
		return expirationDateToRet;
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
		Url urlToRet = urlRepository.save(url);
	
		return urlToRet;
	}

	@Override
	public Url getEncodedURl(String url) {
		Url urlToRet = urlRepository.findByShortLink(url);
		return urlToRet;
	}

	@Override
	public void deletShortLink(Url url) {
		urlRepository.delete(url);
	}

}
