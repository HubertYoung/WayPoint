package com.candice.waypoint;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * <br>
 * <p>
 * <p>
 * com.candice.waypoint
 * <p>
 * FUXI
 */
public class WayPointBean {

    public LinearLayout llWayPoint;
    public TextView tvWayPoint;
    public ImageView ivWayPoint;

    public WayPointBean( LinearLayout llWayPoint, TextView tvWayPoint ) {
        this.llWayPoint = llWayPoint;
        this.tvWayPoint = tvWayPoint;
    }

    public WayPointBean() {

    }

    public void setTitle( String title ) {
        this.tvWayPoint.setText( title );
    }

    public void setVisible( boolean visible ) {
        llWayPoint.setVisibility( visible ? View.VISIBLE : View.GONE );
    }
    public boolean getVisible() {
        return llWayPoint.isShown();
    }
    public String getTitle() {
        return tvWayPoint.getText().toString();
    }
}
