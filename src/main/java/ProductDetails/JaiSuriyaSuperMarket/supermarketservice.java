package ProductDetails.JaiSuriyaSuperMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class supermarketservice
{
    @Autowired
    supermarketRepository repo;

    public supermarketEntity makecreate(supermarketEntity producrdetails)
    {
        return repo.save(producrdetails);
    }
    public List<supermarketEntity> viewall()
    {
        return (List<supermarketEntity>) repo.findAll();
    }

    public Optional<supermarketEntity> readone(int productcount)
    {
        return repo.findById(productcount);
    }
    public String removeone(int productcount)
    {
        supermarketEntity temp=repo.findById(productcount).orElse(new supermarketEntity());
        repo.delete(temp);
        return temp.getProductName()+"has been deleted";
    }

}
