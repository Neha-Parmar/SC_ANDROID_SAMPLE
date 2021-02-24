package com.spacecode.sampleapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sdm.mirrar.mirrar.MirrarFragment;
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
                    JSONObject data = new JSONObject("{\"options\":{\"productData\":{\"Earrings\":{\"items\":[\"500005DMAABA04\",\"20KE10\",\"20KE11\",\"500005SFAABA02\",\"500005SFAABA09\"],\"type\":\"ear\"},\"Mangalsutras\":{\"items\":[\"502118YEEAAA32\",\"502118YENAAA32\",\"502118YEOAAA32\"],\"type\":\"neck\"},\"NecklaceSets\":{\"items\":[\"5027182ADABA02\",\"5027182AJABA02\",\"5027182AKABA02\"],\"type\":\"set\"},\"Necklaces\":{\"items\":[\"502516NFEAAB32_N\",\"CH11\",\"CH12\",\"5027182ADABA02_N\",\"5027182AJABA02_N\"],\"type\":\"neck\"},\"PendantSets\":{\"items\":[\"5031181DXAAA09\",\"5132181BUABA00\",\"5132181BWABA00\"],\"type\":\"set\"},\"Pendants\":{\"items\":[\"500005PFAAAA09\",\"500005PFAAAB22\",\"500006PEAAAA09\"],\"type\":\"neck\"}}}}");
                    fragment = new MirrarFragment("jewel-trace", "2555", data);

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