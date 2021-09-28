package com.sen.newssave.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "naver_news")
public class News {
	private String _id; //안에있는 Bson 값 처리하기 힘듦
	private String company;
	private String title;
	private String createdAt;

}
