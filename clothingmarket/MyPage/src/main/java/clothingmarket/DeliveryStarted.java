package clothingmarket;

public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String OrderId;
    private String ProductId;
    private Integer Qty;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }
    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }
    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer Qty) {
        this.Qty = Qty;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}