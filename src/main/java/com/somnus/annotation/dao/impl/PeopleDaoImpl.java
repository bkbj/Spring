package com.somnus.annotation.dao.impl;

import org.springframework.stereotype.Repository;
import com.somnus.annotation.dao.PeopleDao;

@Repository
public class PeopleDaoImpl implements PeopleDao {

	public void save(String dialogue) {
		System.out.println(dialogue);
	}

}
