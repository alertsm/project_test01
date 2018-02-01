package com.project.rankschoolname.runprocess;

import com.project.rankschoolname.datareader.IDataReader;
import com.project.rankschoolname.util.SortForMap;
import com.project.rankschoolname.datareader.DataFileReader;
import com.project.rankschoolname.datareader.DataStringReader;

import java.util.HashMap;
import java.util.Map;

public class RankSchoolRunProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ptn = "[가-횧|가-훟]{1,}[남자|여자|예술]?(대학교|고등학교|중학교|초등학교)";
//		String ptn = "[가-횧|가-훟]{1,}[남자|여자|예술]?(대|고|중|초)";
		
		IDataReader datareader = null;
		SortForMap sortForMap = new SortForMap();
		
//		String targetstr1 = "서울 구로구 개봉중학교 서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교????????????????????";
//		datareader = new DataStringReader(ptn);
//		prtMap(datareader.getData(targetstr1));
//		String targetstr = "배달이형님 춘천 후평중학교";
//		datareader = new DataStringReader(ptn);
//		HashMap<String, Integer> retPtnMap = datareader.getData(targetstr);

		//파일을 읽어 패턴과 매칭되는 문자를 맵에 저장
		datareader = new DataFileReader(ptn);
		HashMap<String, Integer> retPtnMap = datareader.getData("resource/comments.csv");

		//매칭된 결과 문자를 정규화하여 Merge
		RunStrMerge runStrMerge = new RunStrMerge();
		HashMap<String, Integer> retMergeMap = runStrMerge.getMergeStrFromStart(retPtnMap);

		//Merge된 맵을 Value값으로 내림차순 정렬	
		Map<String, Integer> retSortedMap = sortForMap.sortByValueDesc(retMergeMap);

		//Map출력
		prtMap(retSortedMap);
	}
	
	public static void prtMap(Map<String, Integer> dataMap) {
		for(String key : dataMap.keySet()) {
			System.out.println(key+"\t"+dataMap.get(key));
		}
	}

}
