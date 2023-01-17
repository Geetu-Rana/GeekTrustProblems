import java.util.Comparator;

public class SortByVehicleType implements Comparator<VehicleType>{

	@Override
	public int compare(VehicleType o1, VehicleType o2) {
		if(o1.getTotal()>o2.getTotal()) {
			return -1;
		}
		if(o1.getTotal()<o2.getTotal()) {
			return 1;
		}
		return o1.getType().compareTo(o2.getType());
	}

}
