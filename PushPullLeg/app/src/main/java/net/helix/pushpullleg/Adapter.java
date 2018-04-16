package net.helix.pushpullleg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static net.helix.pushpullleg.R.drawable.batmangrey;
import static net.helix.pushpullleg.R.layout.list_element_layout;

public class Adapter extends BaseAdapter {

    private Context mContext;
    private static ArrayList<Elements> mElementList;

    public Adapter(Context context, int simple_list_item_1){
        mContext = context;
        mElementList = new ArrayList<Elements>();
    }

    public void addExercise(Elements elements){
        mElementList.add(elements);
        notifyDataSetChanged();
    }

    public void removeExercise(int position){
        mElementList.remove(position);
        notifyDataSetChanged();
    }

    public static ArrayList<Elements> getList(){
        return mElementList;
    }

    @Override
    public int getCount() {
        return mElementList.size();
    }

    @Override
    public Object getItem(int position) {
        Object returnElement = null;
        try{
            returnElement = mElementList.get(position);
        }catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        return returnElement;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        public ImageView imageView = null;
        public TextView exerciesName = null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(list_element_layout,null);
            ViewHolder holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.image_icon);
            holder.exerciesName = (TextView) view.findViewById(R.id.exercise_name);
            view.setTag(holder);
        }

        Elements mElement = (Elements) getItem(position);
        final ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.exerciesName.setText(R.string.middle_chest);

        return view;
    }
}
