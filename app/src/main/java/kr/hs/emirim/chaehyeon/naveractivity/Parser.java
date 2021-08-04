package kr.hs.emirim.chaehyeon.naveractivity;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Parser {
    //웹에서 요소(제목, 저자, 가격, 이미지)를 검색하여 준비된 BookModel에 저장해서
    //나중에 리스트뷰로 뿌려줄 수 있도록 하는 클래스
    BookModel vo;
    String myQuery = "";  //검색어

    //통신을 위한 메서드
    public ArrayList<BookModel> connectNaver(ArrayList<BookModel> list){

        try {
            myQuery = URLEncoder.encode( MainActivity.search.getText().toString(),"UTF8");
            int count = 100;  //검색결과 100건
            String urlStr = "https://openapi.naver.com/v1/search/book.xml?query=myQuery++&start=1&display="+count;

            //URL클래스를 생성하여 접근할 경로로
            URL url = new URL( urlStr );

            //rul 클래스의 연결 정보를 connection에 전달
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //네이버 api는 get방식을 지원
            connection.setRequestMethod("GET");

            //발급받은 id와 secret인증
            connection.setRequestProperty( "X-Naver-Client-id", "igG5o_cTh3Me66p2eG4T");
            connection.setRequestProperty( "Z-Naver-Client-Secret", "ThZK4CkFZC");

            //위의 URL(인증완료)을 수행해서 받을 자원을 파싱할 객체를 준비


        }catch (Exception e){

        }

        return list;

    }
}

