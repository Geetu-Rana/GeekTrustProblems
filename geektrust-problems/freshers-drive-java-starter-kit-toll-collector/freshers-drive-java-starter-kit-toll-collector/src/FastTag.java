public class FastTag {
	
	private String name;
	
	private Integer balance;
	
	private Integer count;
	
	public FastTag() {
		super();
	}

	public FastTag(String name, Integer balance, Integer count) {
		super();
		this.name = name;
		this.balance = balance;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "FastTag [name=" + name + ", balance=" + balance + ", count=" + count + "]";
	}
	
}
