package Question16_5;

/**
 * 同一个Foo实例会被传入三个线程，threadA会调用first，threadB会调用second，threadC会调用third。
 * 设计一种机制，确保first会在second之前调用，second会在third之前调用。
 */
public class Question {
	public static void main(String[] args) {
		FooBad foo = new FooBad();
		
		MyThread thread1 = new MyThread(foo, "first");
		MyThread thread2 = new MyThread(foo, "second");
		MyThread thread3 = new MyThread(foo, "third");
		
		thread3.start();
		thread2.start();
		thread1.start();
	}
}
