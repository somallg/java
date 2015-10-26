package java.chapter08;

import java.util.Set;

/**
 * Created by somallg on 9/3/14.
 */
public interface Puzzle<P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
