package com.java.phoneBook.service;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import com.java.phoneBook.dao.PhoneBookDao;
import com.java.phoneBook.dao.PhoneBookDaoImp;
import com.java.phoneBook.model.PhoneBook;

public class GetRecordByName {
	public static void main(String[] args) {
		PhoneBookDao phoneBookDao = new PhoneBookDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to display");
		String name =sc.next();
		try {
			List<PhoneBook> e = phoneBookDao.getRecordByName(name);
			
			if(e!=null)
			{
				 System.out.println("Current list : " + e);
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
