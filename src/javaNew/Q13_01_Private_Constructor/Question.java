package javaNew.Q13_01_Private_Constructor;

public class Question {

	private Question() {
		System.out.println("Q");
	}
	
    static class A {
        private A() {
			System.out.println("A");
        }
    }

    static class B extends A {
    	public B() {
			System.out.println("B");
    	}
    }
    
	public static void main(String[] args) {
		new B();
		new Question();
	}

}
