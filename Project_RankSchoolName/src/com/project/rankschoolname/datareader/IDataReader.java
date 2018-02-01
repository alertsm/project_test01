package com.project.rankschoolname.datareader;

import java.util.HashMap;

public interface IDataReader {
	public String ptn = null;
	public void setPtn(String ptn);
	public String getPtn();
	public HashMap<String,Integer> getData(String str);
}
