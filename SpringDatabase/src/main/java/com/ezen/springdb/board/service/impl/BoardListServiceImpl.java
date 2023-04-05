package com.ezen.springdb.board.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springdb.board.mapper.ServiceBoardMapper;
import com.ezen.springdb.board.service.BoardListService;
import com.ezen.springdb.dto.BoardDTO;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class BoardListServiceImpl implements BoardListService {

	@Autowired
	ServiceBoardMapper board_mapper;
		
	@Override
	public BoardDTO clickTitle(Integer board_id, 
			HttpServletRequest request, HttpServletResponse response) {
		// 최근에 조회한 적이 있는지 검사한 후 (쿠키 검사, 추가 또는 갱신)			
		Cookie[] cookies = request.getCookies();
		
		boolean viewed = false;
		
		JSONObject obj = null;		
		
		// cookies 자체도 null이 아니어야 함
		if (cookies != null) {			
			for (Cookie cookie : cookies) {
				
				// cookie가 null이 아닐 때만 실행되도록 함
				if (cookie != null && cookie.getName().equals("viewed")) {
					
					// 쿠키에서 값을 꺼내면 "{"ids" : [1,2,3,4]}" 이렇게 생긴 문자열이 나온다
					String jsonString = cookie.getValue();				
					
					// 문자열을 JSONObject 타입으로 파싱하기 위한 객체
					JSONParser parser = new JSONParser();
					
					try {
						// 파싱을 실행
						obj = (JSONObject) parser.parse(jsonString);
						
						// 값으로 꺼낸 것이 자바스크립트 배열이기 때문에 JSONArray로 받음
						JSONArray ids = (JSONArray) obj.get("ids");
						
						viewed = ids.contains(cookies);
						
						// 하나씩 반복을 돌릴 수도 있다
//					for (int i = 0; i < ids.size(); ++i) {
//						ids.get(i);
//					}					
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
		if (!viewed) {
			board_mapper.plusView(board_id);
			
			// 조회한 적도 없고 쿠키도 없는 경우
			if (obj == null) {
				// const json = { ids : [55, 66, 77] }
				// const json = { ids : [board_id] }
				JSONObject json = new JSONObject(); 			
				JSONArray arr = new JSONArray();				
				arr.add(board_id);			
				json.put("ids", arr);
				
				log.info(json.toJSONString());
				
				Cookie viewCookie = new Cookie("viewed", json.toJSONString());				
				viewCookie.setPath("/service/board");
				
				response.addCookie(viewCookie);
			} else {
				// 이 글을 오늘 처음 보지만 쿠키는 있는 경우
				JSONArray ids = (JSONArray) obj.get("ids");
				ids.add(board_id);
				obj.put("ids", ids);
				
				Cookie viewCookie = new Cookie("viewed", obj.toJSONString());				
				viewCookie.setPath("/service/board");
				
				response.addCookie(new Cookie("viewed", obj.toJSONString()));
			}
		}
			
		// 글의 상세 내용을 가져온다 (영속 계층)
		return board_mapper.get(board_id);
	}
	

	
}
