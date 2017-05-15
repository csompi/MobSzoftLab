package mobsoft.vizelibalint.hu.mobszoftlab.ui.category;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import mobsoft.vizelibalint.hu.mobszoftlab.R;

public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {

    LinearLayout linearLayout;
    TextView title_tv;
    TextView subtitle_tv;

    public CategoryRecyclerViewHolder(View itemView) {
        super(itemView);

        linearLayout = (LinearLayout) itemView.findViewById(R.id.recycler_view_item);
        title_tv = (TextView) itemView.findViewById(R.id.recycler_title_tv);
        subtitle_tv = (TextView) itemView.findViewById(R.id.recycler_subtitle_tv);
    }
}
