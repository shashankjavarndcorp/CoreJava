package com.java.phoneBook.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.phoneBook.dao.PhoneBookDao;
import com.java.phoneBook.dao.PhoneBookDaoImp;
import com.java.phoneBook.exceptions.DuplicateNameException;
import com.java.phoneBook.exceptions.DuplicateNumberException;
import com.java.phoneBook.model.PhoneBook;

public class UpdateRecord {

	public static void main(String[] args) {
		PhoneBookDao phoneBookDao = new PhoneBookDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to update");
		int id =sc.nextInt();
		System.out.println("Enter the updated name");
		String name =sc.next();
		System.out.println("Enter the updated number");
		Long mobile =sc.nextLong();
		try {
			PhoneBook e = phoneBookDao.getPhoneRecordById(id);
			
			if(e!=null)
			{
				System.out.println(e.getId()+"\t"+e.getName());
				if (e.getMobile()==mobile) {
					sc.close();
					throw new DuplicateNumberException("same number is added");
				}
				else if (e.getName()==name) {
					sc.close();
					throw new DuplicateNameException("duplicate name is added");
				}
				else {
					e.setMobile(mobile);
					e.setName(name);
					e.setId(id);
					phoneBookDao.udpatePhoneRecord(e);
					System.out.println("record updated");
				}

			}
			else {
				System.out.println("record not found");
			}
			
		}
		catch (DuplicateNumberException e) {
			e.printStackTrace();
		}
		catch (DuplicateNameException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		sc.close();
	}

}
