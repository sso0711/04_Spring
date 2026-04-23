package com.ssafy.ws.step2.dao;

import com.ssafy.ws.step2.dto.Movie;
import java.util.ArrayList;
import java.util.List;

// DB에 접근하여 CRUD를 시행
// 효율적인 커넥션관리, 보안성으로 인해 필요함.
public class MovieDao {
    // 싱글톤
    private static MovieDao instance = new MovieDao();

    private List<Movie> movieList = new ArrayList<>();

    private int sequence = 1;

    private MovieDao() {}

    public static MovieDao getInstance() {
        return instance;
    }

    // 등록
    public void insert(Movie movie) {
        movie.setId(sequence++);
        movieList.add(movie);
    }

    // 전체 조회
    public List<Movie> selectAll() {
        return movieList;
    }
    
    // 아이디로 조회
    public Movie select(int id) {
        for (Movie m : movieList) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    // 삭제
    public void delete(int id) {
        movieList.removeIf(m -> m.getId() == id);
    }
}