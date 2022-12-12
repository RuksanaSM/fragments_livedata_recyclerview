package com.example.fragments_livedata_recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {


    private DataViewModel viewModel;
    EditText ename;
    List<String> dataModelList=new ArrayList<String>();
    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root= inflater.inflate(R.layout.fragment_one, container, false);

       ename=root.findViewById(R.id.ename);

        viewModel= ViewModelProviders.of(requireActivity()).get(DataViewModel.class);
        Button send=root.findViewById(R.id.save);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enameStr=ename.getText().toString();
//                String eaddressStr=eaddress.getText().toString();

                if(TextUtils.isEmpty(enameStr))
                {
                    ename.setError("enter details");
                }
//                if(TextUtils.isEmpty(eaddressStr))
//                {
//                    eaddress.setError("enter details");
//                }
                else
                {
                    dataModelList.add(enameStr);
//                    loadData();
                 savedata();
//                    dataModelList.add(eaddressStr);

////////////////////////====
                  //  viewModel.setStringList(dataModelList);


                   // Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_SHORT).show();

                }

            }
        });

        return root;
    }

    private void savedata() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();


        Gson gson = new Gson();
        String json = gson.toJson(dataModelList);

        editor.putString("courses", json);
        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
        // after saving data we are displaying a toast message.
        Toast.makeText(getActivity(), "Saved in shared", Toast.LENGTH_SHORT).show();
    }


}