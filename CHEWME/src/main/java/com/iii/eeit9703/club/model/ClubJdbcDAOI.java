package com.iii.eeit9703.club.model;

import java.util.List;

public interface ClubJdbcDAOI {
	public void insert(ClubVO clubVO);
	public void update(ClubVO clubVO);
	public void delete(Integer clubId);
	public ClubVO findByPrimaryKey(String clubId);
	public List<ClubVO> getAll();


}
