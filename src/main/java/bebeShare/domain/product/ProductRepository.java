package bebeShare.domain.product;

import bebeShare.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom, QuerydslPredicateExecutor<Product> {
    Optional<Product> findById(Long id);

}
