package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ezen.springdb.dto.BoardDTO;

public interface BoardMapper {
	// ★ 반드시 컬럼 이름이 일치해야 바인딩이 된다!!
	@Select("SELECT * FROM board WHERE board_id=#{board_id}")
	BoardDTO get(Integer board_id);
	
	@Select("SELECT * FROM board ORDER BY write_id DESC")
	List<BoardDTO> getAll();
	
	// 컬럼이름만 일치시키면 -> 컨트롤러에서 자동으로 입력해줌
	@Insert("INSERT INTO board VALUES(board_id_seq.nextval,"
			+ "#{write_id},#{write_pw},#{write_title},#{write_content},sysdate,0,0,0)")
	Integer add(BoardDTO board);
	
	@Update("UPDATE board SET write_title=#{write_title}, "
			+ "write_content=#{write_content} WHERE board_id=#{board_id}")
	Integer update(BoardDTO board);
	
	@Delete("DELETE FROM board WHERE board_id=#{board_id}")
	Integer delete(Integer board_id);
		
	@Update("UPDATE board SET write_title=#{write_title} WHERE board_id=#{board_id}")
	Integer modify(BoardDTO board);
		
	@Delete("DELETE FROM board WHERE board_id=#{board_id}")
	Integer remove(BoardDTO board);
	
}
