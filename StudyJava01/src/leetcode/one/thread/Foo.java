package leetcode.one.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liutao0705@live.com
 * @date 2020/6/30 9:46 下午
 */
public class Foo {
    //AtomicInteger 原子整型；原子数
    /*
    * java并发机制中主要有三个特性需要我们去考虑，原子性、可见性和有序性。
    * synchronized关键字可以保证可见性和有序性却无法保证原子性。
    * 而这个AtomicInteger的作用就是为了保证原子性。
    * */

    /*
    * compareAndSwapInt又叫做CAS，如果你将来找工作，这个不清楚的话，基本上可以告别java这个方向了。
    // setup to use Unsafe.compareAndSwapInt for updates
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    *
    * CAS 即比较并替换，实现并发算法时常用到的一种技术。
    * CAS操作包含三个操作数——内存位置、预期原值及新值。
    * 执行CAS操作的时候，将内存位置的值与预期原值比较，
    * 如果相匹配，那么处理器会自动将该位置值更新为新值，
    * 否则，处理器不做任何操作。
    *
    * （2）Unsafe的含义
        在上面我们主要是讲解了CAS的含义，CAS修饰在Unsafe上面。那这个Unsafe是什么意思呢？
        Unsafe是位于sun.misc包下的一个类，Unsafe类使Java语言拥有了类似C语言指针一样操作内存空间的能力，
        * 这无疑也增加了程序发生相关指针问题的风险。在程序中过度、不正确使用Unsafe
    *   类会使得程序出错的概率变大，使得Java这种安全的语言变得不再“安全”，因此对Unsafe的使用一定要慎重。
        这里说一句题外话，在jdk1.9中，对Usafe进行了删除，所以因为这，那些基于Usafe开发的框架慢慢的都死掉了。
        在这里也就是说，Usafe再进行getAndAddInt的时候，首先是先加1，
    * 然后对底层对象的地址做出了更改。这个地址是什么呢？这就是涉及到我们的第三个疑问参数了
    *（3）valueOffset的含义
    * 这个valueOffset是long类型的，代表的含义就是对象的地址的偏移量。
    * */
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }

}
