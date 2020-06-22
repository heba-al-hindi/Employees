package com.example.employees.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employees.R;
import com.example.employees.databinding.ItemEmployeeBinding;
import com.example.employees.models.response.Employee;

import java.util.ArrayList;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder> {


    private Context context;
    private ArrayList<Employee> employees;
    private EmployeeClickListener mEmployeeClickListener;

    public EmployeesAdapter(Context context, ArrayList<Employee> employees,EmployeeClickListener employeeClickListener) {
        this.context = context;
        this.employees = employees;
        mEmployeeClickListener = employeeClickListener ;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view,mEmployeeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        Employee response = employees.get(position);
        // bind views
        holder.tvEmployeeName.setText(response.getName());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemEmployeeBinding itemEmployeeBinding;

        private TextView tvEmployeeName;

        EmployeeClickListener employeeClickListener;

        public EmployeeViewHolder(@NonNull View itemView, EmployeeClickListener employeeClickListener) {
            super(itemView);
            tvEmployeeName = itemView.findViewById(R.id.tv_employee_name);
            this.employeeClickListener = employeeClickListener;

            itemView.setOnClickListener(this);
        }

        // onClick
        @Override
        public void onClick(View v) {
            employeeClickListener.onEmployeeClicked(getAdapterPosition());
        }
    }

    public interface EmployeeClickListener {

        void onEmployeeClicked(int position);

    }
}
