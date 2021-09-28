package com.sen.newssave.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sen.newssave.domain.News;
import com.sen.newssave.domain.NewsRepository;
import com.sen.newssave.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class NewsController {
	private final NewsRepository newsRepository;
	
	@GetMapping("/news")
	public CMRespDto<List<News>> findAll(){
		return new CMRespDto<>(1, "성공", newsRepository.findAll());
	}
}
