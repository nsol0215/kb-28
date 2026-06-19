package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    // 목록 조회 테스트
    @Test
    public void getList() {
        List<BoardDTO> list = boardService.getList();

        assertFalse(list.isEmpty());           // 목록이 비어있지 않은지 확인

        for(BoardDTO board : list) {
            log.info("게시글: {}", board);
            assertNotNull(board.getNo());      // 게시글 번호 존재 확인
            assertNotNull(board.getTitle());   // 제목 존재 확인
        }
    }

    // 단일 조회 테스트
    @Test
    void get() {
        Long testNo = 1L;
        BoardDTO board = boardService.get(testNo);

        assertNotNull(board);                          // 조회 결과 존재 확인
        assertEquals(testNo, board.getNo());           // 번호 일치 확인

        log.info("조회된 게시글: {}", board);
    }

    // 게시글 등록 테스트
    @Test
    public void create() {
        BoardDTO board = BoardDTO.builder()
                .title("서비스 테스트 제목")
                .content("서비스 테스트 내용")
                .writer("testuser")
                .build();

        boardService.create(board);

        assertNotNull(board.getNo());              // PK가 설정되었는지 확인
        log.info("생성된 게시물 번호: {}", board.getNo());
    }
    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}