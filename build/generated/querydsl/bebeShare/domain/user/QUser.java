package bebeShare.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1932643609L;

    public static final QUser user = new QUser("user");

    public final bebeShare.QBaseEntity _super = new bebeShare.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> createedById = _super.createedById;

    public final StringPath email = createString("email");

    public final NumberPath<Integer> giveCnt = createNumber("giveCnt", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final NumberPath<Long> modifiedById = _super.modifiedById;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath picture = createString("picture");

    public final ListPath<bebeShare.domain.product.Product, bebeShare.domain.product.QProduct> products = this.<bebeShare.domain.product.Product, bebeShare.domain.product.QProduct>createList("products", bebeShare.domain.product.Product.class, bebeShare.domain.product.QProduct.class, PathInits.DIRECT2);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final NumberPath<Integer> shareChanceCnt = createNumber("shareChanceCnt", Integer.class);

    public final NumberPath<Integer> shareCnt = createNumber("shareCnt", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

