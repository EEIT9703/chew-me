package com.iii.eeit9703.member;

import java.util.*;

public interface Mem_interface {
	public void insert(MemVO memVO);
	public void update(MemVO memVO);
    public void delete(Integer member_Id);
    public MemVO findByPrimaryKey(Integer member_Id);
    public List<MemVO> getAll();
}
