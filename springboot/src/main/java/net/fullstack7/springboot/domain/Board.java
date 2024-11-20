package net.fullstack7.springboot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tbl_board")
public class Board extends BoardBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 제약
    @Column(unique = true, nullable = false)
    private int idx;
    @Column(nullable = false, length = 20)
    private String memberId;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 2000)
    private String content;
    @Column(nullable = true, length = 10)
    private String displayDate;

    public void modify(String memberId, String title, String Content, String displayDate) {
        this.memberId = memberId;
        this.title = title;
        this.content = Content;
        this.displayDate = displayDate;
        super.setModifyDate(LocalDateTime.now());
    }
}




