package com.somallg.javaws.ch04.rand2;

import javax.jws.WebService;
import java.util.Random;

@WebService(endpointInterface = "com.somallg.javaws.ch04.rand2.RandService")
public class RandServiceImpl implements RandService {

    private static final int maxRands = 16;

    @Override
    public int next1() {
        return new Random().nextInt();
    }

    @Override
    public int[] nextN(final int n) {
        final int k = (n > maxRands) ? maxRands : Math.abs(n);
        int[] rands = new int[k];
        Random r = new Random();

        for (int i = 0; i < k; i++) {
            rands[i] = r.nextInt();
        }

        return rands;
    }

}
