package io.github.com.shortener.model;


public class UrlDTO {

	private String url;
	private String expirationDate;
	
	
	
	public UrlDTO(String url, String expirationDate) {
		super();
		this.url = url;
		this.expirationDate = expirationDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return "UrlDTO [url=" + url + ", expirationDate=" + expirationDate + "]";
	}

	
}
