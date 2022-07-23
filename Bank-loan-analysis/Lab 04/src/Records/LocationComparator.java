package Records;

import java.util.Comparator;

public class LocationComparator implements Comparator <BankRecords>{
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		// TODO Auto-generated method stub
		return o1.getRegion().compareTo(o2.getRegion());
	}

}
