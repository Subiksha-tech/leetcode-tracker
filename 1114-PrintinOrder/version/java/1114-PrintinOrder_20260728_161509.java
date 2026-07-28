// Last updated: 28/07/2026, 16:15:09
1class FooBar {
2    private int n;
3    private Semaphore foo = new Semaphore(1);
4    private Semaphore bar = new Semaphore(0);
5
6    public FooBar(int n) {
7        this.n = n;
8    }
9
10    public void foo(Runnable printFoo) throws InterruptedException {
11        for (int i = 0; i < n; i++) {
12            foo.acquire();
13            printFoo.run();
14            bar.release();
15        }
16    }
17
18    public void bar(Runnable printBar) throws InterruptedException {
19        for (int i = 0; i < n; i++) {
20            bar.acquire();
21            printBar.run();
22            foo.release();
23        }
24    }
25}