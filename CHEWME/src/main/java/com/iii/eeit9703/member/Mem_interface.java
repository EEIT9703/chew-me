package com.iii.eeit9703.member;

import java.util.*;

public interface Mem_interface {
	public void insert(ClubVO memVO);
	public void update(ClubVO memVO);
    public void delete(String memberId);
    public ClubVO findByPrimaryKey(String memberId);
    public List<ClubVO> getAll();
}
