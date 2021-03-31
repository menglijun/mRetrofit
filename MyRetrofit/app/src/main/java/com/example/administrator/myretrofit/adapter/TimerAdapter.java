package com.example.administrator.myretrofit.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myretrofit.R;

import java.util.List;

public class TimerAdapter extends BaseAdapter {
    private Context context;
    private List<MiaoShaBean> list;
    private long max = 0;
    private boolean flag = true;
    private CountDownTimer cdt=null;

    public TimerAdapter(Context context, List<MiaoShaBean> xlist) {
        this.context = context;
        this.list = xlist;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = new ViewHolder();
        if (convertView == null) {

            convertView = View.inflate(context, R.layout.horizontallistview_item, null);
            vh.discount = convertView.findViewById(R.id.b1_miaosha_discount);
//            vh.img = convertView.findViewById(R.id.b1_miaosha_img);
            vh.name = convertView.findViewById(R.id.b1_miaosha_name);
            vh.time = convertView.findViewById(R.id.b1_miaosha_time);
            vh.price = convertView.findViewById(R.id.b1_miaosha_price);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
//        Glide.with(context).load(list.get(position).goods_img).into(vh.img);

        exeTimer(list.get(position).getEnd_date().equals("已结束")?0:Long.valueOf(list.get(position).getEnd_date()), position);

//        vh.time.setText(list.get(position).getEnd_date().equals("已结束")?"已结束":
//                Date_Utils.longToString(Long.valueOf(list.get(position).getEnd_date())));
        vh.name.setText(list.get(position).getName());
        vh.discount.setText(list.get(position).getTeam_discount()==null? "未打折" : list.get(position).getTeam_discount()+"折");
        vh.price.setText("￥" + list.get(position).getPromote_price());

        return convertView;
    }

    private void exeTimer(long time, final int position) {
        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Log.v("CountDownTimerTest", "onTick millisUntilFinished = " + millisUntilFinished);
                //list.get(position).gmt_end_time = millisUntilFinished + "";
                //notifyDataSetChanged();

            }

            @Override
            public void onFinish() {
                //Log.v("CountDownTimerTest", "onFinish");

//                list.get(position).end_date = "已结束";
                notifyDataSetChanged();

            }
        }.start();

    }

    class ViewHolder {

//        ImageView img;
        TextView time;
        TextView name;
        TextView price;
        TextView discount;

    }

    public class MyCountDownTimer extends CountDownTimer {

        private int position;

        public MyCountDownTimer(long millisInFuture, long countDownInterval, int position) {
            super(millisInFuture, countDownInterval);
            this.position = position;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // Log.v("CountDownTimerTest", "onTick millisUntilFinished = " + millisUntilFinished);

            // Log.v("CountDownTimerTest", "onTick millisUntilFinished = " + millisUntilFinished);
//            list.get(position).end_date = millisUntilFinished + "";
            //if (position == 0) {
            notifyDataSetChanged();
            //}

        }

        @Override
        public void onFinish() {
            //Log.v("CountDownTimerTest", "onFinish");

//            list.get(position).end_date = "已结束";
            notifyDataSetChanged();

        }
    }
}
