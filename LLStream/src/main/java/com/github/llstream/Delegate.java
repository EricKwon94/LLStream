package com.github.llstream;

public final class Delegate {

    private Delegate(){

    }

    public interface Action {
        void call();
    }

    public interface Action1<T1> {
        void call(T1 t1);
    }

    public interface Action2<T1, T2> {
        void call(T1 t1, T2 t2);
    }

    public interface Action3<T1, T2, T3> {
        void call(T1 t1, T2 t2, T3 t3);
    }

    public interface Action4<T1, T2, T3, T4> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    public interface Action5<T1, T2, T3, T4, T5> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    public interface Action6<T1, T2, T3, T4, T5, T6> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    public interface Action7<T1, T2, T3, T4, T5, T6, T7> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    public interface Action8<T1, T2, T3, T4, T5, T6, T7, T8> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    public interface Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        void call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }

    public interface Func<R> {
        R call();
    }

    public interface Func1<T1, R> {
        R call(T1 t1);
    }

    public interface Func2<T1, T2, R> {
        R call(T1 t1, T2 t2);
    }

    public interface Func3<T1, T2, T3, R> {
        R call(T1 t1, T2 t2, T3 t3);
    }

    public interface Func4<T1, T2, T3, T4, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    public interface Func5<T1, T2, T3, T4, T5, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    public interface Func6<T1, T2, T3, T4, T5, T6, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    public interface Func7<T1, T2, T3, T4, T5, T6, T7, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    public interface Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    public interface Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
        R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }

    public interface Predicate {
        boolean call();
    }

    public interface Predicate1<T1> {
        boolean call(T1 t1);
    }

    public interface Predicate2<T1, T2> {
        boolean call(T1 t1, T2 t2);
    }

    public interface Predicate3<T1, T2, T3> {
        boolean call(T1 t1, T2 t2, T3 t3);
    }

    public interface Predicate4<T1, T2, T3, T4> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4);
    }

    public interface Predicate5<T1, T2, T3, T4, T5> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    public interface Predicate6<T1, T2, T3, T4, T5, T6> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    public interface Predicate7<T1, T2, T3, T4, T5, T6, T7> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    public interface Predicate8<T1, T2, T3, T4, T5, T6, T7, T8> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    public interface Predicate9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        boolean call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }
}
