package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.ablyeden.R;


///**
// * A simple {@link Fragment} subclass.
// * Use the {@link TabTodayFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class TabTodayFragment extends Fragment {

    View view;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public TabTodayFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment TabTodayFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static TabTodayFragment newInstance(String param1, String param2) {
//        TabTodayFragment fragment = new TabTodayFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("투데이 불러오기","투데이 불러오기");
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab_today, null);

        Log.d("연결하고 난뒤","연결하고 난뒤");

//        ArrayList<String> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
//        data.add("https://upload.wikimedia.org/wikipedia/en/thumb/2/24/SpongeBob_SquarePants_logo.svg/1200px-SpongeBob_SquarePants_logo.svg.png");
//        data.add("http://nick.mtvnimages.com/nick/promos-thumbs/videos/spongebob-squarepants/rainbow-meme-video/spongebob-rainbow-meme-video-16x9.jpg?quality=0.60");
//        data.add("http://nick.mtvnimages.com/nick/video/images/nick/sb-053-16x9.jpg?maxdimension=&quality=0.60");
//        data.add("https://www.gannett-cdn.com/-mm-/60f7e37cc9fdd931c890c156949aafce3b65fd8c/c=243-0-1437-898&r=x408&c=540x405/local/-/media/2017/03/14/USATODAY/USATODAY/636250854246773757-XXX-IMG-WTW-SPONGEBOB01-0105-1-1-NC9J38E8.JPG");
//
//        autoViewPager = view.findViewById(R.id.autoViewPager);
//        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(getActivity(),data);
//        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
//        autoViewPager.setInterval(5000); // 페이지 넘어갈 시간 간격 설정
//        autoViewPager.startAutoScroll(); //Auto Scroll 시작


        return view;
    }
}
