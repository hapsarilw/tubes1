package com.example.tubes1;

import android.widget.ListView;

public interface FragmentListener {
    void changePage(int page);
    void addList(String number);
    void clearList();
}