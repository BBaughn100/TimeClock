
public class SimpleClockTest {

    public static void main(String[] args) {
        Clock clock = new SimpleClock();
        System.out.println("Clock starts at time: " + clock);
        clock.set(11, 59, 59, false);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 12:00:00AM");
        clock.set(12, 59, 59, true);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 1:00:00AM");
        clock.set(11, 59, 59, true);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 12:00:00PM");
        clock.set(5, 35, 59, false);
        System.out.println("Clock has been set to time: " + clock);
        clock.tick();
        System.out.println("TICK: " + clock);
        System.out.println("Clock should read: 5:36:00PM");
        System.out.println("Clock finally reads: " + clock);
    }

}
