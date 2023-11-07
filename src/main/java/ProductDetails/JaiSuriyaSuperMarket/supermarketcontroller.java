package ProductDetails.JaiSuriyaSuperMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Supermarket")
public class supermarketcontroller
{
    @Autowired
    supermarketservice serv;


//  http://localhost:8081/create
   @PostMapping("/create")
    public String creation(@RequestBody supermarketEntity productdetails)
    {
        return serv.makecreate(productdetails).getProductName()+"has been added";
    }

    @GetMapping("/")
    public List<supermarketEntity> listall()
    {
        return serv.viewall();
    }

    @GetMapping("/readone/{count}")
    public Optional<supermarketEntity> showone(@PathVariable("count")int count)
    {
        return serv.readone(count);
    }

    @PutMapping("/update")
    public String updating(@RequestBody supermarketEntity productdetails)
    {
        supermarketEntity temp=serv.makecreate(productdetails);
        return temp.getProductName()+"has been updated";
    }

    @DeleteMapping("/deleteone/{count}")
    public String deleteone(@PathVariable("count")int count)
    {
        return serv.removeone(count)+"sucessfully";
    }
}
