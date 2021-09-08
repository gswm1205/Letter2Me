package com.example.lettertome.repository;

import com.example.lettertome.model.entity.Board;
//import com.example.lettertome.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByUser_Id(String user_id);
    List<Board> findByUser_IdAndSeeAuthority(String user_id, Boolean see_authority);

}
