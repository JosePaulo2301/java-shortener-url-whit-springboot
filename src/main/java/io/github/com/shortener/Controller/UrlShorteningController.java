package io.github.com.shortener.Controller;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.com.shortener.model.Url;
import io.github.com.shortener.model.UrlDto;
import io.github.com.shortener.model.UrlErrorResponseDto;
import io.github.com.shortener.model.UrlResponseDto;
import io.github.com.shortener.service.UrlService;

@RestController
public class UrlShorteningController {

	@Autowired
	private UrlService urlService;
	
	@PostMapping("/generate")
	public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto) {
		Url urlToRet = urlService.generatedShortLink(urlDto);
		
		if(urlToRet != null) {
			UrlResponseDto urlResponseDto = new UrlResponseDto();
			urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
			urlResponseDto.setExpriationDate(urlToRet.getExpirationDate());
			urlResponseDto.setShortLink(urlToRet.getShortLink());
			
			return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
		}
		
		UrlErrorResponseDto errorResponseDto = new UrlErrorResponseDto();
		errorResponseDto.setStatus("404");
		errorResponseDto.setError("there was an error processing your request. please try again.");
		return new ResponseEntity<UrlErrorResponseDto>(errorResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/{shortLink}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shorLink) {
		
		if (StringUtils.isEmpty(shorLink)) {
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("Invalid Url");
			urlErrorResponseDto.setStatus("400");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK); 
		}
		
		Url urlToRet = urlService.getEncodedURl(shorLink);
		
		if (urlToRet != null) {
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("Url does exit or it might have expired!");
			urlErrorResponseDto.setStatus("400");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK); 
		}
		
		if(urlToRet.getExpirationDate().isBefore(LocalDateTime.now())) {
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("Url expired. Please try generating a fresh one.");
			urlErrorResponseDto.setStatus("200");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK); 
		}
		
		response
	}
	
}
