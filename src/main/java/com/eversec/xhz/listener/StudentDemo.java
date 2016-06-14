package com.eversec.xhz.listener;

public class StudentDemo {
	public static void main(String[] args) {
		Student s = new Student("张珊珊");
		s.addStudentListener(new StudentListener(){

			@Override
			public void preEat(StudentEvent e) {
				// TODO Auto-generated method stub
				Student s1 = (Student) e.getSource();
				System.out.println(s1.getName()+"好好吃饭");
			}

			@Override
			public void preStudy(StudentEvent e) {
				Student s1 = (Student) e.getSource();
				System.out.println(s1.getName()+"给你一个香吻，你努力学习");
			}
			
		});
		s.Study();
		s.eat();
	}
}
