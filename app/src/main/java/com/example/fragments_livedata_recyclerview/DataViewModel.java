package com.example.fragments_livedata_recyclerview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends ViewModel {

    String info[];
    List<String> stringList=new ArrayList<>();
    MutableLiveData<List<String>> mutableLiveData;

    public DataViewModel() {

        mutableLiveData=new MutableLiveData<>();
    }

//    public MutableLiveData<ArrayList<String>> getUserMutableLiveData(){
        public MutableLiveData<List<String>> getUserMutableLiveData(){

            return mutableLiveData;
//
        }

    public void setMutableLiveData(MutableLiveData<List<String>> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;



    }

    public void setStringList(List<String> stringList) {

        info=new String[stringList.size()];
        for (int i=0; i<stringList.size();i++)
        {
            info[i]=stringList.get(i);
            mutableLiveData.setValue(stringList);

        }

    }
}
