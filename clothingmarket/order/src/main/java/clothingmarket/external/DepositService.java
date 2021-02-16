
package clothingmarket.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Deposit", url="http://Deposit:8080")
public interface DepositService {

    @RequestMapping(method= RequestMethod.GET, path="/deposits")
    public void pay(@RequestBody Deposit deposit);

}