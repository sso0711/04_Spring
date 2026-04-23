package com.ssafy.ws.step2.service;

import java.util.List;

import com.ssafy.ws.step2.dao.MovieDao;
import com.ssafy.ws.step2.dto.Movie;

public class MainService {

    private static MainService instance = new MainService();

    private MovieDao dao = MovieDao.getInstance();

    private MainService() {}

    public static MainService getInstance() {
        return instance;
    }

    // 영화 등록
    public void regist(Movie movie) {
        // 값 검증, 로깅 등 추가 가능
        dao.insert(movie);
    }

    // 전체 조회
    public List<Movie> getList() {
        return dao.selectAll();
    }
    
    // 상세 조회
    public Movie get(int id) {
        return dao.select(id);
    }

    // 삭제
    public void delete(int id) {
        dao.delete(id);
    }
}