package io.devlight.cocktailapp.ui;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class SearchTextWatcher implements TextWatcher {
    private String text;

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
        text = s.subSequence(start,start+count).toString();
        onSearch(text);

    }

    abstract void onSearch(String text);

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub

    }

}
