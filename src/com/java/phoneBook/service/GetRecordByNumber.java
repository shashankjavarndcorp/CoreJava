package com.java.phoneBook.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.phoneBook.dao.PhoneBookDao;
import com.java.phoneBook.dao.PhoneBookDaoImp;
import com.java.phoneBook.model.PhoneBook;

public class GetRecordByNumber {

	public static void main(String[] args) {
		PhoneBookDao phoneBookDao = new PhoneBookDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to display");
		Long mobile =sc.nextLong();
		try {
			PhoneBook e = phoneBookDao.getPhoneRecordByNumber(mobile);
			
			if(e!=null)
			{
				System.out.println(e.getId()+"\t"+e.getName());

			}
			else {
				
				System.out.println("record not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();

	}

}
