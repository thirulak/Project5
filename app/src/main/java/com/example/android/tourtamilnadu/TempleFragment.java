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
public class TempleFragment extends android.support.v4.app.Fragment {


    public TempleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

            /* TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.temple1Name), getString(R.string.temple1Add), "0265 230 7000", R.drawable.temple1));
        places.add(new Place(getString(R.string.temple2Name), getString(R.string.temple2Add), "0265 234 0050", R.drawable.temple2));
        places.add(new Place(getString(R.string.temple3Name), getString(R.string.temple3Add), "0265 230 7000", R.drawable.temple3));
        places.add(new Place(getString(R.string.temple4Name), getString(R.string.temple4Add), "0265 230 7000", R.drawable.temple4));
        places.add(new Place(getString(R.string.temple5Name), getString(R.string.temple5Add), "0265 230 7000", R.drawable.temple5));
        places.add(new Place(getString(R.string.temple6Name), getString(R.string.temple6Add), "0265 230 7000", R.drawable.temple6));
        places.add(new Place(getString(R.string.temple7Name), getString(R.string.temple7Add), "0265 230 7000", R.drawable.temple7));

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
