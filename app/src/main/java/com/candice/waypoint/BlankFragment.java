package com.candice.waypoint;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //    private TextView tvBack;
//    private RelativeLayout rlWayPointRoot;
    private RelativeLayout rlWayRoot;
    private LinearLayout llStartPoint;
    private ImageView ivBig0;
    private TextView tvStartPoint;
    private LinearLayout llOvalSmall;
    //    private ImageView smallOvalButton0;
//    private ImageView smallOvalButton1;
//    private ImageView smallOvalButton2;
//    private ImageView smallOvalButton3;
    private LinearLayout llWayPoint1;
    private ImageView ivWayPoint1;
    private TextView etWayPoint1;
    private LinearLayout llWayPoint2;
    private ImageView ivWayPoint2;
    private TextView etWayPoint2;
    private LinearLayout llWayPoint3;
    private ImageView ivWayPoint3;
    private TextView etWayPoint3;
    private LinearLayout llEndPoint;
    private ImageView ivBig1;
    private TextView tvEndPoint;
    private TextView tvWayPoint;
    private ImageView ivSwitch;
    private ImageView ivAddWayPoint;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    //    private FrameLayout mFlBlankFragmwnt;
    private MainActivity mActivity;
//    private LinearLayout[] mMLayouts;
//    private TextView[] mTextViews;

    public BlankFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance( String param1, String param2 ) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        mActivity = ( MainActivity ) getActivity();

        if ( getArguments() != null ) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_blank, container, false );
        initView( view );
        return view;
    }

    private void initView( View view ) {
//        tvBack = (TextView) view.findViewById(R.id.tv_back);
//        rlWayPointRoot = (RelativeLayout) view.findViewById(R.id.rl_way_point_root);
        rlWayRoot = ( RelativeLayout ) view.findViewById( R.id.rl_way_root );
        llStartPoint = ( LinearLayout ) view.findViewById( R.id.ll_start_point );
        ivBig0 = ( ImageView ) view.findViewById( R.id.iv_big0 );
        tvStartPoint = ( TextView ) view.findViewById( R.id.tv_start_point );
        llOvalSmall = ( LinearLayout ) view.findViewById( R.id.ll_oval_small );
//        smallOvalButton0 = (ImageView) view.findViewById(R.id.small_oval_button_0);
//        smallOvalButton1 = (ImageView) view.findViewById(R.id.small_oval_button_1);
//        smallOvalButton2 = (ImageView) view.findViewById(R.id.small_oval_button_2);
//        smallOvalButton3 = (ImageView) view.findViewById(R.id.small_oval_button_3);
        //途经点1 UI
        llWayPoint1 = ( LinearLayout ) view.findViewById( R.id.ll_way_point1 );
        ivWayPoint1 = ( ImageView ) view.findViewById( R.id.iv_way_point1 );
        etWayPoint1 = ( TextView ) view.findViewById( R.id.et_way_point1 );
        //途经点1 UI
        llWayPoint2 = ( LinearLayout ) view.findViewById( R.id.ll_way_point2 );
        ivWayPoint2 = ( ImageView ) view.findViewById( R.id.iv_way_point2 );
        etWayPoint2 = ( TextView ) view.findViewById( R.id.et_way_point2 );
        //途经点1 UI
        llWayPoint3 = ( LinearLayout ) view.findViewById( R.id.ll_way_point3 );
        ivWayPoint3 = ( ImageView ) view.findViewById( R.id.iv_way_point3 );
        etWayPoint3 = ( TextView ) view.findViewById( R.id.et_way_point3 );
        llEndPoint = ( LinearLayout ) view.findViewById( R.id.ll_end_point );
        ivBig1 = ( ImageView ) view.findViewById( R.id.iv_big1 );
        tvEndPoint = ( TextView ) view.findViewById( R.id.tv_end_point );
        tvWayPoint = ( TextView ) view.findViewById( R.id.tv_way_point );
        ivSwitch = ( ImageView ) view.findViewById( R.id.iv_switch );
        ivAddWayPoint = ( ImageView ) view.findViewById( R.id.iv_add_way_point );
//        mFlBlankFragmwnt = view.findViewById(R.id.fl_blank_fragment);
        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            WayPointBean wayPointBean = new WayPointBean();
            if ( i == 0 ) {
                wayPointBean.llWayPoint = llWayPoint1;
                wayPointBean.tvWayPoint = etWayPoint1;
                wayPointBean.ivWayPoint = ivWayPoint1;
            } else if ( i == 1 ) {
                wayPointBean.llWayPoint = llWayPoint2;
                wayPointBean.tvWayPoint = etWayPoint2;
                wayPointBean.ivWayPoint = ivWayPoint2;
            } else if ( i == 2 ) {
                wayPointBean.llWayPoint = llWayPoint3;
                wayPointBean.tvWayPoint = etWayPoint3;
                wayPointBean.ivWayPoint = ivWayPoint3;
            }
            wayPointBean.setVisible( false );
            mActivity.mWayPointBeans[ i ] = wayPointBean;
        }
        registerListener();

