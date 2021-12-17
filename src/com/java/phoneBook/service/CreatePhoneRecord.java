package com.java.phoneBook.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.phoneBook.dao.PhoneBookDao;
import com.java.phoneBook.dao.PhoneBookDaoImp;
import com.java.phoneBook.model.PhoneBook;

public class CreatePhoneRecord {

	public static void main(String[] args) {
		PhoneBookDao phoneBookDao = new PhoneBookDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name =sc.next();
		System.out.println("Enter the number");
		Long mobile =sc.nextLong();
		PhoneBook pb = new PhoneBook();
		pb.setMobile(mobile);
		pb.setName(name);
		
		try {
			phoneBookDao.createPhoneRecord(pb);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();

		
		

	}

}
