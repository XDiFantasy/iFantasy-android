package xyz.egoistk21.iFantasy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.egoistk21.iFantasy.R;
import xyz.egoistk21.iFantasy.bean.RawPlayer;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private Context mContext;
    private List<RawPlayer> mRawPlayers;

    public GalleryAdapter(Context context, List<RawPlayer> players) {
        mContext = context;
        mRawPlayers = players;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gallery_item, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.setData(mRawPlayers.get(position));
    }

    @Override
    public int getItemCount() {
        return mRawPlayers.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_major)
        ImageView ivMajor;
        @BindView(R.id.iv_player)
        ImageView ivPlayer;
        @BindView(R.id.tv_player)
        TextView tvPlayer;

        GalleryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setData(RawPlayer rawPlayer) {
            tvPlayer.setText(rawPlayer.getName());
        }
    }
}
