

public interface Clock {

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
    public void set(int hh, int mm, int ss, boolean morning);

    /**
     * Advances the clock by 1 second. Make sure when implementing this method
     * that the seconds "roll over" correctly - 11:59:59AM should become
     * 12:00:00PM for example.
     */
    public void tick();

    /**
     * Returns a string containing the current time formatted as a digital clock
     * format. For example, midnight should return the string "12:00:00AM" while
     * one in the morning would return the string "1:00:00AM" and one in the
     * afternoon the string "1:00:00PM".
     *
     * @return - the current time formatted in AM/PM format
     */
    @Override
    public String toString();

}
