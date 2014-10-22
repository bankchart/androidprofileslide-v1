package com.example.profileslide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Contact extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			 Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.contact_fm, container, false);
		return v;
	}	
}
