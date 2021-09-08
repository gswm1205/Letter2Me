package com.example.lettertome;

import com.example.lettertome.model.entity.Board;
import com.example.lettertome.model.entity.User;
import com.example.lettertome.repository.BoardRepository;
import com.example.lettertome.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LettertomeApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void UserCreateTest() {
        User user = new User();

        user.setId("test11");
        user.setPassword("123");
        user.setEmail("asdf@daum.net");

        userRepository.save(user);

        Board board = new Board();
        board.setUser(user);
//        board.setSee_authority(true);
        board.setContent("test12312323");

        boardRepository.save(board);

        List<Board> boards = boardRepository.findAll();
        for(Board e : boards){
            System.out.println(e.toString() + " " + e.getUser().getId().toString());
        }

    }

}
