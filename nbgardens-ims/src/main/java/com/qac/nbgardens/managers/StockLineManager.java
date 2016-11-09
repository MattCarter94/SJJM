package com.qac.nbgardens.managers;


import java.util.List;
import com.qac.nbgardens.entities.StockLine;

public interface StockLineManager 
{
	public List<StockLine> findAll(Integer selectID);
	
}

