package com.example.ashi.irrigatedmanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ashi.irrigatedmanager.gson.User;
import com.example.ashi.irrigatedmanager.level2_4.Rain;
import com.example.ashi.irrigatedmanager.level2_4.RainAdapter;
import com.example.ashi.irrigatedmanager.util.Api;
import com.example.ashi.irrigatedmanager.util.HttpUtil;
import com.example.ashi.irrigatedmanager.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Level2_4_3_rain2 extends AppCompatActivity {

    private List<Rain> dataList = new ArrayList<Rain>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_level2_4_3_rain2);

        initData();
        RainAdapter adapter = new RainAdapter(
                Level2_4_3_rain2.this, R.layout.rain_item, dataList);
        listView = (ListView) findViewById(R.id.level_2_4_3_rain_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Level2_4_3_rain2.this, Level2_4_3_rain3.class);
                startActivity(intent);
            }
        });
        addListernerForBackButton();

        getDataFromServerAndUpdateView();
    }

    private void initData() {
        dataList.add(new Rain("柳林总雨量"));
        dataList.add(new Rain("张庄桥总雨量"));
        dataList.add(new Rain("忠楼寺总雨量"));
        dataList.add(new Rain("柳林总雨量"));
        dataList.add(new Rain("张庄桥总雨量"));
    }

    private void addListernerForBackButton() {
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2_4_3_rain2.this, Level2_4_realtimeMonitor2.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getDataFromServerAndUpdateView() {
        String url = Api.API_05_getRainMonitorList;
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final List<Rain> list = Utility.handleApi05RainMonitorListResponse(responseText);
                if ( ! list.isEmpty() ) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ( null != listView ) {
                                RainAdapter adapter = new RainAdapter(
                                        Level2_4_3_rain2.this, R.layout.rain_item, list);
                                listView = (ListView) findViewById(R.id.level_2_4_3_rain_list);
                                listView.setAdapter(adapter);
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }

}
