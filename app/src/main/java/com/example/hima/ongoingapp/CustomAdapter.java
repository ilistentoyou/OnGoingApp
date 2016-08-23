package com.example.hima.ongoingapp;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Hima on 8/22/2016.
 */
public class CustomAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Context c, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=c;
        imageId=prgmImages;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    static class Holder
    {
        TextView tv;
        ImageView img;



    }
    @Override
    public View getView( int position,  View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        Holder holder=new Holder();
        View rowView;

        if(convertView==null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder.tv = (TextView) convertView.findViewById(R.id.textView1);
            holder.img = (ImageView) convertView.findViewById(R.id.imageView1);
            convertView.setTag(holder);

        }

        else

        {
           holder=(Holder) convertView.getTag();
        }




        holder.tv.setText(result[position]);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "Pokemon Solid.ttf");
        holder.tv.setTypeface(tf);
        holder.img.setImageResource(imageId[position]);

        int lastPosition =-1;

        Animation anime= AnimationUtils.loadAnimation(context,(position>lastPosition ?R.anim.down_from_top : R.anim.up_from_down));
        convertView.startAnimation(anime);
        lastPosition= position;



        return convertView;
    }

}
