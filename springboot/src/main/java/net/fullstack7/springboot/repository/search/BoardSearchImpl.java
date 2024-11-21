package net.fullstack7.springboot.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import net.fullstack7.springboot.domain.Board;
import net.fullstack7.springboot.domain.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Objects;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {
    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard boardQ = QBoard.board;
        JPQLQuery<Board> query = from(boardQ); //select ~~ from tbl_board
        //query.where(boardQ.title.like("1")); //WHERE title like '%1%'

        BooleanBuilder bb = new BooleanBuilder();
        bb.or(boardQ.title.like("1"));
        bb.or(boardQ.content.like("내용"));
        query.where(bb);
        
        //페이징 추가
        Objects.requireNonNull(this.getQuerydsl()).applyPagination(pageable, query);
        List<Board> boards = query.fetch();
        int total = (int)query.fetchCount();
        return null;
    }

    @Override
    public Page<Board> search2(Pageable pageable, String[] searchCategory, String searchWord) {
        QBoard boardQ = QBoard.board;
        JPQLQuery<Board> query = from(boardQ); //select ~~ from tbl_board
        //query.where(boardQ.title.like("1")); //WHERE title like '%1%'

        if((searchCategory != null && searchCategory.length > 0) && searchWord != null){
            BooleanBuilder bb = new BooleanBuilder();
            for(String category : searchCategory) {
                switch(category) {
                    case "t":
                        bb.or(boardQ.title.like("%"+searchWord+"%"));
//                        bb.or(boardQ.title.containsIgnoreCase("%"+searchWord+"%"));
//                        bb.or(boardQ.title.contains("%"+searchWord+"%"));  // 대소문자구분
                        break;
                    case "c":
                        bb.or(boardQ.content.like("%"+searchWord+"%"));
                        break;
                    case "m":
                        bb.or(boardQ.memberId.like("%"+searchWord+"%"));
                        break;
                }
                // 체크박스면 여기
            }
           // 래디오 버튼이면 여기
            query.where(bb);
        }
        query.where(boardQ.idx.gt(0)); // 0보다 큰값만 들어오도록

        //페이징 추가
        Objects.requireNonNull(this.getQuerydsl()).applyPagination(pageable, query);
        List<Board> boards = query.fetch();
        int total = (int)query.fetchCount();
        return new PageImpl<Board>(boards, pageable, total);
    }
}