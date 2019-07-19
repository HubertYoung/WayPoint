package com.candice.waypoint;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFlContaner;
    private TextView mTvJump;
    public WayPointBean[] mWayPointBeans = new WayPointBean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvJump = findViewById(R.id.tv_jump);
        mFlContaner = findViewById(R.id.fl_container);
        final BlankFragment blankFragment = BlankFragment.newInstance("", "");

        final FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        mTvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blankFragment.isAdded()) {
                    beginTransaction.show(blankFragment);
                } else {
                    beginTransaction.add(R.id.fl_container, blankFragment);
                }
                beginTransaction.commit();
                mFlContaner.setVisibility(View.VISIBLE);
                mTvJump.setVisibility(View.GONE);
            }
        });
    }
}
