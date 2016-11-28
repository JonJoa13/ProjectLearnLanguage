/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package db.object.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jon.projectlearnlanguage.R;

import java.util.List;

import db.object.object.Cours;



public class CoursAdapter extends ArrayAdapter<Cours> {

    private final Context context;
    private final List<Cours> courses;

    public CoursAdapter(Context context, List<Cours> courses) {
        super(context,-1,courses);

        this.context = context;
        this.courses = courses;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.simple_list_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tv_list);
        textView.setText(courses.get(position).getTitre()+ " Level : " + courses.get(position).getLevel());

        return rowView;
    }

}
