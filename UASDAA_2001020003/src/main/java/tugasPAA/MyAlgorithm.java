/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasPAA;

public class MyAlgorithm extends matrixmap.Algorithm {
    @Override
    public boolean running() {
        if (courier != null) {

            int carRow = courier.getRowPosition();
            int carCol = courier.getColPosition();
            if (carRow == destRow && carCol == destCol)
                return false;

            if (carCol < destCol) {
                if (courier.headed() == SOUTH) {
                    if (courier.sensing(LEFT))
                        courier.forward();
                } else
                    courier.turnRight();
            } else {
                if (courier.headed() == NORTH) {
                    if (courier.sensing(AHEAD))
                        courier.forward();
                    if (courier.sensing(LEFT))
                        courier.forward();
                    if (courier.sensing(BEHIND))
                        courier.forward();

                } else
                    courier.turnRight();
            }


            return true;
        }
        return false;
    }
}