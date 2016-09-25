package com.zachlittle.android.aca.dualfragment;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddressListFragment extends ListFragment{

    private ArrayList<NameAndAddress> mNamesAndAddresses;
    private ActivityComs mActivityComs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNamesAndAddresses = AddressBook.getInstance().getBook();
        AddressListAdapter adapter = new AddressListAdapter(mNamesAndAddresses);
        setListAdapter(adapter);
    }

    private class AddressListAdapter extends ArrayAdapter<NameAndAddress>{
        public AddressListAdapter(ArrayList<NameAndAddress> namesAndAddresses){
            super(getActivity(), R.layout.list_item, namesAndAddresses);
        }

        @Override
        public View getView(int whichItem, View view, ViewGroup viewGroup){
            if(view == null){
                LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
                view = inflater.inflate(R.layout.list_item, null);
            }
            NameAndAddress tempNameAndAddress = getItem(whichItem);
            TextView txtName = (TextView) view.findViewById(R.id.txtName);
            txtName.setText(tempNameAndAddress.getName());

            return view;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivityComs = (ActivityComs)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs = null;
    }


    public void onListItemClick(ListView l, View v, int position, long id){
        Log.i("tag", ""+v);
        mActivityComs.onListItemSelected(position);
    }
}
