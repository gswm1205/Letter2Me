package com.example.lettertome.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Board")
@Data
@Table(name = "Board")
public class Board {
    @Id
    @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardIdx;

    @Column(name = "content")
    private String content;

    @Column(name = "see_authority")
    private Boolean seeAuthority;

    @Column(name = "open_date")
    private LocalDateTime open_date;

    @Column(name = "delete_yn")
    private String deleteYn = "N";

    @Column(name="created_date")
    @CreationTimestamp
    private LocalDateTime created_date;

    @Column(name="d_day")
    private Integer d_day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_idx")
    private User user;

    public void deleteBoard() {
        this.deleteYn = "Y";
    }


}
