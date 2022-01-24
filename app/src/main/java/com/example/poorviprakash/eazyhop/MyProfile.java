package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyProfile extends Fragment {


    private RecyclerView recyclerV;
    private ListAdapter adapter;

    private List<ListItem> listitems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_profile, container, false);


        recyclerV = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerV.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerV.setHasFixedSize(true);
        listitems = new ArrayList<>();

        listitems.add((new ListItem("My Tickets","Current Tickets", R.drawable.ic_confirmation_number_black_24dp)));

        listitems.add((new ListItem("My Pass","Day Pass, Montly Pass", R.drawable.ic_card_membership_black_24dp)));

        listitems.add((new ListItem("My ID","Driving Licenese, BMTC ID", R.drawable.ic_assignment_ind_black_24dp)));

        listitems.add((new ListItem("My Ticket History","Previous purchases", R.drawable.ic_history_black_24dp)));

        adapter = new ListAdapter(listitems, getActivity());
        recyclerV.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String l=listitems.get(position).getHead();
                if(l.equals("My Tickets")){
                    Intent intent=new Intent(getContext(), TicketDisplay.class);
                    startActivity(intent);
                }
                else if(l.equals("My Pass")){
                    Intent intent=new Intent(getContext(), PassDisplay.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }


}
