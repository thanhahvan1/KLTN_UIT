package thanh.ha.gifted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import thanh.ha.gifted.R;
import thanh.ha.gifted.models.Language;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.MyViewHolder> {
    private ArrayList<Language> dataSet;
    private ItemClickListener mClickListener;
    private int currentPosition;


    public LanguageAdapter(Context context, ArrayList<Language> dataSet) {
        this.dataSet = dataSet;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_flag_country)
        ImageView ivFragCountry;
        @BindView(R.id.tv_country)
        TextView tvCountry;
        @BindView(R.id.view_divider)
        View viewDivider;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            currentPosition = getAdapterPosition();
            if (mClickListener != null) {
                mClickListener.onItemClick(currentPosition);
            }
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public LanguageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_language, parent, false);
        return new LanguageAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LanguageAdapter.MyViewHolder holder, final int position) {
        Language language = dataSet.get(position);
        holder.tvCountry.setText(language.getLanguage());
        if (position == dataSet.size() - 1) {
            holder.viewDivider.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }

}