package com.example.tubes1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements View.OnClickListener {
    Spinner spinner;
    EditText etOperand;
    Button btnSubmit;

    FragmentListener fragmentListener;

    ;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        this.spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);

        this.etOperand = view.findViewById(R.id.et_operand);

        this.btnSubmit = view.findViewById(R.id.btn_submit);
        this.btnSubmit.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View view) {

        if(view.getId() == this.btnSubmit.getId()){
            String op = spinner.getSelectedItem().toString();
            String x = etOperand.getText().toString();
            String input = op + x;
            this.fragmentListener.changePage(1);
            this.fragmentListener.addList(input);
            this.etOperand.setText("");
        }

    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener =(FragmentListener)context;
        }else{
            throw new ClassCastException(context.toString()
                    + "must implements Fragment Listener");
        }
    }


}
