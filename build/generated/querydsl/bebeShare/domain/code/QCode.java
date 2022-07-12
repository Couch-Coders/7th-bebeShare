package bebeShare.domain.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCode is a Querydsl query type for Code
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCode extends EntityPathBase<Code> {

    private static final long serialVersionUID = 465556057L;

    public static final QCode code1 = new QCode("code1");

    public final bebeShare.QBaseEntity _super = new bebeShare.QBaseEntity(this);

    public final StringPath code = createString("code");

    public final StringPath codeName = createString("codeName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> createedById = _super.createedById;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final NumberPath<Long> modifiedById = _super.modifiedById;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath useYn = createString("useYn");

    public QCode(String variable) {
        super(Code.class, forVariable(variable));
    }

    public QCode(Path<? extends Code> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCode(PathMetadata metadata) {
        super(Code.class, metadata);
    }

}

