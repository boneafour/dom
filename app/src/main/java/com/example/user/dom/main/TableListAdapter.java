package com.example.user.dom.main;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.dom.R;

import java.util.ArrayList;

public class TableListAdapter extends BaseAdapter implements View.OnClickListener
{
    Activity context;
    ArrayList<String> name;
    ArrayList<String> list;
    ArrayList<String> date;
    ArrayList<String> time;
    ArrayList<String> cook;
    ArrayList<String> role;
    ArrayList<String> list2;
    ArrayList<String> comment;


    public TableListAdapter(Activity context, ArrayList<String> name, ArrayList<String> list, ArrayList<String> date, ArrayList<String> time, ArrayList<String> cook, ArrayList<String> role, ArrayList<String> list2, ArrayList<String> comment) {
        super();
        this.context = context;
        this.name = name;
        this.list = list;
        this.date = date;
        this.time = time;
        this.cook = cook;
        this.role = role;
        this.list2 = list2;
        this.comment = comment;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return name.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    private class ViewHolder {
        TextView txtViewName, txtViewList1, txtViewDate, txtViewTime, txtViewCook,  txtViewRole, txtViewList2, txtViewComment;
        TextView txtViewDescription;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_table_list, null);
            holder = new ViewHolder();
            holder.txtViewName = (TextView) convertView.findViewById(R.id.name);
            holder.txtViewList1 = (TextView) convertView.findViewById(R.id.list);
            holder.txtViewDate = (TextView) convertView.findViewById(R.id.date);
            holder.txtViewTime = (TextView) convertView.findViewById(R.id.time);
            holder.txtViewCook = (TextView) convertView.findViewById(R.id.specialforcook);
            holder.txtViewRole = (TextView) convertView.findViewById(R.id.role);
            holder.txtViewList2 = (TextView) convertView.findViewById(R.id.list2);
            holder.txtViewComment = (TextView) convertView.findViewById(R.id.comment);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtViewName.setText(name.get(position));
        holder.txtViewList1.setText(list.get(position));
        holder.txtViewDate.setText("Дата: "+date.get(position));
        holder.txtViewTime.setText(time.get(position));
        holder.txtViewCook.setText(cook.get(position));
        holder.txtViewRole.setText("Ответственный: "+role.get(position));
        holder.txtViewList2.setText(list2.get(position));
        holder.txtViewComment.setText("Комментарии: "+comment.get(position));

        return convertView;
    }

}