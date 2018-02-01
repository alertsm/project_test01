package com.project.rankschoolname.datareader;

import java.util.HashMap;

import com.project.rankschoolname.runprocess.RunStrExtract;

public class DataStringReader implements IDataReader {
	public String readData = "";
	public String ptn = null;
	
	public DataStringReader(String ptn) {
		this.ptn = ptn;
	}
	public void setPtn(String ptn) {
		this.ptn = ptn;
	}
	public String getPtn() {
		return ptn;
	}
	public HashMap<String,Integer> getData(String str) {
		HashMap<String,Integer> retMap = new HashMap<String,Integer>();
		RunStrExtract findPtnExt = new RunStrExtract();
		System.out.println("str="+str);
		
		retMap.putAll(findPtnExt.getPatternStr(ptn, str));
		System.out.println("retMap in DataStringReader="+retMap);
		return retMap;
	}
}
