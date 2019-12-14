public class Clock {

	private int numBalls;
	private Track<Integer> mainTrack, minuteTrack, fiveTrack, hourTrack;
	
	public Clock(int numBalls) {
		this.numBalls = numBalls;
		// Initialize Tracks
		mainTrack = new Track<Integer>(null, null, numBalls);
		hourTrack = new Track<Integer>(null, mainTrack, 11);
		fiveTrack = new Track<Integer>(hourTrack, mainTrack, 11);
		minuteTrack = new Track<Integer>(fiveTrack, mainTrack, 4);
		//Create Main Track Balls
		for (int i = 1; i <= numBalls; i++) mainTrack.addLast(i);		
	}
	
	public int runUntilOrdered() {
		do {
			Integer ball = (Integer)mainTrack.removeFirst();
			minuteTrack.push(ball);
		} while ((!mainTrack.isBallsInOrder()) || (mainTrack.size() != numBalls));
		return hourTrack.getDay()/2;
	}
	
	public static void main(String args[]) {
		Clock clock = new Clock(30);
		System.out.println(clock.numBalls + " balls cycle after " + clock.runUntilOrdered() + " days");
		Clock clock2 = new Clock(45);
		System.out.println(clock2.numBalls + " balls cycle after " + clock2.runUntilOrdered() + " days");	
	}
}