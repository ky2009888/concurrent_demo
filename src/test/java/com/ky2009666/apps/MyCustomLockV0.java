package com.ky2009666.apps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ky2009666
 * @description 自定义锁
 * @date 2021/5/20
 **/
public class MyCustomLockV0 implements Lock {
    class mySyn extends AbstractQueuedSynchronizer{
        /**
         * Creates a new {@code AbstractQueuedSynchronizer} instance
         * with initial synchronization state of zero.
         */
        protected mySyn() {
            super();
        }

        /**
         * Attempts to acquire in exclusive mode. This method should query
         * if the state of the object permits it to be acquired in the
         * exclusive mode, and if so to acquire it.
         *
         * <p>This method is always invoked by the thread performing
         * acquire.  If this method reports failure, the acquire method
         * may queue the thread, if it is not already queued, until it is
         * signalled by a release from some other thread. This can be used
         * to implement method {@link Lock#tryLock()}.
         *
         * <p>The default
         * implementation throws {@link UnsupportedOperationException}.
         *
         * @param arg the acquire argument. This value is always the one
         *            passed to an acquire method, or is the value saved on entry
         *            to a condition wait.  The value is otherwise uninterpreted
         *            and can represent anything you like.
         * @return {@code true} if successful. Upon success, this object has
         * been acquired.
         * @throws IllegalMonitorStateException  if acquiring would place this
         *                                       synchronizer in an illegal state. This exception must be
         *                                       thrown in a consistent fashion for synchronization to work
         *                                       correctly.
         * @throws UnsupportedOperationException if exclusive mode is not supported
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){

            }
            return super.tryAcquire(arg);
        }

        /**
         * Attempts to set the state to reflect a release in exclusive
         * mode.
         *
         * <p>This method is always invoked by the thread performing release.
         *
         * <p>The default implementation throws
         * {@link UnsupportedOperationException}.
         *
         * @param arg the release argument. This value is always the one
         *            passed to a release method, or the current state value upon
         *            entry to a condition wait.  The value is otherwise
         *            uninterpreted and can represent anything you like.
         * @return {@code true} if this object is now in a fully released
         * state, so that any waiting threads may attempt to acquire;
         * and {@code false} otherwise.
         * @throws IllegalMonitorStateException  if releasing would place this
         *                                       synchronizer in an illegal state. This exception must be
         *                                       thrown in a consistent fashion for synchronization to work
         *                                       correctly.
         * @throws UnsupportedOperationException if exclusive mode is not supported
         */
        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }

