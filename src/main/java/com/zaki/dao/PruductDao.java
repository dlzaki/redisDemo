package com.zaki.dao;

import com.zaki.domain.Pruduct;
import org.springframework.stereotype.Service;

@Service
public class PruductDao {
	
	public Pruduct getPrud(int id) {
		System.out.println("如果没有走到这里，就说明缓存成功了");
		Pruduct p = new Pruduct(id, "name_"+id, "desc_"+id);
		return p;
	}

	public Pruduct getPrud2(int id) {
		System.out.println("如果没有走到这里，就说明缓存成功了");
		Pruduct p = new Pruduct(id, "name_nocache"+id, "nocache");
		return p;
	}

}
