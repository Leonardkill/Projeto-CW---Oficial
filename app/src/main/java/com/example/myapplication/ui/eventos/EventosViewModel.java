package com.example.myapplication.ui.eventos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EventosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EventosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Eventos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}