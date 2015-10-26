package java.chapter11.item78;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by duongtq on 30/08/2014.
 */
public class Period implements Serializable {
    private static final long serialVersionUID = 23432432432432L;
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        private SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        private static final long serialVersionUID = 23456346L;

        private Object readResolve() {
            return new Period(start, end);
        }
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
       throw new InvalidObjectException("Proxy required");
    }
}


