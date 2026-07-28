// Last updated: 28/07/2026, 16:13:28
1class Foo {
2    private final CountDownLatch firstDone = new CountDownLatch(1);
3    private final CountDownLatch secondDone = new CountDownLatch(1);
4
5    public Foo() {
6    }
7
8    public void first(Runnable printFirst) throws InterruptedException {
9        printFirst.run();
10        firstDone.countDown();
11    }
12
13    public void second(Runnable printSecond) throws InterruptedException {
14        firstDone.await();
15        printSecond.run();
16        secondDone.countDown();
17    }
18
19    public void third(Runnable printThird) throws InterruptedException {
20        secondDone.await();
21        printThird.run();
22    }
23}