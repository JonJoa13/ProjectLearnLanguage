package db.object.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jon.projectlearnlanguage.R;

import java.util.List;

import db.object.object.Choice;

/**
 * Created by Jon on 26.11.2016.
 */

public class ChoiceAdapter extends ArrayAdapter<Choice> {

    private final Context context;
    private final List<Choice> choices;

    public ChoiceAdapter(Context context, List<Choice> choices) {
        super(context,-1,choices);

        this.context = context;
        this.choices = choices;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.simple_list_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tv_list);
        textView.setText(choices.get(position).getDescription());

        return rowView;
    }

}