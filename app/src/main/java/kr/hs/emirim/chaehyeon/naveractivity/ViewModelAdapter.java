package kr.hs.emirim.chaehyeon.naveractivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ViewModelAdapter extends ArrayAdapter<BookModel> {

    Context context;
    ArrayList<BookModel> list;
    BookModel vo;
    int resource;

    public ViewModelAdapter(@NonNull Context context, int resource, ArrayList<BookModel>list) {
        super(context, resource, list);

        this.list = list;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater linf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = linf.inflate(resource, null);
        
        //리스트뷰에 표현할 책 정보 객체
        vo = list.get(position);

        TextView title = convertView.findViewById(R.id.book_title);
        TextView author = convertView.findViewById(R.id.book_author);
        TextView price = convertView.findViewById(R.id.book_price);
        TextView img = convertView.findViewById(R.id.book_img);

        title.setText("title :" + vo.getB_title());
        author.setText("author :" + vo.getB_author());
        price.setText("price :" + vo.getB_price());

        return convertView;
    }//getVIew()

    //통신을 통해 이미지를 로드할 Async클래ㅡㅅ
    class ImgAsync extends AsyncTask<String, String, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

        }
    }
}
