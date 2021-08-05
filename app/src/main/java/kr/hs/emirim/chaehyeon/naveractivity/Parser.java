package kr.hs.emirim.chaehyeon.naveractivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

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
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            //각 요소들을 반복 수행 처리
            int parserEvent = parser.getEventType();

            while ( parserEvent != XmlPullParser.END_DOCUMENT ){
                //문서의 끝을 만날때까지 반복
                if ( parserEvent == XmlPullParser.START_TAG) { //시작태그를 만났을 떄
                    //시작태그의 이름을 가져온다.
                    String tagName = parser.getName();

                    if ( tagName.equalsIgnoreCase( "title")){
                        vo = new BookModel();
                        String title = parser.nextText();  //값
                        vo.setB_title(title);
                    }else if ( tagName.equalsIgnoreCase( "image")){
                        String img = parser.nextText();
                        vo.setB_img( img);
                    }else if ( tagName.equalsIgnoreCase("author")){
                        String author = parser.nextText();
                        vo.setB_author( author);
                    }else if ( tagName.equalsIgnoreCase("price")){
                        String price = parser.nextText();
                        vo.setB_price( price );
                        list.add( vo );
                    }

                }

                parserEvent = parser.next();  //다음 요소

            }// while

        }catch (Exception e){

        }

        //서버를 토애서 가지고 온 자원들이 lsit에 저장되어 있다.
        //이것을 반환
        return list; //add 했으니 여기로 온다.

    }
}

