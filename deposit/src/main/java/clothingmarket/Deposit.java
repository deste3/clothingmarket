package clothingmarket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Deposit_table")
public class Deposit {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String productId;
    private String status;
    private Integer qty;

    @PostPersist
    public void onPostPersist(){
        if(this.getStatus().equals("PayCompleted")){
            PayCompleted payCompleted = new PayCompleted();
            BeanUtils.copyProperties(this, payCompleted);
            payCompleted.publishAfterCommit();
        }else if(this.getStatus().equals("PayCanceled")){
            PayCanceled payCanceled = new PayCanceled();
            BeanUtils.copyProperties(this, payCanceled);
            payCanceled.publishAfterCommit();
        }


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
