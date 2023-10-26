package India.Cultural.Tour.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import India.Cultural.Tour.R;
public class RecyclerFestivalAdapter extends RecyclerView.Adapter<RecyclerFestivalAdapter.ViewHolder> {
    Context context;
    ArrayList<FestivalModel> festivalModelArrayList;
    RecyclerFestivalAdapter(Context context, ArrayList<FestivalModel> festivalModelArrayList){
        this.context=context;
        this.festivalModelArrayList=festivalModelArrayList;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.festival_card, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.imgFestival.setImageResource(festivalModelArrayList.get(position).img);
    holder.festival.setText(festivalModelArrayList.get(position).name);
    holder.desc.setText(festivalModelArrayList.get(position).description);
    }

    @Override
    public int getItemCount() {
        return festivalModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView festival, desc;
        ImageView imgFestival;
        public ViewHolder(View a){
            super(a);
            festival= itemView.findViewById(R.id.Festival_heading);
            desc= itemView.findViewById(R.id.Festival_Description);
            imgFestival=itemView.findViewById(R.id.Festival_image);
        }

    }
}
