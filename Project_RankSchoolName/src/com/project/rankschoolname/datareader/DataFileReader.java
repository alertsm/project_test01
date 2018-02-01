package com.project.rankschoolname.datareader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.lucene.analysis.ko.KoreanAnalyzer;

import com.project.rankschoolname.runprocess.RunStrExtract;

public class DataFileReader implements IDataReader {
	public String readData = "";
	public String ptn = null;
	
	public DataFileReader(String ptn) {
		this.ptn = ptn;
	}
	public void setPtn(String ptn) {
		this.ptn = ptn;
	}
	public String getPtn() {
		return ptn;
	}
	
	
	/* HashMap<String,Integer> getData : 파일을 읽어 패턴과 매칭된 문자열을 맵으로 반환
	 * String filename : 파일경로+파일명
	 */
	public HashMap<String,Integer> getData(String filename) {
		HashMap<String,Integer> retMap = new HashMap<String,Integer>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
			RunStrExtract findPtnExt = new RunStrExtract();
			
			//파일을 줄단위로 읽어 패턴가 매칭되는 문자들을 맵에 담아 반환
			while((readData = br.readLine()) != null) {
				
				//형태소분석
				KoreanAnalyzer analyzer = new KoreanAnalyzer();
				//패턴 매칭 문자열 검색
				retMap.putAll(findPtnExt.getPatternStr(ptn, readData));
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return retMap;
	}	
}
