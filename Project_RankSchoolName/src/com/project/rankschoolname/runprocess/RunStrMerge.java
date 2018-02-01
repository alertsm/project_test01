package com.project.rankschoolname.runprocess;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class RunStrMerge {
	
	public HashMap<String,Integer> retMap = null;
	
	public RunStrMerge() {
		retMap = new HashMap<String,Integer>();
	}
	
	/*
	 * Key값의 문자열 뒤부터 잘라 다른 Key로 존재하는지 확인하여 merge하고 다른 Key는 제거
	 */
	public HashMap<String,Integer> getMergeStr(HashMap<String,Integer> readMap) {
		//동기화 가능한 맵으로 변환
		ConcurrentHashMap<String, Integer> dataMap = new ConcurrentHashMap<String, Integer>();
		dataMap.putAll(readMap);
		
		for(String key : dataMap.keySet()) {			
			for(int idxPos=key.length()-1; idxPos > 1 ; idxPos--)	{
				if(dataMap.get(key.substring(0, idxPos)) != null) {
					dataMap.put(key,dataMap.get(key) + dataMap.get(key.substring(0, idxPos)));
					dataMap.remove(key.substring(0, idxPos));
				}
			}
		}
		
		//결과값 리턴
		retMap.putAll(dataMap);
		return retMap;
	}
	
	/*
	 * Key값의 문자열  앞부터 잘라 다른 Key로 존재하는지 확인하여 merge하고 다른 Key는 제거
	 */
	public HashMap<String,Integer> getMergeStrFromStart(HashMap<String,Integer> readMap) {
		//동기화 가능한 맵으로 변환
		ConcurrentHashMap<String, Integer> dataMap = new ConcurrentHashMap<String, Integer>();
		dataMap.putAll(readMap);
		
		for(String key : dataMap.keySet()) {
			for(int idxPos=1; idxPos < key.length() ; idxPos++)	{
				if(dataMap.get(key.substring(idxPos)) != null) {
					dataMap.put(key,dataMap.get(key) + dataMap.get(key.substring(idxPos)));	
					dataMap.remove(key.substring(idxPos));
				}
			}
		}
		
		//결과값 리턴
		retMap.putAll(dataMap);
		return retMap;
	}

}
