package clothingmarket;

import clothingmarket.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_(@Payload DeliveryStarted deliveryStarted){

        if(deliveryStarted.isMe()){
            System.out.println("##### listener  : " + deliveryStarted.toJson());

            Optional<Order> orderOptional = orderRepository.findById(deliveryStarted.getOrderId());
            Order order = orderOptional.get();
            order.setStatus(deliveryStarted.getStatus());
            order.setStatus("DeliveryStarted");
            orderRepository.save(order);
        }
    }

}
