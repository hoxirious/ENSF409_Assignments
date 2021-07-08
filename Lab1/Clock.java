
// TODO: Auto-generated Javadoc
/**
 * The Class Clock.
 *
 * @author Hy Huynh, Hao Nguyen
 * @version 1.0
 */
public class Clock {
	
	/** The second. */
	private int day, hour, minute, second;

	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * Sets the day.
	 *
	 * @param day the new day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Sets the hour.
	 *
	 * @param hour the new hour
	 */
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) {
			System.err.println("The hour entered is invalid");
		} else {
			this.hour = hour;
		}
	}

	/**
	 * Sets the minute.
	 *
	 * @param minute the new minute
	 */
	public void setMinute(int minute) {
		if (minute < 0 || minute > 59) {
			System.err.println("The minute entered is invalid");
		} else {
			this.minute = minute;
		}
	}

	/**
	 * Sets the second.
	 *
	 * @param second the new second
	 */
	public void setSecond(int second) {
		if (second < 0 || second > 59) {
			System.err.println("The minute entered is invalid");
		} else {
			this.second = second;
		}
	}

	/**
	 * Calculate total seconds.
	 *
	 * @return the total seconds
	 */
	public int calculateTotalSeconds() {

		return day * 86400 + hour * 3600 + minute * 60 + second;
	}

	/**
	 * Sec to hms.
	 *
	 * @param second the second
	 */
	public void sec_to_hms(int second) {
		setDay((second / 86400));
		setHour((second / 3600) % 24);
		setMinute((second / 60 - hour * 60) % 60);
		setSecond((second - (hour * 3600 + minute * 60)) % 60);
	}

	/**
	 * Increment.
	 *
	 * @param second the second
	 */
	public void increment(int second) {
		sec_to_hms(calculateTotalSeconds() + second);
	}

	/**
	 * Instantiates a new clock.
	 */
	public Clock() {
		setDay(0);
		setHour(0);
		setMinute(0);
		setSecond(0);
	}

	/**
	 * Instantiates a new clock.
	 *
	 * @param day the day
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 */
	public Clock(int day, int hour, int minute, int second) {
		setDay(day);
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Create elapsed time with the default values of zeros for day, hour,
		// minute and second.
		Clock t1 = new Clock(); // Default constructor
		// sets hour to 23
		t1.setHour(23);
		// sets day to 1
		t1.setDay(1);
		// sets minute to 59
		t1.setMinute(59);
		// sets day to 16
		t1.setSecond(16);
		// prints: 1:23:59:16
		System.out.println(t1.getDay() + ":" + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());
		// increments time t1 by 44 seconds:
		t1.increment(44);
		// prints: 2:0:0:0
		System.out.println(t1.getDay() + ":" + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d", t1.calculateTotalSeconds());
		// REPEAT SIMILAR TESTS FOR t2
		// Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
		System.out.println();
		Clock t2 = new Clock(3, 1, 4, 5);
		// increments time t2 by 459 seconds:
		t2.increment(459);
		// prints: 3:1:11:44
		System.out.println(t2.getDay() + ":" + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d", t2.calculateTotalSeconds());

	}

}
