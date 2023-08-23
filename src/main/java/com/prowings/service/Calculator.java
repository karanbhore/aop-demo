package com.prowings.service;

import java.lang.System.Logger;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public void print() {
		System.out.println("inside print method!!");
		System.out.println("__________________________");
	}
	
	public void addition(int a,int b) {
		System.out.println("inside addition int ,int");
		System.out.println("addition is :"+(a+b));
		System.out.println("__________________________");
	}
	public void addition(long a,long b) {
		System.out.println("inside addition long ,long");
		System.out.println("addition is :"+(a+b));
		System.out.println("__________________________");
	}
	
	public Integer sum(int a,int b) throws InterruptedException {
		System.out.println("inside sum (int ,int");
		System.out.println("addition is :"+(a+b));
		Thread.sleep(5000);
		System.out.println("a+b ="+(a+b));
		System.out.println("__________________________");
		return a+b;
	}
	
	
	
	
}
