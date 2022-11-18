package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity  //User 클래스가 Mysql에 테이블이 생성된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false,length = 30)
	private String username;//아이디
	
	@Column(nullable = false,length = 100)
	private String password;
	
	@Column(nullable = false,length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // enum을 사용해서 만드는게 좋음 -> 선택지를 제한할 수 있어서
	
	@CreationTimestamp // 시간 자동입력
	private Timestamp createDate;
}
