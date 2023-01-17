
public class VehicleType {
	
	private String type;
	
	private Integer total;
	
	private Integer count;
	
	public VehicleType() {
		super();
	}

	public VehicleType(String type, Integer total, Integer count) {
		super();
		this.type = type;
		this.total = total;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "VehicleType [type=" + type + ", total=" + total + ", count=" + count + "]";
	}

}
