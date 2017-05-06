package mobsoft.vizelibalint.hu.mobszoftlab.ui.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewHolder> {

    private Context mContext;
    private List<Category> categoryList;

    public CategoryRecyclerViewAdapter(Context context, List<Category> categories){
        mContext = context;
        categoryList = categories;
    }

    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View rowView = layoutInflater.inflate(R.layout.recycler_view_list_item, parent, false);
        return new CategoryRecyclerViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(CategoryRecyclerViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.title_tv.setText(category.getName());
        String subtitle = "Applicants waiting: " + category.getSeqNumbers().size();
        holder.subtitle_tv.setText(subtitle);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
