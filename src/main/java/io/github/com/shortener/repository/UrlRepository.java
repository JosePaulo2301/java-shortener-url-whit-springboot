package io.github.com.shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.com.shortener.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	public Url findByShortLink(String shortLink);

}
