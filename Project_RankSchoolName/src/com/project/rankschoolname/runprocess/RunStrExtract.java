package com.project.rankschoolname.runprocess;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunStrExtract {
	public HashMap<String,Integer> retMap = null;
	
	public RunStrExtract() {
		retMap = new HashMap<String,Integer>();
	}
	
	/* getPatternStr : 학교이름찾기
	 * String ptn : 졍규식 패턴
	 * String str : 패턴에 매칭될 문자열
	 */
	public HashMap<String,Integer> getPatternStr(String ptn, String str) {
		Pattern pat = Pattern.compile(ptn);
		Matcher mat = pat.matcher(str);
		String retStr = "";
		
		while(mat.find()) {
			//매칭 문자열 저장
			retStr=mat.group();
			
			//정규식 패턴에 매칭된 문자열 중 반복된 문자열일 경우 전체를 찾기 때문에 분리하여 카운터 하는 로직 추가
			while(retStr.indexOf(retStr.substring(0,2),1) > 0) {
				
				//두번째 반복되는 문자열의 시작자리
				int idxRetStr=retStr.indexOf(retStr.substring(0,2),1); 
				
				//다시 찾은 문자열을 맵에서 매칭하여 카운터
				String tmpRetStr = retStr.substring(0,idxRetStr);

				if(retMap.get(tmpRetStr) == null) {
					retMap.put(tmpRetStr, 1);
				} else {
					retMap.put(tmpRetStr,retMap.get(tmpRetStr)+1);
				}

				
				//재처리를 위한 나머지 문자열 저장
				retStr=retStr.substring(idxRetStr); 
			}
			
			//맵에서 매칭문자 카운터
			if(retMap.get(retStr) == null) {
				retMap.put(retStr, 1);
			} else {
				retMap.put(retStr,retMap.get(retStr)+1);
			}
		}
		return retMap;
	}
	
}
