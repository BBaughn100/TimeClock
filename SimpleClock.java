
/**
 * SimpleClock.java
 *
 * A class that implements a simple clock.
 *
 * @author Brendon Baughn
 * @version 12052018
 *
 */
public class SimpleClock implements Clock {

	/* -------- Private member variables --------------------- */
	private int hours;
	private int minutes;
	private int seconds;
	private boolean morning;

	/* -------- Constructor --------------------------------- */
	/**
	 * The constructor should set the intial value of the clock to 12:00:00AM.
	 */
	public SimpleClock() {

		this.hours = 12;
		this.minutes = 0;
		this.seconds = 0;
		this.morning = true;

	}

	/* --------- Instance methods ------------------------- */

	/**
	 * Sets the time showing on the clock.
	 *
	 * @param hh
	 *            - the hours to display
	 * @param mm
	 *            - the minutes to display
	 * @param ss
	 *            - the seconds to display
	 * @param morning
	 *            - true for AM, false for PM
	 */
	@Override
	public void set(int hh, int mm, int ss, boolean morning) {
		this.hours = hh;
		this.minutes = mm;
		this.seconds = ss;
		this.morning = morning;

	}

	/**
	 * Advances the clock by 1 second. Make sure when implementing this method
	 * that the seconds "roll over" correctly - 11:59:59AM should become
	 * 12:00:00PM for example.
	 */
	@Override
	public void tick() {
		/*
		 * When hours is +12
		 * When minutes and seconds are +59
		 * Change of AM and PM
		 */
		++this.seconds;
		if (this.seconds > 59) { // Change Min and Sec
			++this.minutes;
			this.seconds = 0;
			if (this.minutes > 59) { // Change Hours
				++this.hours;
				this.minutes = 0;
				if (this.hours > 12) { // Go to US Standard Time
					this.hours = this.hours - 12;
				}
				if (this.hours == 12 && this.morning == true) { // Turns to 12pm
					this.morning = false;
				} else if (this.hours == 12 && this.morning == false) { // Turns to 12am
					this.morning = true;
				}
			}
		}
	}

	/**
	 * Returns a string containing the current time formatted as a digital clock
	 * format. For example, midnight should return the string "12:00:00AM" while
	 * one in the morning would return the string "1:00:00AM" and one in the
	 * afternoon the string "1:00:00PM".
	 *
	 * @return - the current time formatted in AM/PM format
	 */
	@Override
	public String toString() {
		String ampm = "";
		if (this.morning == true) {
			ampm = "AM";
		} else {
			ampm = "PM";
		}

		// Must Return String in 00 format
		// Initialized Strings:
		String toReturn = "";
		String min = "";
		String sec = "";
		String hrs = "";

		if (this.minutes < 10) { // 00 Format
			String origMin = Integer.toString(this.minutes);
			min = 0 + "" + origMin;
		} else {
			min = Integer.toString(this.minutes);
		}

		if (this.seconds < 10) { // 00 Format
			String origSec = Integer.toString(this.seconds);
			sec = 0 + "" + origSec;
		} else {
			sec = Integer.toString(this.seconds);
		}
		/*
		 * The below code will make sure the hours will be viewable (i.e. if the else-statement is gone, 
		 * clock will output ":00:00"). Hrs should not be in 00 Format.
		 */
		if (this.hours < 10) {
			hrs = Integer.toString(this.hours);
		} else {
			hrs = Integer.toString(this.hours);
		}

		toReturn = hrs + ":" + min + ":" + sec + ampm;

		return toReturn;
	}

}
