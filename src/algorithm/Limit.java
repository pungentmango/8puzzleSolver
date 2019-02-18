package algorithm;

public class Limit {

	// TODO: implement a reset method so that limit can be reused
	public int limit = 10000;
	public int count = 0;

	public Limit() {
		reset();
	}

	public Limit(int limit) {
		this.limit = limit;
		reset();
	}

	public boolean isLimit(int count) {
		if (count < this.limit) {
			return false;
		}
		printLimitReached();
		return true;
	}

	public boolean isLimit() {
		if (count > 0) {
			count--;
			return false;
		}
		printLimitReached();
		return true;
	}
	
	private void printLimitReached() {
		System.out.println("limit of " + limit + " reached!");
		
	}

	public void reset() {
		this.count = this.limit;
	}

}
