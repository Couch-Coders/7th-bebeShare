package bebeShare.domain.user;

import bebeShare.domain.product.Product;
import bebeShare.web.dto.userDto.dto.*;
import bebeShare.web.dto.userDto.req.CommentRequest;
import bebeShare.web.dto.userDto.req.GiveRequest;
import bebeShare.web.dto.userDto.req.LikeRequest;
import bebeShare.web.dto.userDto.req.ShareRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static bebeShare.domain.comment.QComment.comment;
import static bebeShare.domain.like.QDibs.dibs;
import static bebeShare.domain.product.QProduct.product;
import static bebeShare.domain.user.QUser.user;
import static org.springframework.util.StringUtils.hasText;


public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<ShareInfoResponseDto> shareInfo(ShareRequest shareRequest, Pageable pageable) {


        List<ShareInfoResponseDto> result = queryFactory
                .select(new QShareInfoResponseDto(
                        product.id,
                        product.productName,
                        product.productImage1,
                        product.createdDate.as("insertDt")
                ))
                .from(product)
                .where(
                        productMemberIdEq(shareRequest.getMemberId()),
                        productStatus(shareRequest.getProductStatus())
                )
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .orderBy(product.createdDate.desc())
                .fetch();


        JPAQuery<Product> countQuery = queryFactory.select(product)
                .from(product)
                .where(
                        productMemberIdEq(shareRequest.getMemberId()),
                        productStatus(shareRequest.getProductStatus())
                );

        return PageableExecutionUtils.getPage(result, pageable, () -> countQuery.fetchCount());

    }


    @Override
    public Page<GiveInfoResponseDto> giveInfo(GiveRequest giveRequest, Pageable pageable) {
        List<GiveInfoResponseDto> result = queryFactory
                .select(new QGiveInfoResponseDto(
                        product.id,
                        product.productName,
                        product.productImage1,
                        product.createdDate.as("insertDt")

                ))
                .from(product)
                .where(
                        productShareIdEq(giveRequest.getShareId()),
                        productStatus(giveRequest.getProductStatus())
                )
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .orderBy(product.createdDate.desc())
                .fetch();

        JPAQuery<Product> countQuery = queryFactory.select(product)
                .from(product)
                .where(
                        productShareIdEq(giveRequest.getShareId()),
                        productStatus(giveRequest.getProductStatus())
                );
        return PageableExecutionUtils.getPage(result, pageable, () -> countQuery.fetchCount());

    }

    @Override
    public Page<LikeInfoResponseDto> likeInfo(LikeRequest likeRequest, Pageable pageable) {

        List<LikeInfoResponseDto> result = queryFactory
                .select(new QLikeInfoResponseDto(
                        product.id,
                        product.productName,
                        product.productImage1,
                        product.createdDate.as("insertDt")
                )).from(dibs)
                .join(dibs.product, product)
                .join(dibs.user, user)
                .where(
                        likeIdEq(likeRequest.getMemberId())
                )
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Product> countQuery = queryFactory.select(product)
                .from(dibs)
                .join(dibs.product, product)
                .join(dibs.user, user)
                .where(
                        likeIdEq(likeRequest.getMemberId())
                );
        return PageableExecutionUtils.getPage(result, pageable, () -> countQuery.fetchCount());

    }

    @Override
    public Page<MemberCommentResponseDto> comments(CommentRequest commentRequest, Pageable pageable) {
        List<MemberCommentResponseDto> result = queryFactory
                .select(
                        new QMemberCommentResponseDto(
                                comment.id.as("commentId"),
                                product.productName,
                                comment.commentContent,
                                //product.productImage1,
                                comment.createdDate.as("insertDt")
                        )
                ).from(comment)
                .join(comment.product, product)
                .join(comment.user, user)
                .where(
                        commentMeberIdEq(commentRequest.getMemberId())
                )
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Product> countQuery = queryFactory.select(product)
                .from(comment)
                .join(comment.product, product)
                .join(comment.user, user)
                .where(
                        commentMeberIdEq(commentRequest.getMemberId())
                );
        return PageableExecutionUtils.getPage(result, pageable, () -> countQuery.fetchCount());
    }

    private BooleanExpression commentMeberIdEq(Long memberId) {
        return memberId == 0 ? comment.user.id.isNull() : comment.user.id.eq(memberId);
    }

    private BooleanExpression productMemberIdEq(long memberId) {
        return memberId == 0 ? product.user.id.isNull() : product.user.id.eq(memberId);
    }

    private BooleanExpression productShareIdEq(long shareId) {
        return shareId == 0 ? product.shareId.isNull() : product.shareId.eq(shareId);
    }

    private BooleanExpression likeIdEq(long likeId) {
        return likeId == 0 ? dibs.user.id.isNull() : dibs.user.id.eq(likeId);
    }

    private BooleanExpression memberIdEq(long memberId) {
        return user.id.eq(memberId);
    }

    private BooleanExpression productStatus(String productStatus) {
        return hasText(productStatus) ? product.productStatus.eq(productStatus) : null;
    }
}
