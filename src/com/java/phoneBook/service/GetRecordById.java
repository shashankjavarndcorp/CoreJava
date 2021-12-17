package com.java.phoneBook.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.phoneBook.dao.PhoneBookDao;
import com.java.phoneBook.dao.PhoneBookDaoImp;
import com.java.phoneBook.model.PhoneBook;

public class GetRecordById {
	public static void main(String[] args) {
		PhoneBookDao phoneBookDao = new PhoneBookDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to display");
		int id =sc.nextInt();
		try {
			PhoneBook e = phoneBookDao.getPhoneRecordById(id);
			
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
