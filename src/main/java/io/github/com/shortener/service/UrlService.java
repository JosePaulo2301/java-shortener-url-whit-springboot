package io.github.com.shortener.service;

import org.springframework.stereotype.Service;

import io.github.com.shortener.model.Url;
import io.github.com.shortener.model.UrlDTO;

@Service
public interface UrlService {
	public Url generatedShortLink(UrlDTO urlDto);
	public Url persistShortLink(Url url);
	public Url getEncodedURl(String url);
	
	public void deletShortLink(Url url);
}
