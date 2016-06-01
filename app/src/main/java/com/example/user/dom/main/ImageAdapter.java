package com.example.user.dom.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.dom.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] main = { "Готовка","Уборка","Стирка","Контакты", "Список планов" };
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        View grid;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            grid = new View(mContext);
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            grid = inflater.inflate(R.layout.cellgrid, parent, false);





           /* imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(18, 18, 18, 18);*/
        } else {
            grid = (View) convertView;
        }
         imageView = (ImageView) grid.findViewById(R.id.cell_image);
        TextView textView = (TextView) grid.findViewById(R.id.cell_text);
        imageView.setImageResource(mThumbIds[position]);
        textView.setText(main[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(18, 18, 18, 18);
        textView.setPadding(18, 18, 18, 18);

        return grid;

    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.cook22, R.drawable.clean22, R.drawable.wash22, R.drawable.contact33, R.drawable.table22,

    };
}