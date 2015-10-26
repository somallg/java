package java.chapter08;

import net.jcip.annotations.Immutable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by somallg on 9/4/14.
 */
@Immutable
public class Node<P, M> {
    final P pos;
    final M move;
    final Node<P, M> prev;

    Node(P pos, M move, Node<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    List<M> asMoveList() {
        List<M> solution = new LinkedList<M>();
        for (Node<P, M> n = this; n.move != null; n = n.prev) {
            solution.add(0, n.move);
        }

        return solution;
    }
}
