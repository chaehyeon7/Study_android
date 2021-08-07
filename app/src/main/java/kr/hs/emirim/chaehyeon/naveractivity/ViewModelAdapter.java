package kr.hs.emirim.chaehyeon.naveractivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
        return convertView;
    }
}
