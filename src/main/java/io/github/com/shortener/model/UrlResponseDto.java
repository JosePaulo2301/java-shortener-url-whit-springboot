package io.github.com.shortener.model;

import java.time.LocalDateTime;

public class UrlResponseDto {
	private String originalUrl;
	private String shortLink;
	private LocalDateTime expriationDate;
	
	
	public UrlResponseDto() {

	}
	public UrlResponseDto(String originalUrl, String shortLink, LocalDateTime expriationDate) {
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
		return "UrlResponseDto [originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", expriationDate="
				+ expriationDate + "]";
	}

	
	
	
}
