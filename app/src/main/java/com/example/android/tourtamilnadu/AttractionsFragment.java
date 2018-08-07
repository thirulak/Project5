package com.example.android.tourtamilnadu;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends android.support.v4.app.Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

            /* TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.attract1name), getString(R.string.attract1Add), "0265 230 7000", R.drawable.attract1));
        places.add(new Place(getString(R.string.attract2name), getString(R.string.attract2Add), "0265 234 0050", R.drawable.attract2));
        places.add(new Place(getString(R.string.attract3name), getString(R.string.attract3Add), "0265 230 7000", R.drawable.attract3));
        places.add(new Place(getString(R.string.attract4name), getString(R.string.attract4Add), "0265 230 7000", R.drawable.attract4));
        places.add(new Place(getString(R.string.attract5name), getString(R.string.attract5Add), "0265 230 7000", R.drawable.attract5));
        places.add(new Place(getString(R.string.attract6name), getString(R.string.attract6Add), "0265 230 7000", R.drawable.attract6));
        places.add(new Place(getString(R.string.attract7name), getString(R.string.attract7Add), "0265 230 7000", R.drawable.attract7));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
                String url = getString(R.string.mapUrl) + place.getPlaceName() + " " + place.getPlaceAddress();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

