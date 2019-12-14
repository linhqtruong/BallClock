import java.util.ArrayDeque;

public class Track<T extends Comparable<T>> extends ArrayDeque<T> {
	private int limit;
	private int day = 0;
	private Track<T> nextTrack, mainTrack;
	
	public Track(Track<T> nextTrack, Track<T> mainTrack, int limit) {
		this.nextTrack = nextTrack;
		this.mainTrack = mainTrack;
		this.limit = limit;
	}
	
	public void push(T ball) {
		if (size() == limit) {
			while (!isEmpty())	mainTrack.addLast(pop());
			if (nextTrack != null) 
				nextTrack.push(ball);
			 else {
				day++;
				mainTrack.addLast(ball);
			}
		} else 
			super.push(ball);		
	}
	
	public int getDay() { return day;}
	
	public boolean isBallsInOrder() {
		T previous = null;
		for (T i : this) {
			if (previous != null) 
				if (previous.compareTo(i) > 0)	return false;
			previous = i;
		}		
		return true;
	}
}