package com.example.user.dom.main;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.dom.R;

import java.util.ArrayList;

public class ContactListAdapter extends BaseAdapter implements View.OnClickListener
{
    Activity context;
    ArrayList<String> name;
    ArrayList<String> role;
    ArrayList<String> phone;
    ArrayList<String> comment;


    public ContactListAdapter(Activity context, ArrayList<String> name, ArrayList<String> role, ArrayList<String> phone, ArrayList<String> comment) {
        super();
        this.context = context;
        this.name = name;
        this.role = role;
        this.phone = phone;
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
        TextView txtViewName, txtViewRole, txtViewPhone,  txtViewComment;
        TextView txtViewDescription;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_contact_list, null);
            holder = new ViewHolder();
            holder.txtViewName = (TextView) convertView.findViewById(R.id.name);
            holder.txtViewRole = (TextView) convertView.findViewById(R.id.role);
            holder.txtViewPhone = (TextView) convertView.findViewById(R.id.phone);
            holder.txtViewComment = (TextView) convertView.findViewById(R.id.comment);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtViewName.setText(name.get(position));
        holder.txtViewRole.setText(role.get(position));
        holder.txtViewPhone.setText(phone.get(position));
        holder.txtViewComment.setText(comment.get(position));

        return convertView;
    }

}