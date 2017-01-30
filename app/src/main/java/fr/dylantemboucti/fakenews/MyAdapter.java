package fr.dylantemboucti.fakenews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

/**
 * Created by kyotsunee on 30/01/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<FakeNews> list = FakeNewsList.all;
    public Context context;

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FakeNews fakeNews = (FakeNews) list.get(position);
        holder.display(fakeNews);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        private FakeNews currentNews;

        public MyViewHolder(final View itemView) {
            super(itemView);

            title = ((TextView) itemView.findViewById(R.id.title));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, NewsContent.class);
                    myIntent.putExtra("title", currentNews.title);
                    myIntent.putExtra("content", currentNews.htmlContent);
                    context.startActivity(myIntent);
                }
            });
        }

        public void display(FakeNews fakeNews) {
            currentNews = fakeNews;
            title.setText(currentNews.title);
        }
    }

}
