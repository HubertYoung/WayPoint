package com.candice.waypoint;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnSetWayPoint;
    private ListView lvList;


    // TODO: Rename and change types of parameters
    private String index;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<String> mStringList;
    private String mItemContent;
    private MainActivity mActivity;

    public BlankFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();


        if (getArguments() != null) {
            index = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        if (mStringList == null) {
            mStringList = new ArrayList<>();
        }
        for (int i = 0; i < 50; i++) {
            mStringList.add("第" + i + "item");
        }
        btnSetWayPoint = (Button) view.findViewById(R.id.btn_set_way_point);
        lvList = (ListView) view.findViewById(R.id.lv_list);
        lvList.setAdapter(new ListAdapter(getActivity(), mStringList));
        btnSetWayPoint.setOnClickListener(this);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mItemContent = mStringList.get(position);
                backLastPage(mItemContent);

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
//        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set_way_point:
                backLastPage(mItemContent);
                break;
        }
    }

    private void backLastPage(String itemContent) {
        FragmentTransaction beginTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        beginTransaction.hide( this );
        Fragment blankFragment1 = mActivity.getSupportFragmentManager().findFragmentByTag( "blankFragment" );
        beginTransaction.show( blankFragment1 );
        beginTransaction.commitAllowingStateLoss();
        ((BlankFragment)blankFragment1).updateUI(itemContent,index);
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
        void onFragmentInteraction(Uri uri);
    }
}
