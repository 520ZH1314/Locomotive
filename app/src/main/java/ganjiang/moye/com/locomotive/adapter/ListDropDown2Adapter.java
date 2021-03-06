package ganjiang.moye.com.locomotive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ganjiang.moye.com.locomotive.R;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/24.
 */

public class ListDropDown2Adapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private int checkItemPosition = 0;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    public ListDropDown2Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_drop_down, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ViewHolder viewHolder) {
        viewHolder.mText.setText(list.get(position));
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.radio_button_text_pressed));
                viewHolder.mText.setBackgroundResource(R.color.white);
            } else {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.nomal_text));
                viewHolder.mText.setBackgroundResource(R.color.white);
            }
        }
    }

    static class ViewHolder {
        @BindView(R.id.text1)
        TextView mText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

