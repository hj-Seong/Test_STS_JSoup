package com.sen.newssave.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sen.newssave.domain.News;
import com.sen.newssave.domain.NewsRepository;
import com.sen.newssave.util.NaverNewsCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsBatch {

	private final NewsRepository newsRepository;
	private final NaverNewsCraw naverNewsCraw;
	
	@Scheduled(fixedDelay = 1000*60*1)
	public void newsCrawAndSave() {
		List<News> newsList = naverNewsCraw.collect5();
		newsRepository.saveAll(newsList);
	}
}
