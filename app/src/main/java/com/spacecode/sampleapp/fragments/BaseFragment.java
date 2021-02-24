package com.spacecode.sampleapp.fragments;

import android.support.v4.app.Fragment;

abstract class BaseFragment extends Fragment {
    abstract void initialization();

    abstract void setListener();

    abstract void prepareView();

}
