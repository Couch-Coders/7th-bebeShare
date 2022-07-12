package bebeShare.domain.like;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDibs is a Querydsl query type for Dibs
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDibs extends EntityPathBase<Dibs> {

    private static final long serialVersionUID = 1428990104L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDibs dibs = new QDibs("dibs");

    public final bebeShare.QBaseEntity _super = new bebeShare.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> createedById = _super.createedById;

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    //inherited
    public final NumberPath<Long> modifiedById = _super.modifiedById;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final bebeShare.domain.product.QProduct product;

    public final bebeShare.domain.user.QUser user;

    public QDibs(String variable) {
        this(Dibs.class, forVariable(variable), INITS);
    }

    public QDibs(Path<? extends Dibs> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDibs(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDibs(PathMetadata metadata, PathInits inits) {
        this(Dibs.class, metadata, inits);
    }

    public QDibs(Class<? extends Dibs> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new bebeShare.domain.product.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new bebeShare.domain.user.QUser(forProperty("user")) : null;
    }

}

