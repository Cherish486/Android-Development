package com.example.addresslist.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.example.addresslist.R;
import com.example.addresslist.adapter.LiaisonAdapter;
import com.example.addresslist.entity.Liaison;

public class MainActivity extends AppCompatActivity {
    private List<Liaison> liaisons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLiaisons();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LiaisonAdapter adapter = new LiaisonAdapter(liaisons);
        recyclerView.setAdapter(adapter);
    }

    private void initLiaisons() {
        liaisons.add(new Liaison("张三", "13245768913"));
        liaisons.add(new Liaison("李四", "13553716289"));
        liaisons.add(new Liaison("王五", "18456789876"));
        liaisons.add(new Liaison("赵六", "17616229988"));
        liaisons.add(new Liaison("小白", "17623145741"));
        liaisons.add(new Liaison("小黑", "13848194140"));
    }
}