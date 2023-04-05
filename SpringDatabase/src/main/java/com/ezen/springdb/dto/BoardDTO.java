package com.ezen.springdb.dto;

import java.util.Date;



import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {	
	private Integer board_id;
	private String write_id;
	private String write_pw;
	private String write_title;
	private String write_content;
	private Date write_date;
	private Integer write_view;
	private Integer write_recommend;
	private Integer write_not_recommend;
}

