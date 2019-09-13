package com.example.tubes1;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements FragmentListener{
    FragmentManager fragmentManager;


    CalculatorFragment calculatorFragment;
    AddFragment addFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calculatorFragment = new CalculatorFragment();
        this.addFragment = new AddFragment();


        this.fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container, this.calculatorFragment).addToBackStack(null).commit();

        this.changePage(1);
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page == 1){
            if(this.calculatorFragment.isAdded()){
                ft.show(this.calculatorFragment);
            }else{
                ft.add(R.id.fragment_container, this.calculatorFragment);
            }
            if(this.addFragment.isAdded()){
                ft.hide(this.addFragment);
            }
        }else if(page == 2){
            if(this.addFragment.isAdded()){
                ft.show(this.addFragment);
            }else {
                ft.add(R.id.fragment_container, this.addFragment);
            }
            if(this.calculatorFragment.isAdded()){
                ft.hide(this.calculatorFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void clearList() {
        this.calculatorFragment.itemList.clear();
        this.calculatorFragment.adapter.notifyDataSetChanged();
    }

    @Override
    public void addList(String number) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        this.calculatorFragment.itemList.add(new Item(number));
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.addFragment.etOperand.getWindowToken(), 0);
        ft.commit();
    }
}
