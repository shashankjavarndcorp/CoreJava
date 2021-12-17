package com.java.phoneBook.service;

import java.sql.SQLException;
import java.util.List;

import com.java.phoneBook.dao.PhoneBookDao;
import com.java.phoneBook.dao.PhoneBookDaoImp;
import com.java.phoneBook.model.PhoneBook;

public class ListAllRecord {

	public static void main(String[] args) {
		PhoneBookDao phoneBookDao = new PhoneBookDaoImp();

		try {
			List<PhoneBook> e = phoneBookDao.getAllPhoneRecords();
			
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

	}

}
