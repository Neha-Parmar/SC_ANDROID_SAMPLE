package com.spacecode.sampleapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sdm.mirrar.library.MirrarFragment;
import com.spacecode.sampleapp.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LauncherFragment extends BaseFragment {

    private View view;
    private Button btnLaunch;
    MirrarFragment fragment;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_launcher, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialization();
        setListener();
        prepareView();
    }

    @Override
    void initialization() {
        btnLaunch = view.findViewById(R.id.launchMirrar);

    }

    @Override
    void setListener() {
        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject data = new JSONObject("{\"options\":{\"productData\":{\"Earrings\":{\"items\":[\"Earring2\",\"Earring3\"],\"type\":\"ear\"},\"Necklaces\":{\"items\":[\"Necklace1\",\"Necklace4\"],\"type\":\"neck\"},\"Rings\":{\"items\":[\"Ring2\",\"Ring4\"],\"type\":\"finger\"},\"Bracelets\":{\"items\":[\"Bracelet3\",\"Bracelet2\"],\"type\":\"wrist\"}}}}");
                    fragment = new MirrarFragment(data, "jewel-trace", "2555");

                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

                    transaction.replace(R.id.container_layout, fragment).commit();
                    btnLaunch.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    void prepareView() {

    }
}