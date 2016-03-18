package xzh.com.materialdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import xzh.com.materialdesign.R;
import xzh.com.materialdesign.ui.DetailsActivity;
import xzh.com.materialdesign.view.CircleImageView;

/**
 * Created by xiangzhihong on 2016/3/2 on 15:41.
 */
public class HomeAdapter extends RecyclerView.Adapter<CellHolder> {

   private Context context;
    private List<String> mList;

    public HomeAdapter(Context context) {
       this.context=context;
        mList = new ArrayList<>();
    }

    @Override
    public CellHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.home_item, viewGroup, false);
        return new CellHolder(view);
    }

    @Override
    public void onBindViewHolder(CellHolder cellHolder, int i) {
         if (getItemCount()%2==1){
             cellHolder.itemCator.setText("热门回答");
         }else {
             cellHolder.itemCator.setText("知乎回答");
         }

       cellHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             context.startActivity(new Intent(context, DetailsActivity.class));
           }
       });

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void add(String s) {
        mList.add(s);
        notifyDataSetChanged();
    }

    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }


}
