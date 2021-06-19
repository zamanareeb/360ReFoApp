package com.example.a360refo.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.a360refo.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    GridView mGridView;
    ImageView linkedin;
    ImageView instagram;
    TextView phone;
    TextView mail;
    TextView mail2;


    int[] text = {R.string.internship, R.string.campus_activity, R.string.health_camp, R.string.first_aid, R.string.ican_news, R.string.innovation, R.string.save_plants, R.string.article_writing, R.string.ctm };
    int[] icon = {R.drawable.internship, R.drawable.campus_activities, R.drawable.health_camp, R.drawable.first_aid, R.drawable.ican_news, R.drawable.innovation, R.drawable.brikshabandhan,R.drawable.article_writing, R.drawable.ctm};
    String[] activities_title = {"Internship","Campus Activities","Health Camp","First Aid","I-CAN news","Grassroot Innnovations","Brikshabandhan: To Save Plants","Work with Dr. G. Adilakshmi", "Channa Sattu Machine"};

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView bodyHead = root.findViewById(R.id.homeBodyHead);


        // we are creating array list for storing our image urls.
        ArrayList<HomeViewModel> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = root.findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_1));
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_2));
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_3));
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_4));


        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(getContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setAdapter to sliderView.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(1);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autoCycle below method is used.
        sliderView.startAutoCycle();

        mGridView = root.findViewById(R.id.gridView);
        CustomAdapter customAdapter = new CustomAdapter();
        mGridView.setAdapter(customAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        linkedin = root.findViewById(R.id.linkedIn);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/company/360rf/");
            }
        });

        instagram = root.findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl2("https://www.instagram.com/360_research_foundation/?hl=en");
            }
        });

        phone = root.findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91-9471040714"));
                startActivity(intent);
            }
        });

        mail = root.findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:contact@360rf.in"));
                startActivity(intent);
            }
        });

        mail2 = root.findViewById(R.id.mail2);
        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:hod@360rf.in"));
                startActivity(intent);
            }
        });

        return root;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrl2(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return icon.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.gridview_data, null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.text);
            TextView heading= view1.findViewById(R.id.heading);
            ImageView image = view1.findViewById(R.id.icons);

            name.setText(text[position]);
            image.setImageResource(icon[position]);
            heading.setText(activities_title[position]);
            return view1;
        }
    }
}