package db.object.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jon.projectlearnlanguage.R;

import java.util.List;

import db.object.object.User;

/**
 * Created by Jon on 26.11.2016.
 */

public class UserAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final List<User> users;

    public UserAdapter(Context context, List<User> users) {
        super(context, -1, users);
        this.context = context;
        this.users = users;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.simple_list_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tv_list);
        textView.setText(users.get(position).getName()+ " " + users.get(position).getFirstname());

        return rowView;
    }

}