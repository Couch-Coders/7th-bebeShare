package bebeShare.domain.comment;


import bebeShare.web.dto.commentDto.CommentUpdateRequestsDto;
import bebeShare.web.dto.commentDto.CommentUpdateResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CommentRepository extends JpaRepository<Comment, Long> , CommentRepositoryCustom,QuerydslPredicateExecutor<Comment> {

}
