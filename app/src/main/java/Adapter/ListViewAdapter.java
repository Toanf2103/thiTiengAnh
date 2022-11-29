package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.calculate.R;

import java.util.List;

import Model.Thi;

public class ListViewAdapter extends BaseAdapter {
    private List<Thi> list;
    private Context context;
    private int layout;
    Swap swap;

    public ListViewAdapter(List<Thi> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
        swap = (Swap) context;
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
        return 0;
    }
    private class ViewHolder{
        TextView name;
        TextView congThuc;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.name=convertView.findViewById(R.id.text);
            holder.congThuc=convertView.findViewById(R.id.congThuc);



            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.name.setText(list.get(position).getName());
        holder.congThuc.setText(list.get(position).getCongThuc());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap.swap(list.get(position));
            }
        });

        return convertView;
    }
}
