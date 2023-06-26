package kr.ac.baekseok.for_the_precious_woman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyViewHolder> {

    String data1[],data2[];
    int images[];
    Context context;

    public RecommendAdapter(Context c, String s1[], String s1_1[], int img[]) {
        context = c;
        data1 = s1;
        data2 = s1_1;
        images = img;
    }

    @NonNull
    @Override
    public RecommendAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.rec_cardview, parent, false);
        return new RecommendAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.menstruationText.setText(data1[position]);
        holder.menstruationContents.setText(data2[position]);
        holder.menstruationImage.setImageResource(images[position]);
    } //onBindViewHolder

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView menstruationText,menstruationContents;
        ImageView menstruationImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            menstruationText = itemView.findViewById(R.id.menstruationText);
            menstruationContents = itemView.findViewById(R.id.menstruationContents);
            menstruationImage = itemView.findViewById(R.id.menstruationImage);
        }

    }
}
