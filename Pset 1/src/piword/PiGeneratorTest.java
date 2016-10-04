package piword;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {

    /*
     * Testing strategy - PowerMod
     * 
     * Partition the inputs as follows: a, b, m: negative, 0, 1, 2+
     * 
     */
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));
    }

    /*
     * Covers: b=0,1,2+ m=1,2+
     */
    @Test
    public void base0PowerModTest() {

        assertEquals(1, PiGenerator.powerMod(1, 0, 2));
        assertEquals(0, PiGenerator.powerMod(0, 634, 29234));
        assertEquals(0, PiGenerator.powerMod(0, 0, 1));
        assertEquals(0, PiGenerator.powerMod(0, 634, 1));
    }

    /*
     * Covers: a = 1, 2+ m = 1, 2+
     */
    @Test
    public void exponent0PowerModTest() {
        assertEquals(0, PiGenerator.powerMod(1, 0, 1));
        assertEquals(0, PiGenerator.powerMod(3, 0, 1));
        assertEquals(1, PiGenerator.powerMod(78, 0, 2));
        assertEquals(1, PiGenerator.powerMod(1, 0, 15));

    }

    @Test
    public void nonDefinedPowerModTest() {
        assertEquals(-1, PiGenerator.powerMod(-2, 5, 1));
        assertEquals(-1, PiGenerator.powerMod(1, -3, 1));
        assertEquals(-1, PiGenerator.powerMod(1, 0, 0));
    }

    /*
     * Testing strategy - computePiInHex
     * 
     * Partition input as follows: n: negative, 0, 1, 2+
     * 
     */

    // Negative values should return null
    @Test
    public void negativeCopmutePiInHex() {
        assertNull("negative should return null", PiGenerator.computePiInHex(-5));
        assertNull("negative should return null", PiGenerator.computePiInHex(-1));
    }

    // Zero should return null
    @Test
    public void zeroCopmutePiInHex() {
        assertNull("zero should return null", PiGenerator.computePiInHex(0));
    }

    // 1 should return 2
    @Test
    public void oneCopmutePiInHex() {
        assertArrayEquals("1 should return 0x02", new int[] { 0x02 }, PiGenerator.computePiInHex(1));
    }

    @Test
    public void basicComputePiInHex() {
        assertArrayEquals(new int[] { 0x02, 0x04, 0x03, 0x0F }, PiGenerator.computePiInHex(4));
    
        assertArrayEquals(
                new int[] { 0x02, 0x04, 0x03, 0x0F, 0x06, 0x0A, 0x08, 0x08, 0x08, 0x05, 0x0A, 0x03, 0x00, 0x08, 0x0D },
                PiGenerator.computePiInHex(15));
    }

}
