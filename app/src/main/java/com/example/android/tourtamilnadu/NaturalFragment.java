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
public class NaturalFragment extends android.support.v4.app.Fragment {


    public NaturalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

            /* TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.natural1Name), getString(R.string.natural1Add), "0265 230 7000", R.drawable.natural1));
        places.add(new Place(getString(R.string.natural2Name), getString(R.string.natural2Add), "0265 234 0050", R.drawable.natural2));
        places.add(new Place(getString(R.string.natural3Name), getString(R.string.natural3Add), "0265 230 7000", R.drawable.natural3));
        places.add(new Place(getString(R.string.natural4Name), getString(R.string.natural4Add), "0265 230 7000", R.drawable.natural4));
        places.add(new Place(getString(R.string.natural5Name), getString(R.string.natural5Add), "0265 230 7000", R.drawable.natural5));
        places.add(new Place(getString(R.string.natural6Name), getString(R.string.natural6Add), "0265 230 7000", R.drawable.natural6));
        places.add(new Place(getString(R.string.natural7Name), getString(R.string.natural7Add), "0265 230 7000", R.drawable.natural7));

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


