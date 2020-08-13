package vanskarner.android.communutilidades.iu.so.mediastore;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vanskarner.android.communutilidades.R;

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.MyViewHolder> {
    private List<Bitmap> imagesList=new ArrayList<>();
    private OnClickListener listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.item_image,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bitmap bitmap=imagesList.get(position);
        holder.imvItem.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public void updateList(List<Bitmap> itemList) {
        this.imagesList = itemList;
        notifyDataSetChanged();
    }

    public void deleteImages(){
        this.imagesList.clear();
        notifyDataSetChanged();
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imvItem;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imvItem=itemView.findViewById(R.id.imvItem);
            imvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClickItem();
                    }
                }
            });
        }
    }

    public static AdapterPhotos createInstance(List<Bitmap> list){
        AdapterPhotos instance=new AdapterPhotos();
        instance.updateList(list);
        return instance;
    }

    interface OnClickListener{
        void onClickItem();
    }
}
