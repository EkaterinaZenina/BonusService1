import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 100_000_600;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 100_000_600;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100_000_600;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

}
