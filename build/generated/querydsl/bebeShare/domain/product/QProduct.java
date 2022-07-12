package bebeShare.domain.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 20299643L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final bebeShare.QBaseEntity _super = new bebeShare.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> createedById = _super.createedById;

    public final StringPath deleteYn = createString("deleteYn");

    public final ListPath<bebeShare.domain.like.Dibs, bebeShare.domain.like.QDibs> dibs = this.<bebeShare.domain.like.Dibs, bebeShare.domain.like.QDibs>createList("dibs", bebeShare.domain.like.Dibs.class, bebeShare.domain.like.QDibs.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final NumberPath<Long> modifiedById = _super.modifiedById;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath productCategory = createString("productCategory");

    public final StringPath productContent = createString("productContent");

    public final StringPath productImage1 = createString("productImage1");

    public final StringPath productImage2 = createString("productImage2");

    public final StringPath productImage3 = createString("productImage3");

    public final StringPath productName = createString("productName");

    public final StringPath productStatus = createString("productStatus");

    public final NumberPath<Long> shareId = createNumber("shareId", Long.class);

    public final bebeShare.domain.user.QUser user;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new bebeShare.domain.user.QUser(forProperty("user")) : null;
    }

}

