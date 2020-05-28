package com.example.a.traintravel.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.a.traintravel.model.TicketInfo;

import java.util.List;

public class TicketInfoAdapter extends RecyclerView.Adapter<TicketInfoAdapter.ViewHolder> {
    /**
     * 数据源
     */
    List<TicketInfo> ticketInfos;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public TicketInfoAdapter(List<TicketInfo> ticketInfos){
        this.ticketInfos=ticketInfos;
    }
}
