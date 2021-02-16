package clothingmarket;

import clothingmarket.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyHandler{
    @Autowired
    ProductRepository productRepository;   

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCompleted_(@Payload PayCompleted payCompleted){

        if(payCompleted.isMe()){
            System.out.println("##### listener  : " + payCompleted.toJson());

            Product product = new Product();
            product.setOrderId(payCompleted.getOrderId());
            product.setProductId(payCompleted.getProductId());
            product.setQty(payCompleted.getQty());
            product.setStatus("DeliveryStarted");

            productRepository.save(product);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_(@Payload PayCanceled payCanceled){

        if(payCanceled.isMe()){
            System.out.println("##### listener  : " + payCanceled.toJson());

            List<Product> productlist = productRepository.findByOrderId(payCanceled.getOrderId());

            for(Product product : productlist){
               // view 객체에 이벤트의 eventDirectValue 를 set 함
               product.setStatus("Canceled");
               // view 레파지 토리에 save
               productRepository.save(product);
            }
        }
    }

}
