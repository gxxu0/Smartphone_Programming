package kr.ac.baekseok.for_the_precious_woman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class tipAdapter extends RecyclerView.Adapter<tipAdapter.MyViewHolder> {

    String data1[];
    int images[];
    Context context;



    public tipAdapter(Context c, String s1[], int img[]){
        context = c;
        data1 = s1;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.tip_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.pcuText.setText(data1[position]); //pms >> pcuText
        holder.pcuImage.setImageResource(images[position]); //pms >> pcuImage



        holder.pcuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()){
                    case 0:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ehclinic.com/news/lecture_v.asp?srno=10018&page=1&gubun=&keyword="));
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://hosp.ajoumc.or.kr/HealthInfo/DiseaseView.aspx?ai=775&cp=1&sid="));
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://ehclinic.com/news/news_v.asp?srno=19750&page=70&gubun=&keyword="));
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.jaseng.co.kr/etc/healthInfoView.asp?Location_Branch_Code=10013&idx=1151&Location_Branch_Code=10013"));
                        context.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://jiaen.co.kr/sub/jmboard/qna_view.php?board_number=21"));
                        context.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://yswobgy.com/bbs/board.php?bo_table=10_1&wr_id=1"));
                        context.startActivity(intent5);
                        break;
                    default:
                        break;
                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pcuText;  //pms >> pcuText
        ImageView pcuImage; //pms >> pcuImage


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pcuText = itemView.findViewById(R.id.PcuText);  //pms >> pcuText
            pcuImage = itemView.findViewById(R.id.PcuImage); //pms >> pcuImage


        }
    }
}