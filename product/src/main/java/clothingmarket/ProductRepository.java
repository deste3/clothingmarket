package clothingmarket;

import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
    List<Product> findByOrderId(Long OrderId);
}