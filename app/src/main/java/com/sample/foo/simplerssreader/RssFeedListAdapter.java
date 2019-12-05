package com.sample.foo.simplerssreader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by obaro on 27/11/2016.
 */

public class RssFeedListAdapter
        extends RecyclerView.Adapter<RssFeedListAdapter.FeedModelViewHolder> {
    Context context;
    private List<RssFeedModel> mRssFeedModels;




    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        private View rssFeedView;

        public FeedModelViewHolder(View v) {
            super(v);
            rssFeedView = v;
        }
    }

    public RssFeedListAdapter(List<RssFeedModel> rssFeedModels) {
        mRssFeedModels = rssFeedModels;
    }

    @Override
    public FeedModelViewHolder onCreateViewHolder(final ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rss_feed, parent, false);
        final FeedModelViewHolder  holder = new FeedModelViewHolder(v);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(final FeedModelViewHolder holder, int position) {
        final RssFeedModel rssFeedModel = mRssFeedModels.get(position);
        ((TextView)holder.rssFeedView.findViewById(R.id.titleText)).setText(rssFeedModel.title);
        ((TextView)holder.rssFeedView.findViewById(R.id.descriptionText)).setText(rssFeedModel.description);
        ((TextView)holder.rssFeedView.findViewById(R.id.linkText)).setText(rssFeedModel.link);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ItemDetail.class);
                String page_link = ((TextView)holder.rssFeedView.findViewById(R.id.linkText)).getText().toString().trim();
                String page_title = ((TextView)holder.rssFeedView.findViewById(R.id.titleText)).getText().toString().trim();
                intent.putExtra("link", page_link);
                intent.putExtra("title", page_title);
                context.startActivity(intent);
                Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
//                String url = ((TextView)holder.rssFeedView.findViewById(R.id.linkText)).getText().toString().trim();
//                Uri webpage = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//
//                   context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mRssFeedModels.size();
    }
}

