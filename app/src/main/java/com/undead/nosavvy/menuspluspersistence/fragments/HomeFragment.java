package com.undead.nosavvy.menuspluspersistence.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.undead.nosavvy.menuspluspersistence.R;
import com.undead.nosavvy.menuspluspersistence.adapters.ItemAdapter;
import com.undead.nosavvy.menuspluspersistence.models.Item;
import com.undead.nosavvy.menuspluspersistence.repositories.ItemRepository;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    private static Context context;
    private RecyclerView itemsList;


    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(Context ctx) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        context = ctx;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void refreshList(){
        ItemAdapter adapter = (ItemAdapter) itemsList.getAdapter();
        List<Item> items = ItemRepository.selectNormalAndFavorites();
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        itemsList = (RecyclerView) view.findViewById(R.id.item_list);
        itemsList.setLayoutManager(new LinearLayoutManager(context));
        List<Item> items= ItemRepository.selectNormalAndFavorites();
        itemsList.setAdapter(new ItemAdapter(items));
        return view;
    }

}
