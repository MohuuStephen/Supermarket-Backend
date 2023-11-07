package ProductDetails.JaiSuriyaSuperMarket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data  //getter/setter
@NoArgsConstructor  //default cosntructor
@AllArgsConstructor //parameterized constructor
public class supermarketEntity
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productCount;
    private String productCategory;
    private String productBrand;
    private String productName;
    private int productPrice;
    private int productOffer;
}
