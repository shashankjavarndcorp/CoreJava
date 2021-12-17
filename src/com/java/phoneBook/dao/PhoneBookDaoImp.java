package com.java.phoneBook.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.phoneBook.db.DBUtility;
import com.java.phoneBook.model.PhoneBook;
import com.java.phoneBook.dao.PhoneBookDao;




public class PhoneBookDaoImp implements PhoneBookDao{
	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;
	
	@Override
	public int createPhoneRecord(PhoneBook entry) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into phonebook_db (name,mobile) values (?,?)";
		pst = db.createPST(sql);
		pst.setString(1, entry.getName());
		pst.setLong(2, entry.getMobile());
		return db.update(pst);
	}
	
	@Override
	public int udpatePhoneRecord(PhoneBook entry) throws SQLException {
		String sql = "update phonebook_db set name=?,mobile=?,where id =?";
		pst = db.createPST(sql);
		pst.setString(1, entry.getName());
		pst.setLong(2, entry.getMobile());
		pst.setInt(3, entry.getId());
		return db.update(pst);
	}

	@Override
	public int deletePhoneRecord(PhoneBook entry) throws SQLException {
		String sql = "delete from phonebook_db where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, entry.getId());
		return db.update(pst);
	}
	
	@Override
	public PhoneBook getPhoneRecordById(int id) throws SQLException {
		String sql = "select * from phonebook_db where id =?";
		pst = db.createPST(sql);
		pst.setInt(1, id);
		rs  = db.query(pst);
		if(rs.next()) {
			PhoneBook entry = new PhoneBook();
			entry.setId(rs.getInt("id"));
			entry.setName(rs.getString("name"));
			entry.setMobile(rs.getLong("mobile"));
			return entry;
		}
		return null;
	}
	
	@Override
	public List<PhoneBook> getRecordByName(String name) throws SQLException {
		
		String sql = "SELECT * FROM phonebook_db WHERE name=?";
		pst = db.createPST(sql);
		pst.setString(1, name);
		rs = db.query(pst);
		List<PhoneBook> contacts = new ArrayList<PhoneBook>();
		while (rs.next()) {
			PhoneBook entry = new PhoneBook();
			entry.setId(rs.getInt("id"));
			entry.setName(rs.getString("name"));
			entry.setMobile(rs.getLong("mobile"));
			contacts.add(entry);
		}
		return contacts;
	}
	
	@Override
	public PhoneBook getPhoneRecordByNumber(Long mobile) throws SQLException {
		String sql = "select * from phonebook_db where mobile =?";
		pst = db.createPST(sql);
		pst.setLong(1, mobile);
		rs  = db.query(pst);
		if(rs.next()) {
			PhoneBook entry = new PhoneBook();
			entry.setId(rs.getInt("id"));
			entry.setName(rs.getString("name"));
			entry.setMobile(rs.getLong("mobile"));
			return entry;
		}
		return null;
	}
	
	@Override
	public List<PhoneBook> getAllPhoneRecords() throws SQLException {
		String sql = "SELECT * FROM phonebook_db";
		pst = db.createPST(sql);
		rs = db.query(pst);
		List<PhoneBook> contacts = new ArrayList<PhoneBook>();
		while (rs.next()) {
			PhoneBook entry = new PhoneBook();
			entry.setId(rs.getInt("id"));
			entry.setName(rs.getString("name"));
			entry.setMobile(rs.getLong("mobile"));
			contacts.add(entry);
		}
		return contacts;
	}

}
