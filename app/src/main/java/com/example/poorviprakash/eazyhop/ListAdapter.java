package com.example.poorviprakash.eazyhop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    private onItemClickListener mListener;
    int i=0,size;
    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener=listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageViewIcon;
        public ViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);

            imageViewIcon=(ImageView) itemView.findViewById(R.id.IGV1);
            textViewHead = (TextView) itemView.findViewById(R.id.listText1);
            textViewDesc = (TextView) itemView.findViewById(R.id.listSubText1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener !=null ){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ListAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(i<getItemCount()) {
            ListItem listItem = listItems.get(position);

            holder.imageViewIcon.setImageResource(listItem.getImg());
            holder.textViewHead.setText(listItem.getHead());
            holder.textViewDesc.setText(listItem.getDesc());
            i++;
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}

