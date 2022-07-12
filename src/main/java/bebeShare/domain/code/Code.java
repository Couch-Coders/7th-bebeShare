package bebeShare.domain.code;

import bebeShare.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Code extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeId")
    private Long id;

    private String code;

    private String codeName;

    private String useYn;

    @Builder
    public Code(String code, String codeName, String useYn) {
        this.code = code;
        this.codeName = codeName;
        this.useYn = useYn;
    }
}
