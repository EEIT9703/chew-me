package com.iii.eeit9703.member;

import java.util.*;

public interface Mem_interface {
	public void insert(MemVO memVO);
	public void update(MemVO memVO);
    public void delete(String memberId);
    public MemVO findByPrimaryKey(String memberId);
    public List<MemVO> getAll();
}
