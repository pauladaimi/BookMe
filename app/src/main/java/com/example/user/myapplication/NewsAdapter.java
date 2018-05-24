package com.example.user.myapplication;

/**
 * Created by karimbouyounes on 5/24/18.
 */

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;



        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<Space> spaces = new ArrayList<>();
    private Context context;


    public NewsAdapter(List<Space> spaces, Context context) {
        this.spaces = spaces;
        this.context = context;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        LinearLayout layout;

        public NewsViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title);
            layout = (LinearLayout) itemView.findViewById(R.id.linear_layout);



        }
    }


    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(context).inflate(R.layout.item_news1, parent, false);


        return new NewsAdapter.NewsViewHolder(itemView);

    }



    @Override
    public void onBindViewHolder(final NewsViewHolder holder, final int position) {
        final Space space = spaces.get(position);
        if (space.getInfo().getName() != null) holder.titleTextView.setText(space.getInfo().getName());
        else holder.titleTextView.setText("Test");
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUser.reservedCompanies.add("437's Kitchen");
                Intent e = new Intent(context, BookActivity.class);
                e.putExtra("spaceId",space.getInfo().getId() );
                context.startActivity(e);
            }
        });

    }

    @Override
    public int getItemCount() {
        return spaces.size();
    }

    public void updateNews(List<Space> spaces) {
        this.spaces = spaces;
        Log.w("NEWS ARE U THERE", Integer.toString(spaces.size()));
        notifyDataSetChanged();
    }
}
