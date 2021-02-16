package clothingmarket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private String productId;
        private Integer qty;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }
        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
