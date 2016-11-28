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

import db.object.object.Exercise;


public class ExerciceAdapter extends ArrayAdapter<Exercise> {

    private final Context context;
    private final List<Exercise> exercises;

    public ExerciceAdapter(Context context, List<Exercise> exercises) {
        super(context,-1,exercises);

        this.context = context;
        this.exercises = exercises;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.simple_list_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tv_list);
        textView.setText(exercises.get(position).getTitre()+ " " + exercises.get(position).getType());

        return rowView;
    }

}