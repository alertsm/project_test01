package com.project.rankschoolname.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortForMap {
	public Map<String, Integer> retMap = null;
	
	public SortForMap() {
		retMap = new LinkedHashMap<String, Integer>();
	}
	
	/* Map<String, Integer> sortByValueAsc : 맵의 값을 기준으로  오름차순으로 정렬
	 * HashMap<String, Integer> dataMap : 정렬할 맵
	 */
	public Map<String, Integer> sortByValueAsc(HashMap<String, Integer> dataMap) {
		List<Map.Entry<String, Integer>> list = new LinkedList<>(dataMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		for(Map.Entry<String, Integer> entry : list) {
			retMap.put(entry.getKey(), entry.getValue());
		}
		return retMap;
	}
	
	/* Map<String, Integer> sortByValueDesc : 맵의 값을 기준으로  내림차순으로 정렬
	 * HashMap<String, Integer> dataMap : 정렬할 맵
	 */
	public Map<String, Integer> sortByValueDesc(HashMap<String, Integer> dataMap) {
		List<Map.Entry<String, Integer>> list = new LinkedList<>(dataMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		for(Map.Entry<String, Integer> entry : list) {
			retMap.put(entry.getKey(), entry.getValue());
		}
		return retMap;
	}

}
