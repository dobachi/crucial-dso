package org.infinispan.crucial;


import java.io.*;

/**
 * @author Daniel
 */
public class CAtomicLong implements Externalizable {
    private long value = 0;

    public CAtomicLong() {}

    public CAtomicLong(long initialValue) {
        value = initialValue;
    }

    public void printValue() {
        System.out.println(value);
    }

    public long get() {
        return value;
    }

    public void set(long newValue) {
        value = newValue;
    }

    public long getAndSet(long newValue) {
        long old = value;
        value = newValue;
        return old;
    }

    public long getAndIncrement() {
        return getAndAdd(1);
    }

    public long getAndDecrement() {
        return getAndAdd(-1);
    }

    public long getAndAdd(long delta) {
        value += delta;
        return value - delta;
    }

    public long incrementAndGet() {
        return addAndGet(1);
    }

    public long decrementAndGet() {
        return addAndGet(-1);
    }

    public long addAndGet(long delta) {
        value += delta;
        return value;
    }

    public long pow2more() {
        for (int i = 0; i < 10000; i++) {
            value *= value;
        }
        return value;
    }

    public long pow2() {
        value *= value;
        return value;
    }

    /**
     * Returns the String representation of the current value.
     *
     * @return the String representation of the current value
     */
    public String toString() {
        return Long.toString(get());
    }

    /**
     * Returns the value of this {@code CAtomicInt} as an {@code int}.
     */
    public int intValue() {
        return (int) get();
    }

    /**
     * Returns the value of this {@code CAtomicInt} as a {@code long}
     * after a widening primitive conversion.
     */
    public long longValue() {
        return (long) get();
    }

    /**
     * Returns the value of this {@code CAtomicInt} as a {@code float}
     * after a widening primitive conversion.
     */
    public float floatValue() {
        return (float) get();
    }

    /**
     * Returns the value of this {@code CAtomicInt} as a {@code double}
     * after a widening primitive conversion.
     */
    public double doubleValue() {
        return (double) get();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        value = in.readLong();
    }
}
