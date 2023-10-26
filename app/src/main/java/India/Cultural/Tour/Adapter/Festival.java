package India.Cultural.Tour.Adapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import India.Cultural.Tour.R;

public class Festival extends AppCompatActivity {
    ArrayList<FestivalModel> arrFestivals= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        RecyclerView recyclerView = findViewById(R.id.Recycler_Festival);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrFestivals.add(new FestivalModel(R.drawable.diwali,"Diwali", "This festival symbolizes the victory of light over darkness." ));
        arrFestivals.add(new FestivalModel(R.drawable.holi,"Holi", "This festival celebrates the arrival of spring and the victory of good over evil." ));
        arrFestivals.add(new FestivalModel(R.drawable.durgapuja,"Durgapuja", "Durga Puja is a celebration of the goddess Durga." ));
        arrFestivals.add(new FestivalModel(R.drawable.navratri,"Navrati", "Navratri is a festival dedicated to the worship of the Hindu deity Durga." ));
        arrFestivals.add(new FestivalModel(R.drawable.baisakhi,"baisakhi", "Baisakhi is a harvest festival celebrated in the Punjab region." ));
//        arrFestivals.add(new FestivalModel(R.drawable.onam,"Onam", "Onam is a harvest festival celebrated in the state of Kerala." ));
        arrFestivals.add(new FestivalModel(R.drawable.ganesh,"GANESH CHATURTI", "Ganesh Chaturthi is a festival celebrating the birth of Lord Ganesha." ));
        arrFestivals.add(new FestivalModel(R.drawable.janmastmi,"Janmastmi", "Janmashtami is a festival celebrating the birth of Lord Krishna." ));
        arrFestivals.add(new FestivalModel(R.drawable.shivratri,"Shivratri", "Shivratri is a festival dedicated to the worship of Lord Shiva." ));
        arrFestivals.add(new FestivalModel(R.drawable.lohri,"Lohri", "Lohri is a Punjabi festival celebrated to mark the end of winter." ));


    RecyclerFestivalAdapter adapter=new RecyclerFestivalAdapter(this, arrFestivals);
    recyclerView.setAdapter(adapter);

    }
}
