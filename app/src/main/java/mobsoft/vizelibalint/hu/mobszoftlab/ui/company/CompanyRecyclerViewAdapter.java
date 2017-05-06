package mobsoft.vizelibalint.hu.mobszoftlab.ui.company;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.category.CategoryActivity;

public class CompanyRecyclerViewAdapter extends RecyclerView.Adapter<CompanyRecyclerViewHolder> {

    private Context mContext;
    private List<Company> mDataSource;

    public CompanyRecyclerViewAdapter(Context context, List<Company> companies){
        mContext = context;
        mDataSource = companies;
    }

    @Override
    public CompanyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View rowView = layoutInflater.inflate(R.layout.recycler_view_list_item, parent, false);
        return new CompanyRecyclerViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(CompanyRecyclerViewHolder holder, int position) {
        final Company company = mDataSource.get(position);
        holder.title_tv.setText(company.getName());
        holder.subtitle_tv.setText(company.getAddress());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CategoryActivity.class);
                intent.putExtra("company", company);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }
}
