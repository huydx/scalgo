package algorithm.other;

import java.io.*;

public class SerializeUidTest {
	static class Foo implements Serializable {
		private static final long serialVersionUID = 2L;
		public int bar1 = 1;
		public int bar2 = 2;
		public int bar3 = 3;
	}

	public static void main(String[] args) {
		String file = "./foo";
		Foo fooObj = new Foo();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(fooObj);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Foo readFooObj = (Foo)(ois.readObject());

			System.out.println(readFooObj.bar1);
			System.out.println(readFooObj.bar2);
			System.out.println(readFooObj.bar3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
