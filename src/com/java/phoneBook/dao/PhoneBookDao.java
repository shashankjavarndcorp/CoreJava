package com.java.phoneBook.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.phoneBook.model.PhoneBook;

public interface PhoneBookDao {
	
	public int createPhoneRecord(PhoneBook entry) throws SQLException;

	public int udpatePhoneRecord(PhoneBook entry)throws SQLException;

	public int deletePhoneRecord(PhoneBook entry)throws SQLException;

	public PhoneBook getPhoneRecordById(int id)throws SQLException;

	public List<PhoneBook> getRecordByName(String name)throws SQLException;

	public PhoneBook getPhoneRecordByNumber (Long mobile)throws SQLException;

	public List<PhoneBook> getAllPhoneRecords()throws SQLException;

}




