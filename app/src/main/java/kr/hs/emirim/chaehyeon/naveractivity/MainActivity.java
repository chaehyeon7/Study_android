package kr.hs.emirim.chaehyeon.naveractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static EditText search;
    ListView myListView;
    Button search_btn;
    Parser parser;
    ArrayList<BookModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        myListView = findViewById(R.id.myListView);
        search_btn = findViewById(R.id.search_btn);
        parser = new Parser();

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list = new ArrayList<>();
                // parser.connectNaver( lsit );  사용 불가
                new NaverAsync().execute("홍", "길","동");   //doInBackground메서드 호출

            }
        });
    }//onCreate()

    /*
    AsyncTask 클래스는 생성시에 세계의 제너릭타입을 갖는다.
    1. doInBackground()의 차라미터로 전달될 타입
    2. UI의 진행강황을 관리하는 onProgressUpdate()가 오버라이딩 되어 있다면, 이 메서드에서 사용할 타입
    3. 작업 결과를 반영하는 onPostExecute의 파라미터로 전달될 타입
     */

    class NaverAsync extends AsyncTask<String, String, ArrayList<BookModel>>{

        @Override
        protected ArrayList<BookModel> doInBackground(String... strings) {

            //strings[0] -> "홍"
            //strings[1] -> "길"
            //strings[2] -> "동"

            //필수!! 각종 반복이나 제어등 주된 처리 로직을 담당
            return parser.connectNaver( list );
//            return parser.connectNaver( list, string[0] );  두개 처리 가능
        }

        @Override
        protected void onPostExecute(ArrayList<BookModel> bookModels) {
            //dolnBackGround를 통해 완료된 작업 결과를 처리
            for (int i=0; i<bookModels.size(); i++){

                Log.i("MY", bookModels.get(i).getB_title() );

            }

        }
    }//NaverAsync
}