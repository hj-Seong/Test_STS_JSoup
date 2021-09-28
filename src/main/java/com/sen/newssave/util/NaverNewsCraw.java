package com.sen.newssave.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sen.newssave.domain.News;

@Component
public class NaverNewsCraw {

	int aidNum = 1;
	public List<News> collect5() {
		RestTemplate rt = new RestTemplate();
		List<News> newsList = new ArrayList<>(); 
		
		for (int i = 1; i < 6; i++) {
			String aid = String.format("%010d", aidNum);
			
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid="+aid;
			String html = rt.getForObject(url, String.class);
			try {
			Document doc = Jsoup.parse(html);

			Element companyElement = doc.selectFirst(".press_logo img");
			Element titleElement = doc.selectFirst("#articleTitle");
			Element creatAtElement = doc.selectFirst(".t11");
			
			
			
			String company = companyElement.attr("title");
			String title = titleElement.text();
			String creatAt = creatAtElement.text();
			
			News news = News.builder()
					.company(company)
					.title(title)
					.createdAt(creatAt)
					.build();
			
				//null값이 들어가면 문제 try-catch

				newsList.add(news);
			} catch( NullPointerException e) {
				System.out.println("Null");
			}
			
			aidNum++;
		}
		return newsList;
		
	}
}
