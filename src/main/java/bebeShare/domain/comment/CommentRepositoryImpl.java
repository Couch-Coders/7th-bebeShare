package bebeShare.domain.comment;

import bebeShare.web.dto.commentDto.*;
import bebeShare.web.dto.productDto.RejectShareRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static bebeShare.domain.comment.QComment.comment;
import static bebeShare.domain.product.QProduct.product;


public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public CommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<CommentInfoResponseDto> findByProductId(CommentsRequest commentsRequest, Pageable pageable) {


        List<CommentInfoResponseDto> result = queryFactory
                .select(new QCommentInfoResponseDto(
                        comment.id,
                        comment.commentContent,
                        comment.deleteYn,
                        comment.commentStatus,
                        comment.user.picture,
                        comment.user.id,
                        comment.product.shareId,
                        comment.createdDate.as("insertDt")
                ))
                .from(comment)
                .where(
                        commentProductIdEq(commentsRequest.getProductId()),
                        comment.deleteYn.eq("N")
                )
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .orderBy(comment.createdDate.asc())
                .fetch();


        JPAQuery<Comment> countQuery = queryFactory.select(comment)
                .from(comment)
                .where(
                        commentProductIdEq(commentsRequest.getProductId())
                );

        return PageableExecutionUtils.getPage(result, pageable, () -> countQuery.fetchCount());

    }

    @Override
    public Long updateByCommentId(CommentUpdateRequestsDto updateRequestsDto) {
        return queryFactory
                .update(comment)
                .set(comment.commentContent,updateRequestsDto.getCommentContent())
                .where(comment.id.eq(updateRequestsDto.getCommentId()))
                .execute();

    }

    private BooleanExpression commentProductIdEq(Long proudctId) {
        return proudctId == null ? comment.product.id.isNull() : comment.product.id.eq(proudctId);
    }
}
