package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvID;
    private TextView tvDescription;
    private TextView tvDate;

    public CustomAdapter(Context context, int resource,
                                 ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the ArrayList of objects passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    // getView() is called every time for every row
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        tvID = rowView.findViewById(R.id.textViewID);
        tvDescription = rowView.findViewById(R.id.textViewDescription);
        tvDate = rowView.findViewById(R.id.textViewDate);

        Task currentTask = task.get(pos);
        tvID.setText(String.valueOf(currentTask.getId()));
        tvDescription.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        return rowView;
    }

}
