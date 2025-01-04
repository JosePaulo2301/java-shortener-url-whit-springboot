package io.github.com.shortener.model;

import java.time.LocalDateTime;

public class UrlResponseDTO {
	private String originalUrl;
	private String shortLink;
	private LocalDateTime expriationDate;
	
	
	public UrlResponseDTO(String originalUrl, String shortLink, LocalDateTime expriationDate) {
		super();
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.expriationDate = expriationDate;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShortLink() {
		return shortLink;
	}
	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
	public LocalDateTime getExpriationDate() {
		return expriationDate;
	}
	public void setExpriationDate(LocalDateTime expriationDate) {
		this.expriationDate = expriationDate;
	}
	@Override
	public String toString() {
		return "UrlResponseDTO [originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", expriationDate="
				+ expriationDate + "]";
	}

	
	
	
}
