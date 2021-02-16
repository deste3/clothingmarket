
package clothingmarket;

public class PayCanceled extends AbstractEvent {

    private Long id;
    private String OrderId;
    private String ProductId;
    private String Status;
    private Integer Qty;

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
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer Qty) {
        this.Qty = Qty;
    }
}
