package ProductDetails.JaiSuriyaSuperMarket;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JaiSuriyaSuperMarketApplicationTests
{

	@MockBean
	supermarketRepository repo;

	@Autowired
	supermarketservice serv;

	@Test
	public void testcreate()
	{
		supermarketEntity product1=new supermarketEntity(1,"Juice","coco","Chocoshake",50,1);
		supermarketEntity product2=new supermarketEntity(2,"Masala","sakthi","Greenchilly",70,2);

		Mockito.when(repo.save(product1)).thenReturn(product1);
		Mockito.when(repo.save(product2)).thenReturn(product2);

		Assert.assertSame("Masala",serv.makecreate(product2).getProductCategory());
	}

	@Test
	public void testlistall()
	{
		supermarketEntity product1=new supermarketEntity(1,"Juice","coco","Chocoshake",50,1);
		supermarketEntity product2=new supermarketEntity(2,"Masala","sakthi","Greenchilly",70,2);

		Mockito.when(repo.findAll()).thenReturn(Stream.of(product1,product2).collect(Collectors.toList()));

//		Assert.assertSame(2,serv.viewall().get(1).getProductCount());
		Assert.assertNotSame(3,serv.viewall().size());
	}



}
