package woowacourseTest.week2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RacingCar rc = new RacingCar();
        rc.run();
    }
}
// pobi,woni,jun  -> o
// pobibi,woni,jun -> x
// pobi, woni,jun -> x
// pobi,woni;jun -> x