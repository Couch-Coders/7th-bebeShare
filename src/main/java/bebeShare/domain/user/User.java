package bebeShare.domain.user;

import antlr.build.ANTLR;
import bebeShare.BaseEntity;
import bebeShare.domain.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Member")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    @Column(nullable = false, name = "memberName")
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();


    private Integer shareCnt;
    private Integer giveCnt;
    private Integer shareChanceCnt;

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.shareCnt = 0;
        this.giveCnt = 0;
        this.shareChanceCnt = 3;
    }


    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

//    public String getRoleKey() {
//        return this.role.getKey();
//    }

    public void addShareCnt(int cnt) {
        this.shareCnt += 1;
    }

    public void addGiveCnt() {
        this.giveCnt += 1;
    }

    public void addShareChanceCnt() {
        this.shareChanceCnt += 1;
    }

    public void minusShareChanceCnt() {
        this.shareChanceCnt -= 1;
    }
}
