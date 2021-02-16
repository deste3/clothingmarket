package clothingmarket;

import clothingmarket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {

                // view 객체 생성
                MyPage mypage  = new MyPage();
                // view 객체에 이벤트의 Value 를 set 함
                mypage.setId(ordered.getId());
                mypage.setProductId(ordered.getProductId());
                mypage.setQty(ordered.getQuantity());
                mypage.setStatus(ordered.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(mypage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (deliveryStarted.isMe()) {
                // view 객체 조회
                List<MyPage> mypageList = myPageRepository.findByOrderId(deliveryStarted.getOrderId());
                for(MyPage mypage  : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(deliveryStarted.getStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCanceled_then_UPDATE_2(@Payload PayCanceled payCanceled) {
        try {
            if (payCanceled.isMe()) {
                // view 객체 조회
                List<MyPage> mypageList = myPageRepository.findByOrderId(payCanceled.getOrderId());
                for(MyPage mypage  : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(payCanceled.getStatus());
                    // view 레파지 토리에 save
                    myPageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_DELETE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}