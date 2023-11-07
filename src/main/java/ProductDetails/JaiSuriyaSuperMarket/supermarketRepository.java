package ProductDetails.JaiSuriyaSuperMarket;

import ProductDetails.JaiSuriyaSuperMarket.supermarketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface supermarketRepository extends CrudRepository<supermarketEntity,Integer>
{

}
