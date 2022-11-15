package com.example.baikt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDestination;
    ArrayList<CongAn> congAnArrayList;
    CongAnAdapter congAnAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        congAnAdapter = new CongAnAdapter(this,R.layout.list_congan, congAnArrayList);
        lvDestination.setAdapter(congAnAdapter);

        lvDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteSach(i);
            }
        });
    }

    private void AnhXa() {
        lvDestination = (ListView) findViewById(R.id.listviewDestination);
        congAnArrayList = new ArrayList<>();
        congAnArrayList.add(new CongAn(R.drawable.img, "Nguyễn Thành An", "Trung úy"," Quảng Ngãi", " 2 sao"));
        congAnArrayList.add(new CongAn(R.drawable.img_1, "Lê Minh ", "Thượng úy"," Nha Trang","3 sao"));
        congAnArrayList.add(new CongAn(R.drawable.img_2, "Trần Minh Tuấn", "Thiếu úy", "Đà Nẵng","1 sao"));
        congAnArrayList.add(new CongAn(R.drawable.img_3, "Tạ Quang Hào", "Trung tá"," Hải Phòng", "2 sao"));
        congAnArrayList.add(new CongAn(R.drawable.img, "Nguyễn Đức Thắng", "Đại tá","Quảng Trị" ,"4 sao"));
        congAnArrayList.add(new CongAn(R.drawable.img_2, "Nguyễn Đình Tiến", "Trung tướng","Hà Nội" ,"2 sao"));

    }


    private void deleteSach(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete TOUR")
                .setMessage("Do you want delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        congAnArrayList.remove(position);
                        congAnAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null)
                .show();
    }
}