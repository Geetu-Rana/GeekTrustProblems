import java.util.*;

public class Solution {
	
	private static final int dis=2;
	
	private Set<FastTag> fastTag=new HashSet<>();
	
	private List<VehicleType> vt=new ArrayList<>();
	
	private static int totalDiscount=0;
	
	private static int fastAmount=0;
	
	private static int cash=0;
	
	private static final int palenty=40;
	
	private static final HashMap<String, Integer> price = new HashMap<>();
	
	static {
		price.put("TRUCK", 200);
		price.put("BUS", 200);
		price.put("VAN", 100);
		price.put("CAR", 100);
		price.put("RICKSHAW", 100);
		price.put("SCOOTER", 50);
		price.put("MOTORBIKE", 50);
	}
	
	public Solution() {
		super();
	}

	public void PrintCollection() {
		
		System.out.println("TOTAL_COLLECTION "+(fastAmount+cash)+" "+totalDiscount);
		
		System.out.println("PAYMENT_SUMMARY "+fastAmount+" "+cash);
		
		System.out.println("VEHICLE_TYPE_SUMMARY");
		
		Collections.sort(vt,new SortByVehicleType());
		
		for(VehicleType v:vt) {
			System.out.println(v.getType()+" "+v.getCount());
		}
		
	}
	
	public FastTag getFast(String name) {
		FastTag ft=null;
		
		for(FastTag f:fastTag) {
			if(name.equals(f.getName())) {
				ft=f;
				break;
			}
		}
		if(ft==null) {
			ft=new FastTag();
			ft.setName(name);
			ft.setBalance(0);
			ft.setCount(0);
		}
		return ft;
	}
	
	public VehicleType getVehicle(String type) {
		VehicleType vtype=null;
		
		for(VehicleType v:vt) {
			if(type.equals(v.getType())) {
				vtype=v;
				break;
			}
		}
		
		if(vtype==null) {
			vtype=new VehicleType();
			vtype.setType(type);
			vtype.setCount(0);
			vtype.setTotal(0);
			vt.add(vtype);
		}
		return vtype;
	}


	
	public void collect(FastTag ftag, VehicleType vtype) {
		
		int toBeCharged=price.get(vtype.getType());
		
		ftag.setCount(ftag.getCount()+1);
		vtype.setCount(vtype.getCount()+1);
		
		
		if(ftag.getCount()%2==0) {
			toBeCharged=toBeCharged/dis;
			totalDiscount+=toBeCharged;
		}
		
		vtype.setTotal(vtype.getTotal()+toBeCharged);
		
		int balance=ftag.getBalance();
		
		if(balance<toBeCharged) {
			fastAmount+=balance;
			ftag.setBalance(0);
			int x=toBeCharged-balance;
			cash+=x+palenty;
			vtype.setTotal(vtype.getTotal()+palenty);
		}
		else {
			ftag.setBalance(balance-toBeCharged);
			fastAmount+=toBeCharged;
		}
		
	}

	public void registrFastTag(String name, int bal) {
		
		FastTag fTag=new FastTag();
		
		fTag.setBalance(bal);
		fTag.setName(name);
		fTag.setCount(0);
		
		fastTag.add(fTag);
		
	}

}
