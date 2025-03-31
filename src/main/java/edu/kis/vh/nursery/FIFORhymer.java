package edu.kis.vh.nursery;
/*
    Klasa reprezentuje specjalizowaną implementację DefaultCountingOutRhymer,
    która stosuje algorytm FIFO (First-In-First-Out) do zwracania elementów.
 */

public class FIFORhymer extends DefaultCountingOutRhymer {


    //Tymczasowy schowek używany do odwracania kolejności elementów.

    public final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();


    //Nadpisuje metodę countOut, aby zaimplementować zachowanie FIFO.

    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
