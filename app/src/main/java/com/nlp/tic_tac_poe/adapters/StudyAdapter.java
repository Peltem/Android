package com.nlp.tic_tac_poe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.Study;

import java.util.List;

public class StudyAdapter extends ArrayAdapter<Study> {
    private LayoutInflater inflater;
    private int layout;
    private List<Study> studies;

    public StudyAdapter(Context context, int resource, List<Study> studies) {
        super(context, resource, studies);
        this.studies = studies;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView nameView = view.findViewById(R.id.name);
        TextView chasView = view.findViewById(R.id.chas);

        Study study = studies.get(position);

        nameView.setText(study.getName());
        chasView.setText(Integer.toString(study.getChas()));

        return view;
    }

}
