package com.besttime.ui.adapters.viewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besttime.R;

public class ContactsViewHolder extends RecyclerView.ViewHolder {


    private RelativeLayout parentView;
    private TextView contactNameTextView;
    private Button whatsappRedirectButton;

    public ContactsViewHolder(@NonNull RelativeLayout itemView) {
        super(itemView);

        this.parentView = itemView;
        contactNameTextView = itemView.findViewById(R.id.contactNameTextView_itemView);
        whatsappRedirectButton = itemView.findViewById(R.id.whatsappRedirectButton_itemView);
    }

    public void setContactName(String contactName){
        contactNameTextView.setText(contactName);
    }

    public void setActive(boolean isActive){
        if(isActive != this.isActive())
        {
            parentView.setActivated(isActive);
            if(isActive){
                whatsappRedirectButton.setVisibility(View.VISIBLE);
            }
            else{
                whatsappRedirectButton.setVisibility(View.GONE);
            }
        }
    }


    public ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        ItemDetailsLookup.ItemDetails<Long> itemDetails = new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                return getAdapterPosition();
            }

            @Override
            public Long getSelectionKey() {
                return (long)getAdapterPosition();
            }
        };

        return itemDetails;
    }

    public boolean isActive() {
        return parentView.isActivated();
    }
}