//        mMLayouts = new LinearLayout[]{llWayPoint1, llWayPoint2, llWayPoint3};
//        mTextViews = new TextView[]{etWayPoint1, etWayPoint2, etWayPoint3};
    }

    private void registerListener() {
//        tvBack.setOnClickListener(this);
        ivAddWayPoint.setOnClickListener( this );
        ivSwitch.setOnClickListener( this );

        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            if ( mActivity.mWayPointBeans != null ) {
                mActivity.mWayPointBeans[ i ].tvWayPoint.setOnClickListener( this );
                mActivity.mWayPointBeans[ i ].ivWayPoint.setOnClickListener( this );
            }
        }
//        ivWayPoint1.setOnClickListener(this);
//        ivWayPoint2.setOnClickListener(this);
//        ivWayPoint3.setOnClickListener(this);
//        etWayPoint1.setOnClickListener(this);
//        etWayPoint2.setOnClickListener(this);
//        etWayPoint3.setOnClickListener(this);
        tvWayPoint.setOnClickListener( this );

    }

    public void onButtonPressed( Uri uri ) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach( Context context ) {
        super.onAttach( context );
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick( View v ) {
        switch ( v.getId() ) {
            case R.id.iv_switch:
                switchWayPoint();
                break;
            case R.id.iv_add_way_point:
                addWayPoint();
                break;
            case R.id.iv_way_point1:
                //删除途经点1
                deleteWayPoint( 0 );
                break;
            case R.id.iv_way_point2:
                //删除途经点2
                deleteWayPoint( 1 );
                break;
            case R.id.iv_way_point3:
                //删除途经点3
                deleteWayPoint( 2 );
                break;
//            case R.id.tv_back:
//                break;
            case R.id.tv_way_point:
                addWayPoint();
                break;
            case R.id.et_way_point1:
                //跳转到搜索页面添加途经点
                jumpBlankFragment2(0);
                break;
            case R.id.et_way_point2:
                //跳转到搜索页面添加途经点
                jumpBlankFragment2(1);
                break;
            case R.id.et_way_point3:
                //跳转到搜索页面添加途经点
                jumpBlankFragment2(2);
                break;
        }
    }

    /**
     * 切换数据
     * 起始点 我不处理
     */
    private void switchWayPoint() {
        ArrayList< Integer > list = new ArrayList<>();
        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            if ( mActivity.mWayPointBeans != null ) {
                WayPointBean wayPointBean = mActivity.mWayPointBeans[ i ];
                boolean shown = wayPointBean.llWayPoint.isShown();
                if ( shown ) {
                    list.add( i );
                }
            }
        }
        // TODO: 2019-07-23 数量需要优化，采用递归swap
        /**
         * 1 2 3 ┅ 1 2 ┅ 1 2 3 4 ┅ 1 2 3 4 5
         * ┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈
         * 3 2 1 ┅ 2 1 ┅ 4 3 2 1 ┅ 5 4 3 2 1
          */
        String cacheStr = null;
        if ( list.size() == 2){
            Integer integer = list.get( 0 );
            Integer integer1 = list.get( 1 );
            cacheStr = mActivity.mWayPointBeans[integer.intValue()].getTitle();
            mActivity.mWayPointBeans[integer.intValue()].setTitle( mActivity.mWayPointBeans[integer1.intValue()].getTitle() );
            mActivity.mWayPointBeans[integer1.intValue()].setTitle( cacheStr );
        }else if ( list.size() == 3 ){
            Integer integer = list.get( 0 );
            Integer integer1 = list.get( list.size() - 1 );
            cacheStr = mActivity.mWayPointBeans[integer.intValue()].getTitle();
            mActivity.mWayPointBeans[integer.intValue()].setTitle( mActivity.mWayPointBeans[integer1.intValue()].getTitle() );
            mActivity.mWayPointBeans[integer1.intValue()].setTitle( cacheStr );
        }
    }

    private void deleteWayPoint( int index ) {

        WayPointBean pointBean = mActivity.mWayPointBeans[ index ];
        pointBean.tvWayPoint.setText( "" );
        pointBean.setTitle( null );
        pointBean.setVisible( false );
        count--;
//        ivAddWayPoint.setClickable(true);
//        ivAddWayPoint.setEnabled(true);
        int shownCount = 0;
        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            if ( mActivity.mWayPointBeans != null ) {
                WayPointBean wayPointBean = mActivity.mWayPointBeans[ i ];
                boolean shown = wayPointBean.llWayPoint.isShown();
                if ( shown ) {
                    shownCount++;
                    wayPointBean.tvWayPoint.setHint( mActivity.getResources().getString( R.string.input_way_point ) + shownCount );
                }
            }
        }
        ivAddWayPoint.setVisibility( shownCount == mActivity.mWayPointBeans.length ? View.GONE : View.VISIBLE );

        llOvalSmall.setVisibility( shownCount == mActivity.mWayPointBeans.length ? View.VISIBLE : View.GONE );
    }

    private boolean isDelete = false;

    private void addWayPoint() {
//        if (isDelete) {
//            llWayPoint1.setVisibility(View.GONE);
//            llWayPoint2.setVisibility(View.GONE);
//            llWayPoint3.setVisibility(View.GONE);
//        }
        int shownCount = 0;
        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            WayPointBean wayPointBean = mActivity.mWayPointBeans[ i ];
            LinearLayout mLayout = wayPointBean.llWayPoint;
            if ( mLayout.getVisibility() == View.GONE ) {
                mLayout.setVisibility( View.VISIBLE );
                if ( i < mActivity.mWayPointBeans.length - 1 ) {
                    break;
                }
            }
            if ( mLayout.isShown() ) {
                shownCount++;
            }
        }
        int shownCount2 = 0;
        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            if ( mActivity.mWayPointBeans != null ) {
                WayPointBean wayPointBean = mActivity.mWayPointBeans[ i ];
                boolean shown = wayPointBean.llWayPoint.isShown();
                if ( shown ) {
                    shownCount2++;
                    wayPointBean.tvWayPoint.setHint( mActivity.getResources().getString( R.string.input_way_point ) + shownCount2 );
                }
            }
        }

        ivAddWayPoint.setVisibility( shownCount == mActivity.mWayPointBeans.length ? View.GONE : View.VISIBLE );
        //添加途经点
        tvWayPoint.setVisibility( View.GONE );
        llOvalSmall.setVisibility( View.GONE );
    }

    private void jumpBlankFragment2( int index ) {
        BlankFragment2 blankFragment2 = BlankFragment2.newInstance( index +"", "" );
        FragmentTransaction beginTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        if ( blankFragment2.isAdded() ) {
            beginTransaction.show( blankFragment2 );
        } else {
            beginTransaction.add( R.id.fl_container, blankFragment2, "blankFragment2" );
        }
        beginTransaction.hide( this );
        beginTransaction.commitAllowingStateLoss();
//        rlWayPointRoot.setVisibility(View.GONE);
//        tvBack.setVisibility(View.GONE);
//        mFlBlankFragmwnt.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHiddenChanged( boolean hidden ) {
        super.onHiddenChanged( hidden );
        if ( hidden == false ) {
            if ( currentClickIndex != -1 ){
                WayPointBean wayPointBean = mActivity.mWayPointBeans[ currentClickIndex ];
                wayPointBean.setTitle( itemContent );
                itemContent = null;
                currentClickIndex = -1;
            }

//            mFlBlankFragmwnt.setVisibility( View.GONE );
//            rlWayPointRoot.setVisibility( View.VISIBLE );
//            tvBack.setVisibility( View.VISIBLE );
            String wayPoint = showWayPoint();
            // 显示经几个途经点,这块逻辑需要根据添加的途经点个数来显示
            if ( TextUtils.isEmpty( wayPoint ) ) {
                tvWayPoint.setVisibility( View.GONE );
            } else {
                tvWayPoint.setText( "经" + count + "地" + wayPoint );
                tvWayPoint.setVisibility( View.VISIBLE );
            }
//        if (count == 3) {
//            ivAddWayPoint.setClickable(false);
//            ivAddWayPoint.setEnabled(false);
//        } else {
//            ivAddWayPoint.setClickable(true);
//            ivAddWayPoint.setEnabled(true);
//        }
            Log.e( "TAG", "count-->" + count );
//            llWayPoint1.setVisibility( View.GONE );
//            llWayPoint2.setVisibility( View.GONE );
//            llWayPoint3.setVisibility( View.GONE );
//            llOvalSmall.setVisibility( View.VISIBLE );
        }
    }

    private String itemContent = null;
    private int currentClickIndex = -1;

    public void updateUI( String itemContent, String index ) {
        this.itemContent = itemContent;
        try {
            this.currentClickIndex = Integer.valueOf( index);
        } catch ( NumberFormatException e ) {
            this.currentClickIndex = -1;
        }

    }

    private StringBuffer mStringBuffer = new StringBuffer();
    private int count;

    private String showWayPoint() {
        count = 0;
        mStringBuffer.delete( 0, mStringBuffer.length() );
        for ( int i = 0; i < mActivity.mWayPointBeans.length; i++ ) {
            WayPointBean wayPointBean = mActivity.mWayPointBeans[ i ];
            if ( wayPointBean != null && !TextUtils.isEmpty( wayPointBean.getTitle() ) ) {
                mStringBuffer.append( wayPointBean.getTitle() );
                count++;
            }
        }

        return mStringBuffer.toString();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction( Uri uri );
    }
}
