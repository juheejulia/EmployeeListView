package com.example.employeelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    public EmployeeAdapter(Context context, List employees) {
        super(context, 0, employees);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Create View object from the new layout .xml
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitem_employee, parent, false);
        }

        // Call employee object from the list
        Employee employee = getItem(position);

        // Update the ViewObject with data from the list-object
        TextView tv = view.findViewById(R.id.textViewName);
        tv.setText(employee.toString());

        return view;
    }
}