        /**
         * Attempts to acquire in shared mode. This method should query if
         * the state of the object permits it to be acquired in the shared
         * mode, and if so to acquire it.
         *
         * <p>This method is always invoked by the thread performing
         * acquire.  If this method reports failure, the acquire method
         * may queue the thread, if it is not already queued, until it is
         * signalled by a release from some other thread.
         *
         * <p>The default implementation throws {@link
         * UnsupportedOperationException}.
         *
         * @param arg the acquire argument. This value is always the one
         *            passed to an acquire method, or is the value saved on entry
         *            to a condition wait.  The value is otherwise uninterpreted
         *            and can represent anything you like.
         * @return a negative value on failure; zero if acquisition in shared
         * mode succeeded but no subsequent shared-mode acquire can
         * succeed; and a positive value if acquisition in shared
         * mode succeeded and subsequent shared-mode acquires might
         * also succeed, in which case a subsequent waiting thread
         * must check availability. (Support for three different
         * return values enables this method to be used in contexts
         * where acquires only sometimes act exclusively.)  Upon
         * success, this object has been acquired.
         * @throws IllegalMonitorStateException  if acquiring would place this
         *                                       synchronizer in an illegal state. This exception must be
         *                                       thrown in a consistent fashion for synchronization to work
         *                                       correctly.
         * @throws UnsupportedOperationException if shared mode is not supported
         */
        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        /**
         * Attempts to set the state to reflect a release in shared mode.
         *
         * <p>This method is always invoked by the thread performing release.
         *
         * <p>The default implementation throws
         * {@link UnsupportedOperationException}.
         *
         * @param arg the release argument. This value is always the one
         *            passed to a release method, or the current state value upon
         *            entry to a condition wait.  The value is otherwise
         *            uninterpreted and can represent anything you like.
         * @return {@code true} if this release of shared mode may permit a
         * waiting acquire (shared or exclusive) to succeed; and
         * {@code false} otherwise
         * @throws IllegalMonitorStateException  if releasing would place this
         *                                       synchronizer in an illegal state. This exception must be
         *                                       thrown in a consistent fashion for synchronization to work
         *                                       correctly.
         * @throws UnsupportedOperationException if shared mode is not supported
         */
        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        /**
         * Returns {@code true} if synchronization is held exclusively with
         * respect to the current (calling) thread.  This method is invoked
         * upon each call to a non-waiting {@link ConditionObject} method.
         * (Waiting methods instead invoke {@link #release}.)
         *
         * <p>The default implementation throws {@link
         * UnsupportedOperationException}. This method is invoked
         * internally only within {@link ConditionObject} methods, so need
         * not be defined if conditions are not used.
         *
         * @return {@code true} if synchronization is held exclusively;
         * {@code false} otherwise
         * @throws UnsupportedOperationException if conditions are not supported
         */
        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }
    /**
     * Acquires the lock.
     *
     * <p>If the lock is not available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until the
     * lock has been acquired.
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>A {@code Lock} implementation may be able to detect erroneous use
     * of the lock, such as an invocation that would cause deadlock, and
     * may throw an (unchecked) exception in such circumstances.  The
     * circumstances and the exception type must be documented by that
     * {@code Lock} implementation.
     */
    @Override
    public void lock() {

    }

    /**
     * Acquires the lock unless the current thread is
     * {@linkplain Thread#interrupt interrupted}.
     *
     * <p>Acquires the lock if it is available and returns immediately.
     *
     * <p>If the lock is not available then the current thread becomes
     * disabled for thread scheduling purposes and lies dormant until
     * one of two things happens:
     *
     * <ul>
     * <li>The lock is acquired by the current thread; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts} the
     * current thread, and interruption of lock acquisition is supported.
     * </ul>
     *
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while acquiring the
     * lock, and interruption of lock acquisition is supported,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>The ability to interrupt a lock acquisition in some
     * implementations may not be possible, and if possible may be an
     * expensive operation.  The programmer should be aware that this
     * may be the case. An implementation should document when this is
     * the case.
     *
     * <p>An implementation can favor responding to an interrupt over
     * normal method return.
     *
     * <p>A {@code Lock} implementation may be able to detect
     * erroneous use of the lock, such as an invocation that would
     * cause deadlock, and may throw an (unchecked) exception in such
     * circumstances.  The circumstances and the exception type must
     * be documented by that {@code Lock} implementation.
     *
     * @throws InterruptedException if the current thread is
     *                              interrupted while acquiring the lock (and interruption
     *                              of lock acquisition is supported)
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * Acquires the lock only if it is free at the time of invocation.
     *
     * <p>Acquires the lock if it is available and returns immediately
     * with the value {@code true}.
     * If the lock is not available then this method will return
     * immediately with the value {@code false}.
     *
     * <p>A typical usage idiom for this method would be:
     * <pre> {@code
     * Lock lock = ...;
     * if (lock.tryLock()) {
     *   try {
     *     // manipulate protected state
     *   } finally {
     *     lock.unlock();
     *   }
     * } else {
     *   // perform alternative actions
     * }}</pre>
     * <p>
     * This usage ensures that the lock is unlocked if it was acquired, and
     * doesn't try to unlock if the lock was not acquired.
     *
     * @return {@code true} if the lock was acquired and
     * {@code false} otherwise
     */
    @Override
    public boolean tryLock() {
        return false;
    }

    /**
     * Acquires the lock if it is free within the given waiting time and the
     * current thread has not been {@linkplain Thread#interrupt interrupted}.
     *
     * <p>If the lock is available this method returns immediately
     * with the value {@code true}.
     * If the lock is not available then
     * the current thread becomes disabled for thread scheduling
     * purposes and lies dormant until one of three things happens:
     * <ul>
     * <li>The lock is acquired by the current thread; or
     * <li>Some other thread {@linkplain Thread#interrupt interrupts} the
     * current thread, and interruption of lock acquisition is supported; or
     * <li>The specified waiting time elapses
     * </ul>
     *
     * <p>If the lock is acquired then the value {@code true} is returned.
     *
     * <p>If the current thread:
     * <ul>
     * <li>has its interrupted status set on entry to this method; or
     * <li>is {@linkplain Thread#interrupt interrupted} while acquiring
     * the lock, and interruption of lock acquisition is supported,
     * </ul>
     * then {@link InterruptedException} is thrown and the current thread's
     * interrupted status is cleared.
     *
     * <p>If the specified waiting time elapses then the value {@code false}
     * is returned.
     * If the time is
     * less than or equal to zero, the method will not wait at all.
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>The ability to interrupt a lock acquisition in some implementations
     * may not be possible, and if possible may
     * be an expensive operation.
     * The programmer should be aware that this may be the case. An
     * implementation should document when this is the case.
     *
     * <p>An implementation can favor responding to an interrupt over normal
     * method return, or reporting a timeout.
     *
     * <p>A {@code Lock} implementation may be able to detect
     * erroneous use of the lock, such as an invocation that would cause
     * deadlock, and may throw an (unchecked) exception in such circumstances.
     * The circumstances and the exception type must be documented by that
     * {@code Lock} implementation.
     *
     * @param time the maximum time to wait for the lock
     * @param unit the time unit of the {@code time} argument
     * @return {@code true} if the lock was acquired and {@code false}
     * if the waiting time elapsed before the lock was acquired
     * @throws InterruptedException if the current thread is interrupted
     *                              while acquiring the lock (and interruption of lock
     *                              acquisition is supported)
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * Releases the lock.
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>A {@code Lock} implementation will usually impose
     * restrictions on which thread can release a lock (typically only the
     * holder of the lock can release it) and may throw
     * an (unchecked) exception if the restriction is violated.
     * Any restrictions and the exception
     * type must be documented by that {@code Lock} implementation.
     */
    @Override
    public void unlock() {

    }

    /**
     * Returns a new {@link Condition} instance that is bound to this
     * {@code Lock} instance.
     *
     * <p>Before waiting on the condition the lock must be held by the
     * current thread.
     * A call to {@link Condition#await()} will atomically release the lock
     * before waiting and re-acquire the lock before the wait returns.
     *
     * <p><b>Implementation Considerations</b>
     *
     * <p>The exact operation of the {@link Condition} instance depends on
     * the {@code Lock} implementation and must be documented by that
     * implementation.
     *
     * @return A new {@link Condition} instance for this {@code Lock} instance
     * @throws UnsupportedOperationException if this {@code Lock}
     *                                       implementation does not support conditions
     */
    @Override
    public Condition newCondition() {
        return null;
    }
}
